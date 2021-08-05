package cv.tools.tools.Domin;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.annotations.Proxy;

import java.util.Date;
import javax.persistence.*;
import java.io.Serializable;

@Proxy(lazy = false)
@Entity
@Table(name="tools_user")
@JsonSerialize(include=JsonSerialize.Inclusion.NON_EMPTY)
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long User_id;
    private String User_name;
    private String User_password;
    private Date User_date_now;
    private Date user_date_old;

    @Override
    public String toString() {
        return "User{" +
                "User_id=" + User_id +
                ", User_name='" + User_name + '\'' +
                ", User_password='" + User_password + '\'' +
                ", User_date_now=" + User_date_now +
                ", user_date_old=" + user_date_old +
                '}';
    }

    public Long getUser_id() {
        return User_id;
    }

    public void setUser_id(Long user_id) {
        User_id = user_id;
    }

    public String getUser_name() {
        return User_name;
    }

    public void setUser_name(String user_name) {
        User_name = user_name;
    }

    public String getUser_password() {
        return User_password;
    }

    public void setUser_password(String user_password) {
        User_password = user_password;
    }

    public Date getUser_date_now() {
        return User_date_now;
    }

    public void setUser_date_now(Date user_date_now) {
        User_date_now = user_date_now;
    }

    public Date getuser_date_old() {
        return user_date_old;
    }

    public void setuser_date_old(Date user_date_old) {
        user_date_old = user_date_old;
    }

    public User(String user_name, String user_password, Date user_date_now, Date user_date_old) {
        User_name = user_name;
        User_password = user_password;
        User_date_now = user_date_now;
        user_date_old = user_date_old;
    }

    public User() {}
}
