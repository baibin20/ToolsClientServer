package cv.tools.tools.Controller.SocketCtl;

import com.alibaba.fastjson.JSON;
import cv.tools.tools.Domin.AddDeviceDomin;
import cv.tools.tools.Entity.Result;
import cv.tools.tools.Entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@ResponseBody
@RequestMapping("/Cv")   // 请求进来的大的路径啊
public class CvShowCtl {

    @Autowired
    private cv.tools.tools.Service.Cv.CvShowSer cvShowSer;

    @GetMapping("/shouCvTable")
    public String shouCvTable(){
        List<AddDeviceDomin> list = cvShowSer.showCvTableSer();
        List list1 = new ArrayList();
        Map map = new HashMap();
        for (int i = 0; i < list.size(); i++) {
            list1.add(list.get(i).getDevice_num());
        }
        map.put("key",list1);
        map.put("label",list1);
        return JSON.toJSONString(new Result(true, StatusCode.OK,"添加成功",map));
//        return list;
    }
}
