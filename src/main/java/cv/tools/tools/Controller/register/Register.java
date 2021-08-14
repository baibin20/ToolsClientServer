package cv.tools.tools.Controller.register;


import com.alibaba.fastjson.JSON;
import cv.tools.tools.Entity.Result;
import cv.tools.tools.Entity.StatusCode;
import cv.tools.tools.Service.Register.RegisterService;
import cv.tools.tools.Utils.aliyunmessage.MainMessage;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

import static cv.tools.tools.Utils.aliyunmessage.MainMessage.getVerificationCode;

@RestController
@ResponseBody
@RequestMapping("/")   // 请求进来的大的路径啊
public class Register {
    private String codeVerify  = "123456";

    @Autowired
    private RegisterService registerService;

    @PostMapping("/getCode")
    public String getCode(@RequestBody String str ){
        String message = new MainMessage().getVerificationCode(str.replace("\"",""));

        String code[] = message.split("\\+");
        if (code[0].equals("1")) {
            codeVerify = code[1].toString();
            return JSON.toJSONString(new Result(true, StatusCode.OK, "发送成功"));
        }
        else
            return JSON.toJSONString(new Result(true, StatusCode.ERROR,"发送失败"));
    }

    @PostMapping("/register")
    public String register(@RequestBody HashMap hashMap) {
        String userName = hashMap.get("username").toString();
        String passWord = hashMap.get("password").toString();
        String phone = hashMap.get("phone").toString();
        String code = hashMap.get("code").toString();
        if (code.equals(codeVerify.substring(9, 15))) {
            int flag =  registerService.register(userName,passWord,phone,code);
            if (flag == 1)
                return JSON.toJSONString(new Result(true, StatusCode.OK, "注册成功"));
            else
                return JSON.toJSONString(new Result(true, StatusCode.ERROR, "已注册此用户"));
        } else
            return JSON.toJSONString(new Result(true, StatusCode.ERROR, "验证码不对"));
    }
}
