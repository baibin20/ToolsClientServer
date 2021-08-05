package cv.tools.tools.Service;
import cv.tools.tools.Domin.AddDeviceDomin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddDeviceSer {

    @Autowired
    private cv.tools.tools.Dao.AddDeviceDao addDeviceDao;

    // 添加device findeDeviceNum
    public Boolean addDeviceService(AddDeviceDomin addDevice){
        List<AddDeviceDomin> list = addDeviceDao.findeDeviceNum(addDevice.getDevice_num());
        if(list.size() > 0){
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getPoject_name().equals(addDevice.getPoject_name()) && list.get(i).getDevice_num().equals(addDevice.getDevice_num())) {
                    return false;
                }
            }
        }
        addDeviceDao.save(addDevice);
        return true;
    }

    // 添加项目名和一共有多少个CP
    public List<AddDeviceDomin> addPojectService(AddDeviceDomin addDevice){
        addDeviceDao.save(addDevice);
        return null;
    }

    // 查询所有的device
    public List<AddDeviceDomin> findAllDeviceService(){
        List<AddDeviceDomin> list = addDeviceDao.findAll();
        return list;
    }

    // 条件查询根据device的number去查询   deleteDevice
    public List<AddDeviceDomin> findDeviceNumberDeviceService(String Devicenum){
        // findUserByNameIsLike
        return addDeviceDao.findAddDeviceDominByDevice_numIsLike(Devicenum);
    }

    // 条件查询根据device的number去查询   deleteDevice  cp_Num,poject_Name
    public void delDeviceSer(String device_Num,String poject_Name){
        addDeviceDao.delDeviceDao(device_Num, poject_Name);
    }
}
