package cv.tools.tools.Dao;

import cv.tools.tools.Domin.FileReadDomin;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface FileReadDao extends JpaRepository<FileReadDomin, Long> {

    /**
     * 数据库中DIO筛选之后给前端的dao层
     * 定义接口：findResult
     * nativeQuery = true时，是可以执行原生sql语句，所谓原生sql，也就是说这段sql拷贝到数据库中，然后把参数值给一下就能运行了
     * SELECT * FROM tools_read_file WHERE Device_num = Device_num ORDER BY Lsn ASC :查询所有的数据并且按照Lsn排序
     */
    @Query(value = "SELECT * FROM tools_read_file",nativeQuery = true)
    List<FileReadDomin> findResult();


}
