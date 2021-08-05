package cv.tools.tools.Domin;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.annotations.Proxy;
import org.springframework.context.annotation.Bean;

import javax.persistence.*;
import java.io.Serializable;

@Proxy(lazy = false)
@Entity
@Table(name="add_dio")
@JsonSerialize(include=JsonSerialize.Inclusion.NON_EMPTY)
public class AddDeviceDomin implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Uu_id;
    private String Poject_name;
    private String Cp_num;
    private String Device_num;
    private String Device_bit;
    private String Device_text;
    private String Device_lsn;
    private String Device_bit1;
    private String Device_bit2;
    private String Device_bit3;
    private String Device_bit4;
    private String Device_bit5;
    private String Device_bit6;
    private String Device_bit7;
    private String Device_bit8;
    private String Device_bit9;
    private String Device_bit10;
    private String Device_bit11;
    private String Device_bit12;
    private String Device_bit13;
    private String Device_bit14;
    private String Device_bit15;
    private String Device_bit16;
    private String Device_text1;
    private String Device_text2;
    private String Device_text3;
    private String Device_text4;
    private String Device_text5;
    private String Device_text6;
    private String Device_text7;
    private String Device_text8;
    private String Device_text9;
    private String Device_text10;
    private String Device_text11;
    private String Device_text12;
    private String Device_text13;
    private String Device_text14;
    private String Device_text15;
    private String Device_text16;
    private String Device_lsn1;
    private String Device_lsn2;
    private String Device_lsn3;
    private String Device_lsn4;
    private String Device_lsn5;
    private String Device_lsn6;
    private String Device_lsn7;
    private String Device_lsn8;
    private String Device_lsn9;
    private String Device_lsn10;
    private String Device_lsn11;
    private String Device_lsn12;
    private String Device_lsn13;
    private String Device_lsn14;
    private String Device_lsn15;
    private String Device_lsn16;

    public AddDeviceDomin() {}

    public Long getUu_id() {
        return Uu_id;
    }

    public void setUu_id(Long uu_id) {
        Uu_id = uu_id;
    }

    public String getPoject_name() {
        return Poject_name;
    }

    public void setPoject_name(String poject_name) {
        Poject_name = poject_name;
    }


    public void setCp_num(String cp_num) {
        Cp_num = cp_num;
    }

    public String getDevice_num() {
        return Device_num;
    }

    public void setDevice_num(String device_num) {
        Device_num = device_num;
    }

    public String getDevice_bit() {
        return Device_bit;
    }

    public void setDevice_bit(String device_bit) {
        Device_bit = device_bit;
    }

    public String getDevice_text() {
        return Device_text;
    }

    public void setDevice_text(String device_text) {
        Device_text = device_text;
    }

    public String getDevice_lsn() {
        return Device_lsn;
    }

    public void setDevice_lsn(String device_lsn) {
        Device_lsn = device_lsn;
    }

    public String getDevice_bit1() {
        return Device_bit1;
    }

    public void setDevice_bit1(String device_bit1) {
        Device_bit1 = device_bit1;
    }

    public String getDevice_bit2() {
        return Device_bit2;
    }

    public void setDevice_bit2(String device_bit2) {
        Device_bit2 = device_bit2;
    }

    public String getDevice_bit3() {
        return Device_bit3;
    }

    public void setDevice_bit3(String device_bit3) {
        Device_bit3 = device_bit3;
    }

    public String getDevice_bit4() {
        return Device_bit4;
    }

    public void setDevice_bit4(String device_bit4) {
        Device_bit4 = device_bit4;
    }

    public String getDevice_bit5() {
        return Device_bit5;
    }

    public void setDevice_bit5(String device_bit5) {
        Device_bit5 = device_bit5;
    }

    public String getDevice_bit6() {
        return Device_bit6;
    }

    public void setDevice_bit6(String device_bit6) {
        Device_bit6 = device_bit6;
    }

    public String getDevice_bit7() {
        return Device_bit7;
    }

    public void setDevice_bit7(String device_bit7) {
        Device_bit7 = device_bit7;
    }

    public String getDevice_bit8() {
        return Device_bit8;
    }

    public void setDevice_bit8(String device_bit8) {
        Device_bit8 = device_bit8;
    }

    public String getDevice_bit9() {
        return Device_bit9;
    }

    public void setDevice_bit9(String device_bit9) {
        Device_bit9 = device_bit9;
    }

    public String getDevice_bit10() {
        return Device_bit10;
    }

    public void setDevice_bit10(String device_bit10) {
        Device_bit10 = device_bit10;
    }

    public String getDevice_bit11() {
        return Device_bit11;
    }

    public void setDevice_bit11(String device_bit11) {
        Device_bit11 = device_bit11;
    }

    public String getDevice_bit12() {
        return Device_bit12;
    }

    public void setDevice_bit12(String device_bit12) {
        Device_bit12 = device_bit12;
    }

    public String getDevice_bit13() {
        return Device_bit13;
    }

    public void setDevice_bit13(String device_bit13) {
        Device_bit13 = device_bit13;
    }

    public String getDevice_bit14() {
        return Device_bit14;
    }

    public void setDevice_bit14(String device_bit14) {
        Device_bit14 = device_bit14;
    }

    public String getDevice_bit15() {
        return Device_bit15;
    }

    public void setDevice_bit15(String device_bit15) {
        Device_bit15 = device_bit15;
    }

    public String getDevice_bit16() {
        return Device_bit16;
    }

    public void setDevice_bit16(String device_bit16) {
        Device_bit16 = device_bit16;
    }

    public String getDevice_text1() {
        return Device_text1;
    }

    public void setDevice_text1(String device_text1) {
        Device_text1 = device_text1;
    }

    public String getDevice_text2() {
        return Device_text2;
    }

    public void setDevice_text2(String device_text2) {
        Device_text2 = device_text2;
    }

    public String getDevice_text3() {
        return Device_text3;
    }

    public void setDevice_text3(String device_text3) {
        Device_text3 = device_text3;
    }

    public String getDevice_text4() {
        return Device_text4;
    }

    public void setDevice_text4(String device_text4) {
        Device_text4 = device_text4;
    }

    public String getDevice_text5() {
        return Device_text5;
    }

    public void setDevice_text5(String device_text5) {
        Device_text5 = device_text5;
    }

    public String getDevice_text6() {
        return Device_text6;
    }

    public void setDevice_text6(String device_text6) {
        Device_text6 = device_text6;
    }

    public String getDevice_text7() {
        return Device_text7;
    }

    public void setDevice_text7(String device_text7) {
        Device_text7 = device_text7;
    }

    public String getDevice_text8() {
        return Device_text8;
    }

    public void setDevice_text8(String device_text8) {
        Device_text8 = device_text8;
    }

    public String getDevice_text9() {
        return Device_text9;
    }

    public void setDevice_text9(String device_text9) {
        Device_text9 = device_text9;
    }

    public String getDevice_text10() {
        return Device_text10;
    }

    public void setDevice_text10(String device_text10) {
        Device_text10 = device_text10;
    }

    public String getDevice_text11() {
        return Device_text11;
    }

    public void setDevice_text11(String device_text11) {
        Device_text11 = device_text11;
    }

    public String getDevice_text12() {
        return Device_text12;
    }

    public void setDevice_text12(String device_text12) {
        Device_text12 = device_text12;
    }

    public String getDevice_text13() {
        return Device_text13;
    }

    public void setDevice_text13(String device_text13) {
        Device_text13 = device_text13;
    }

    public String getDevice_text14() {
        return Device_text14;
    }

    public void setDevice_text14(String device_text14) {
        Device_text14 = device_text14;
    }

    public String getDevice_text15() {
        return Device_text15;
    }

    public void setDevice_text15(String device_text15) {
        Device_text15 = device_text15;
    }

    public String getDevice_text16() {
        return Device_text16;
    }

    public void setDevice_text16(String device_text16) {
        Device_text16 = device_text16;
    }

    public String getDevice_lsn1() {
        return Device_lsn1;
    }

    public void setDevice_lsn1(String device_lsn1) {
        Device_lsn1 = device_lsn1;
    }

    public String getDevice_lsn2() {
        return Device_lsn2;
    }

    public void setDevice_lsn2(String device_lsn2) {
        Device_lsn2 = device_lsn2;
    }

    public String getDevice_lsn3() {
        return Device_lsn3;
    }

    public void setDevice_lsn3(String device_lsn3) {
        Device_lsn3 = device_lsn3;
    }

    public String getDevice_lsn4() {
        return Device_lsn4;
    }

    public void setDevice_lsn4(String device_lsn4) {
        Device_lsn4 = device_lsn4;
    }

    public String getDevice_lsn5() {
        return Device_lsn5;
    }

    public void setDevice_lsn5(String device_lsn5) {
        Device_lsn5 = device_lsn5;
    }

    public String getDevice_lsn6() {
        return Device_lsn6;
    }

    public void setDevice_lsn6(String device_lsn6) {
        Device_lsn6 = device_lsn6;
    }

    public String getDevice_lsn7() {
        return Device_lsn7;
    }

    public void setDevice_lsn7(String device_lsn7) {
        Device_lsn7 = device_lsn7;
    }

    public String getDevice_lsn8() {
        return Device_lsn8;
    }

    public void setDevice_lsn8(String device_lsn8) {
        Device_lsn8 = device_lsn8;
    }

    public String getDevice_lsn9() {
        return Device_lsn9;
    }

    public void setDevice_lsn9(String device_lsn9) {
        Device_lsn9 = device_lsn9;
    }

    public String getDevice_lsn10() {
        return Device_lsn10;
    }

    public void setDevice_lsn10(String device_lsn10) {
        Device_lsn10 = device_lsn10;
    }

    public String getDevice_lsn11() {
        return Device_lsn11;
    }

    public void setDevice_lsn11(String device_lsn11) {
        Device_lsn11 = device_lsn11;
    }

    public String getDevice_lsn12() {
        return Device_lsn12;
    }

    public void setDevice_lsn12(String device_lsn12) {
        Device_lsn12 = device_lsn12;
    }

    public String getDevice_lsn13() {
        return Device_lsn13;
    }

    public void setDevice_lsn13(String device_lsn13) {
        Device_lsn13 = device_lsn13;
    }

    public String getDevice_lsn14() {
        return Device_lsn14;
    }

    public void setDevice_lsn14(String device_lsn14) {
        Device_lsn14 = device_lsn14;
    }

    public String getDevice_lsn15() {
        return Device_lsn15;
    }

    public void setDevice_lsn15(String device_lsn15) {
        Device_lsn15 = device_lsn15;
    }

    public String getDevice_lsn16() {
        return Device_lsn16;
    }

    public void setDevice_lsn16(String device_lsn16) {
        Device_lsn16 = device_lsn16;
    }

    public AddDeviceDomin(String poject_name, String cp_num, String device_num, String device_bit, String device_text, String device_lsn, String device_bit1, String device_bit2, String device_bit3, String device_bit4, String device_bit5, String device_bit6, String device_bit7, String device_bit8, String device_bit9, String device_bit10, String device_bit11, String device_bit12, String device_bit13, String device_bit14, String device_bit15, String device_bit16, String device_text1, String device_text2, String device_text3, String device_text4, String device_text5, String device_text6, String device_text7, String device_text8, String device_text9, String device_text10, String device_text11, String device_text12, String device_text13, String device_text14, String device_text15, String device_text16, String device_lsn1, String device_lsn2, String device_lsn3, String device_lsn4, String device_lsn5, String device_lsn6, String device_lsn7, String device_lsn8, String device_lsn9, String device_lsn10, String device_lsn11, String device_lsn12, String device_lsn13, String device_lsn14, String device_lsn15, String device_lsn16) {
        Poject_name = poject_name;
        Cp_num = cp_num;
        Device_num = device_num;
        Device_bit = device_bit;
        Device_text = device_text;
        Device_lsn = device_lsn;
        Device_bit1 = device_bit1;
        Device_bit2 = device_bit2;
        Device_bit3 = device_bit3;
        Device_bit4 = device_bit4;
        Device_bit5 = device_bit5;
        Device_bit6 = device_bit6;
        Device_bit7 = device_bit7;
        Device_bit8 = device_bit8;
        Device_bit9 = device_bit9;
        Device_bit10 = device_bit10;
        Device_bit11 = device_bit11;
        Device_bit12 = device_bit12;
        Device_bit13 = device_bit13;
        Device_bit14 = device_bit14;
        Device_bit15 = device_bit15;
        Device_bit16 = device_bit16;
        Device_text1 = device_text1;
        Device_text2 = device_text2;
        Device_text3 = device_text3;
        Device_text4 = device_text4;
        Device_text5 = device_text5;
        Device_text6 = device_text6;
        Device_text7 = device_text7;
        Device_text8 = device_text8;
        Device_text9 = device_text9;
        Device_text10 = device_text10;
        Device_text11 = device_text11;
        Device_text12 = device_text12;
        Device_text13 = device_text13;
        Device_text14 = device_text14;
        Device_text15 = device_text15;
        Device_text16 = device_text16;
        Device_lsn1 = device_lsn1;
        Device_lsn2 = device_lsn2;
        Device_lsn3 = device_lsn3;
        Device_lsn4 = device_lsn4;
        Device_lsn5 = device_lsn5;
        Device_lsn6 = device_lsn6;
        Device_lsn7 = device_lsn7;
        Device_lsn8 = device_lsn8;
        Device_lsn9 = device_lsn9;
        Device_lsn10 = device_lsn10;
        Device_lsn11 = device_lsn11;
        Device_lsn12 = device_lsn12;
        Device_lsn13 = device_lsn13;
        Device_lsn14 = device_lsn14;
        Device_lsn15 = device_lsn15;
        Device_lsn16 = device_lsn16;
    }
}
