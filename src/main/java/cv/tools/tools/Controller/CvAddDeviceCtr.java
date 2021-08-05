package cv.tools.tools.Controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.*;
import cv.tools.tools.Domin.AddDeviceDomin;
import cv.tools.tools.Domin.User;
import cv.tools.tools.Entity.Result;
import cv.tools.tools.Entity.StatusCode;
import org.apache.spark.sql.execution.columnar.NULL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import scala.reflect.internal.Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@ResponseBody
@RequestMapping("/")   // 请求进来的大的路径
public class CvAddDeviceCtr {

    @Autowired
    private cv.tools.tools.Service.AddDeviceSer addDeviceServiceCon;

    @PostMapping("/addDeviceCv")
    public String addDevice(@RequestBody JSONArray object) {
        String deviceName = "";
        String cpNum = "";
        AddDeviceDomin addDevice = new AddDeviceDomin();
        net.sf.json.JSONArray  myJson = net.sf.json.JSONArray.fromObject(object.toString());
        for (int i = 0; i < myJson.size(); i++) {
            Map map = JSON.parseObject(myJson.get(i).toString(),Map.class);
            addDevice.setPoject_name((String) map.get("projectNmae"));
            if (i == 0){
                deviceName = (String) map.get("deviceNum");
                addDevice.setDevice_num((String) map.get("deviceNum"));
                addDevice.setCp_num((String) map.get("cpNum"));
            }
            if(map.get("Bit").toString().equals("0")){
                addDevice.setDevice_bit((String) map.get("Bit"));
                addDevice.setDevice_lsn((String) map.get("Lsn"));
                addDevice.setDevice_text((String) map.get("Text"));
            }
            else if (map.get("Bit").toString().equals("1")){
                addDevice.setDevice_bit1((String) map.get("Bit"));
                addDevice.setDevice_lsn1((String) map.get("Lsn"));
                addDevice.setDevice_text1((String) map.get("Text"));
            }
            else if (map.get("Bit").toString().equals("2")){
                addDevice.setDevice_bit2((String) map.get("Bit"));
                addDevice.setDevice_lsn2((String) map.get("Lsn"));
                addDevice.setDevice_text2((String) map.get("Text"));
            }
            else if (map.get("Bit").toString().equals("3")){
                addDevice.setDevice_bit3((String) map.get("Bit"));
                addDevice.setDevice_lsn3((String) map.get("Lsn"));
                addDevice.setDevice_text3((String) map.get("Text"));
            }
            else if (map.get("Bit").toString().equals("4")){
                addDevice.setDevice_bit4((String) map.get("Bit"));
                addDevice.setDevice_lsn4((String) map.get("Lsn"));
                addDevice.setDevice_text4((String) map.get("Text"));
            }
            else if (map.get("Bit").toString().equals("5")){
                addDevice.setDevice_bit5((String) map.get("Bit"));
                addDevice.setDevice_lsn5((String) map.get("Lsn"));
                addDevice.setDevice_text5((String) map.get("Text"));
            }
            else if (map.get("Bit").toString().equals("6")){
                addDevice.setDevice_bit6((String) map.get("Bit"));
                addDevice.setDevice_lsn6((String) map.get("Lsn"));
                addDevice.setDevice_text6((String) map.get("Text"));
            }
            else if (map.get("Bit").toString().equals("7")){
                addDevice.setDevice_bit7((String) map.get("Bit"));
                addDevice.setDevice_lsn7((String) map.get("Lsn"));
                addDevice.setDevice_text7((String) map.get("Text"));
            }
            else if (map.get("Bit").toString().equals("8")){
                addDevice.setDevice_bit8((String) map.get("Bit"));
                addDevice.setDevice_lsn8((String) map.get("Lsn"));
                addDevice.setDevice_text8((String) map.get("Text"));
            }
            else if (map.get("Bit").toString().equals("9")){
                addDevice.setDevice_bit9((String) map.get("Bit"));
                addDevice.setDevice_lsn9((String) map.get("Lsn"));
                addDevice.setDevice_text9((String) map.get("Text"));
            }
            else if (map.get("Bit").toString().equals("A")){
                addDevice.setDevice_bit10((String) map.get("Bit"));
                addDevice.setDevice_lsn10((String) map.get("Lsn"));
                addDevice.setDevice_text10((String) map.get("Text"));
            }
            else if (map.get("Bit").toString().equals("B")){
                addDevice.setDevice_bit11((String) map.get("Bit"));
                addDevice.setDevice_lsn11((String) map.get("Lsn"));
                addDevice.setDevice_text11((String) map.get("Text"));
            }
            else if (map.get("Bit").toString().equals("C")){
                addDevice.setDevice_bit12((String) map.get("Bit"));
                addDevice.setDevice_lsn12((String) map.get("Lsn"));
                addDevice.setDevice_text12((String) map.get("Text"));
            }
            else if (map.get("Bit").toString().equals("D")){
                addDevice.setDevice_bit13((String) map.get("Bit"));
                addDevice.setDevice_lsn13((String) map.get("Lsn"));
                addDevice.setDevice_text13((String) map.get("Text"));
            }
            else if (map.get("Bit").toString().equals("E")){
                addDevice.setDevice_bit14((String) map.get("Bit"));
                addDevice.setDevice_lsn14((String) map.get("Lsn"));
                addDevice.setDevice_text14((String) map.get("Text"));
            }
            else if (map.get("Bit").toString().equals("F")){
                addDevice.setDevice_bit15((String) map.get("Bit"));
                addDevice.setDevice_lsn15((String) map.get("Lsn"));
                addDevice.setDevice_text15((String) map.get("Text"));
            }
            else if (map.get("Bit").toString().equals("G")){
                addDevice.setDevice_bit16((String) map.get("Bit"));
                addDevice.setDevice_lsn16((String) map.get("Lsn"));
                addDevice.setDevice_text16((String) map.get("Text"));
            }
        }
        if (addDevice.getDevice_bit() == null){
            addDevice.setDevice_bit("0");
        }
        if (addDevice.getDevice_bit1() == null){
            addDevice.setDevice_bit1("1");
        }
        if (addDevice.getDevice_bit2() == null){
            addDevice.setDevice_bit2("2");
        }
        if (addDevice.getDevice_bit3() == null){
            addDevice.setDevice_bit3("3");
        }
        if (addDevice.getDevice_bit4() == null){
            addDevice.setDevice_bit4("4");
        }
        if (addDevice.getDevice_bit5() == null){
            addDevice.setDevice_bit5("5");
        }
        if (addDevice.getDevice_bit6() == null){
            addDevice.setDevice_bit6("6");
        }
        if (addDevice.getDevice_bit7() == null){
            addDevice.setDevice_bit7("7");
        }
        if (addDevice.getDevice_bit8() == null){
            addDevice.setDevice_bit8("8");
        }
        if (addDevice.getDevice_bit9() == null){
            addDevice.setDevice_bit9("9");
        }
        if (addDevice.getDevice_bit10() == null){
            addDevice.setDevice_bit10("A");
        }
        if (addDevice.getDevice_bit11() == null){
            addDevice.setDevice_bit11("B");
        }
        if (addDevice.getDevice_bit12() == null){
            addDevice.setDevice_bit12("C");
        }
        if (addDevice.getDevice_bit13() == null){
            addDevice.setDevice_bit13("D");
        }
        if (addDevice.getDevice_bit14() == null){
            addDevice.setDevice_bit14("E");
        }
        if (addDevice.getDevice_bit15() == null){
            addDevice.setDevice_bit15("F");
        }
        if (addDevice.getDevice_bit16() == null){
            addDevice.setDevice_bit16("G");
        }
        Boolean booble =  addDeviceServiceCon.addDeviceService(addDevice);
        if (booble){
            return JSON.toJSONString(new Result(true,StatusCode.OK,"添加成功"));
        }else {
            return JSON.toJSONString(new Result(false,StatusCode.ERROR,"添加失败:有相同的Device"));
        }
    }

    @GetMapping("/allDeviceCv")
    public String allDevice(@RequestParam("all") String alldevice) {
        return JSON.toJSONString(new Result(true,StatusCode.OK,"查询成功",addDeviceServiceCon.findAllDeviceService()));
    }

    @PostMapping("/addPojectName")
    public String addPojectName(@RequestBody HashMap hashMap) {
        AddDeviceDomin addDeviceDomin = new AddDeviceDomin();
        addDeviceDomin.setPoject_name((String) hashMap.get("keyword"));
        addDeviceDomin.setCp_num((String) hashMap.get("cpNum"));
        addDeviceServiceCon.addPojectService(addDeviceDomin);
        List list = new ArrayList();
        for (int i = 0; i < Integer.parseInt((String) hashMap.get("cpNum")); i++) {
            list.add("CP" + i);
        }
        return JSON.toJSONString(new Result(true,StatusCode.OK,"添加成功",list));
    }

    @DeleteMapping("/deleteDeviceCv")
    public String deleteDevice(@RequestBody HashMap hashMap) {
        String device_Num = hashMap.get("device_num").toString();
        String  poject_Name = hashMap.get("poject_name").toString();
        addDeviceServiceCon.delDeviceSer(device_Num,poject_Name);
        return JSON.toJSONString(new Result(true,StatusCode.OK,"删除成功"));
    }
}
