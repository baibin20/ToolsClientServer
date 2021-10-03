package cv.tools.tools.Dao.Jobpalletbind;

import java.math.BigDecimal;

public class asda {
    public static void main(String[] args) {
        BigDecimal b = new BigDecimal("25.1");
        float f1 =  b.setScale(1,BigDecimal.ROUND_HALF_UP).floatValue();
        System.out.println(f1);
        //   b.setScale(2,   BigDecimal.ROUND_HALF_UP)   表明四舍五入，保留两位小数
    }
}
