package cv.tools.tools.Controller;

import cv.tools.tools.Domin.User;
import cv.tools.tools.Entity.Result;
import cv.tools.tools.Entity.StatusCode;
import cv.tools.tools.Service.UserLoginServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.List;

@RestController
@ResponseBody
@RequestMapping("/")   // 请求进来的大的路径
public class UserLogin {

    @Autowired
    private UserLoginServer userLoginServer;

    /**
     * 登录接口
     * @param user
     * @return
     */
    @CrossOrigin(origins = "*",maxAge = 3600)
    @PostMapping("/login")
    public String login(@RequestBody HashMap data) {
        User user = new User();
        user.setUser_name((String)data.get("username"));
        user.setUser_password((String)data.get("password"));
        try {
            if(user.getUser_password() != null && user.getUser_name() != null){
                List userList = userLoginServer.userLogin(user);
                if (userList == null || userList.size() == 0){
                    return JSON.toJSONString(new Result(false,StatusCode.ERROR,"请求失败"));
                }else {
                    return JSON.toJSONString(new Result(true,StatusCode.OK,"请求成功"));
                }
            }else {
                return JSON.toJSONString(new Result(false,StatusCode.ERROR,"请求失败"));
            }
        }catch (Exception ex){
            System.out.println("输入的用户名和密码为空或者实体类为空");
            System.out.println(ex);
        }
        return JSON.toJSONString(new Result(false,StatusCode.ERROR,"请求失败"));
    }
}
