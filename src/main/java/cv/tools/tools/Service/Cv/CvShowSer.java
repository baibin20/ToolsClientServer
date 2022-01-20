package cv.tools.tools.Service.Cv;

import cv.tools.tools.Domin.AddDeviceDomin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CvShowSer {

    @Autowired
    private cv.tools.tools.Dao.Cv.CvShowDao cvShowDao;

    /**
     * 查询出device号和内容
     * @return
     */
    public List showCvTableSer(){
        List<AddDeviceDomin> list = cvShowDao.findDevice();
        return list;
    }

}
