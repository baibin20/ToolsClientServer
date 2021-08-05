package cv.tools.tools.Service;

import cv.tools.tools.Dao.UserLoginDao;
import cv.tools.tools.Domin.User;
import cv.tools.tools.Utils.Common.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserLoginServer {

    @Autowired
    private UserLoginDao userLogin;

    public List userLogin(User user) throws Exception{

        MD5Util md5Util = new MD5Util();
        List<User> list = userLogin.userLogin(user.getUser_name());
        try {
            if(md5Util.MD5EncodeUtf8(user.getUser_password()).equals(list.get(0).getUser_password().toString())){
                return userLogin.userLogin(user.getUser_name());
            }else{
                return null;
            }
        }catch (Exception ex){
            return null;
        }
    }
}
