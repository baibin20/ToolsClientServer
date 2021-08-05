package cv.tools.tools.Controller;
import cv.tools.tools.Domin.FileReadDomin;
import cv.tools.tools.Entity.Result;
import cv.tools.tools.Entity.StatusCode;
import cv.tools.tools.Service.FilePathService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@ResponseBody
@RequestMapping("/Reviced")   // 请求进来的大的路径
public class FilePathController {
    // 需要导入的模板
    @Autowired   // 导入数据库模板
    private JdbcTemplate jdbcTemplate;
    @Autowired   // 导入数据库模板
    private FilePathService filePathService;

    //Demo 测试能否请求到这里
    @RequestMapping("/Path")  //大的路径下面的子路径
    public String Path(){
        // http://localhost:8888/Reviced/Path?Path=Path    例：浏览器中可以输入这个路径访问到这里
        System.out.println("请求进来了");
//        System.out.println(Path);
//        int num = 20;
//        String out = "<h1>"+num+"</h1>";
        return "dasd";
    }

    /**
     * 用户从页面输入的DIO文件路径
     * @param readPath    http://localhost:8888/Reviced/addPath/filread
     */
    @RequestMapping("/login/{readPath}")  //大的路径下面的子路径
    public Object TestDatabase(@PathVariable String readPath){
        readPath = "C:/Users/S18314/Desktop/Tools表定义书/DIO_20201203.xls";   // 暂时先写死路径
        return new Result(true,StatusCode.OK,"请求成功",filePathService.filePathService(readPath));
    }

    /**
     * 查询出所有的DIO值，返回页面
     * @param
     * @return
     * 测试路径：http://localhost:8888/Reviced/findAll
     */
    @RequestMapping("/findAll{readPath}")  //大的路径下面的子路径
    public Object findAll(@PathVariable String readPath){
        List<FileReadDomin> list = filePathService.findAll();
        return new Result(true,StatusCode.OK,"请求成功",list);
    }

    /**
     * 查询出所有的DIO值，返回页面
     * @param
     * @return
     * 测试路径：http://localhost:8888/Reviced/deleteAll
     */
    @RequestMapping("/deleteAll")  //大的路径下面的子路径
    public Object deleteAll(){
        List<FileReadDomin> list = filePathService.deleteAll();
        return new Result(true,StatusCode.OK,"请求成功",list);
    }

    /**
     * 后台处理过，需要返回给前端的数据
     * @param
     * @return
     * 测试路径：http://localhost:8888/Reviced/findResult
     */
    @RequestMapping("/findResult")  //大的路径下面的子路径
    public Object findResult(){
        return new Result(true,StatusCode.OK,"请求成功",filePathService.findResult());
    }


}
