package cv.tools.tools.Service;

import cv.tools.tools.Dao.FileReadDao;
import cv.tools.tools.Domin.FileReadDomin;
import cv.tools.tools.Utils.FindResultUtils;
import cv.tools.tools.Utils.Handle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FilePathService {

    @Autowired
    private FileReadDao fileReadDao;

    /**
     * 需要从control层传过来路径
     * @param
     * @return
     */
    public List filePathService(String readPath){
        List<FileReadDomin> list = new Handle().handleShuJu(readPath);
        for (int i = 0; i < list.size(); i++) {
            fileReadDao.save(list.get(i));
        }
        return null;
    }

    /**
     * 页面查询数据库中所有的数据
     * @return
     */
    public List<FileReadDomin> findAll(){
        return fileReadDao.findAll();
    }

    /**
     * 删除DIO表内容存在数据库中的内容
     * @return
     */
    public List<FileReadDomin> deleteAll(){
        fileReadDao.deleteAll();
        return fileReadDao.findAll();
    }

    /**
     * sevice层处理，需要返回给control的数据,返回类型是FileReadDomin
     * @return
     */
    public List<FileReadDomin> findResult(){
        List<FileReadDomin> list = new FindResultUtils().findResult( fileReadDao.findResult());

        for (int i = 0; i < list.size(); i++) {
            fileReadDao.save(list.get(i));
        }
        return list;
    }
}
