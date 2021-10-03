package cv.tools.tools.Controller.Jobpalletbind;

import com.alibaba.fastjson.JSON;
import cv.tools.tools.Entity.Result;
import cv.tools.tools.Entity.StatusCode;
import cv.tools.tools.Service.Jobpalletbind.findInstallJpbpPalletBindSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.HashMap;


/**
 * 查找需要插入绑定表的数据
 */
@RestController
@ResponseBody
@RequestMapping("/findInstallJpbpPalletBind")   // 请求进来的大的路径啊
public class FindInstallJpbpPalletBind {

    @Autowired
    private findInstallJpbpPalletBindSer  findInstallJpbpPalletBindSer;

    // 查询物料类别
    @PostMapping("/findCodeCategry")
    public String findCodeCategry(){
        if (findInstallJpbpPalletBindSer.findCodeCategry().equals(null))
            return JSON.toJSONString(new Result(false,StatusCode.ERROR,"未找到物料类别"));
        else
            return JSON.toJSONString(new Result(true, StatusCode.OK,"查询成功",findInstallJpbpPalletBindSer.findCodeCategry()));
    }

    // 查询保管区域
    @PostMapping("/findCodeStorage")
    public String findCodeStorage(){
        if(findInstallJpbpPalletBindSer.findCodeStorage().equals(null))
            return JSON.toJSONString(new Result(false,StatusCode.ERROR,"未找到保管区域"));
        else
            return JSON.toJSONString(new Result(true, StatusCode.OK,"查询成功",findInstallJpbpPalletBindSer.findCodeStorage()));
    }

    // 提交的数据
    @PostMapping("/submit")
    public String submit(@RequestBody HashMap data) throws SQLException, ClassNotFoundException {
        if (findInstallJpbpPalletBindSer.submit(data).size() > 0 ){
            return JSON.toJSONString(new Result(false,StatusCode.OK,"生成成功"));
        }else {
            return JSON.toJSONString(new Result(false,StatusCode.ERROR,"未生成数据或QR码表中没有QR码"));
        }
    }
}
