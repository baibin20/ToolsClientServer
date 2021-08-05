package cv.tools.tools.Dao;

import cv.tools.tools.Domin.FileReadDomin;
import cv.tools.tools.Domin.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.jws.soap.SOAPBinding;
import java.util.List;

@Repository
public interface UserLoginDao extends JpaRepository<User, Long> {
    /**
     * 数据库中DIO筛选之后给前端的dao层
     * 定义接口：findResult
     * nativeQuery = true时，是可以执行原生sql语句，所谓原生sql，也就是说这段sql拷贝到数据库中，然后把参数值给一下就能运行了
     * select u from User u where u.emailAddress = ?1 and u.lastname = ?2
     */
    @Query(value = "SELECT * FROM tools_user n WHERE n.user_name = ?1",nativeQuery = true)
    List<User> userLogin(String username);
}
