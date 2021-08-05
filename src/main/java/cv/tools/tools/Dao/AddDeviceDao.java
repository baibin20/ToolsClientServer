package cv.tools.tools.Dao;

import cv.tools.tools.Domin.AddDeviceDomin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface AddDeviceDao extends JpaRepository<AddDeviceDomin, Long> {

    /**
     * 数据库中DIO筛选之后给前端的dao层
     * 定义接口：findResult
     * nativeQuery = true时，是可以执行原生sql语句，所谓原生sql，也就是说这段sql拷贝到数据库中，然后把参数值给一下就能运行了
     * select u from User u where u.emailAddress = ?1 and u.lastname = ?2
     */
    @Query(value = "SELECT * FROM tools_user n WHERE n.user_name = ?1",nativeQuery = true)
    List userLogin(String username);

    @Query(value = "SELECT * FROM add_dio n WHERE n.device_num = ?1",nativeQuery = true)
    List<AddDeviceDomin> findAddDeviceDominByDevice_numIsLike(String Devicenum);

    @Query(value = "SELECT * FROM add_dio",nativeQuery = true)
    List<AddDeviceDomin>  findAll();

    // 删除device
    @Modifying
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    @Query(value = "DELETE FROM add_dio WHERE device_num = ?1 AND poject_name = ?2",nativeQuery = true)
    void delDeviceDao(String device_Num,String poject_Name);

    // 根据deviceNumber去查询数据中有没有这条device
    @Query(value = "SELECT * FROM add_dio  WHERE device_num = ?1",nativeQuery = true)
    List<AddDeviceDomin> findeDeviceNum(String  delDeviceSer);

}
