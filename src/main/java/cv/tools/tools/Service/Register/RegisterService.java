package cv.tools.tools.Service.Register;

import cv.tools.tools.Dao.register.RegisterDao;
import cv.tools.tools.Domin.User;
import cv.tools.tools.Utils.Common.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class RegisterService {

    @Autowired
    private RegisterDao registerDao;

    public int register(String userName,String passWord,String phone, String code ){
        List<User> list =  registerDao.register(userName);
        MD5Util md5Util = new MD5Util();
        if (list.size() == 0){
            User userRegister = new User();
            System.out.println("没有这个用户可以注册");
            userRegister.setUser_name(userName);
            userRegister.setUser_password(md5Util.MD5EncodeUtf8(passWord));
            userRegister.setPhone(phone);
            userRegister.setUser_date_now(new Date());
            userRegister.setUser_date_old(new Date());
            registerDao.save(userRegister);
            return 1;
        }else {
            System.out.println("有这个用户暂时不能注册");
            return 2;
        }
    }
}
