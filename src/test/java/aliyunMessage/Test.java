package aliyunMessage;

public class Test {
    private static String code = "123456";

    public static void main(String[] args) {
        String tel = "15221320441";  //输入手机号
        getVerificationCode(tel);
    }

    /**
     * 获取短信验证码
     *
     * @param tel
     */
    public static void getVerificationCode(String tel) {
        String templateParam = "{\"code\":\"" + vcode() + "\"}";
//        String templateParam = "";
        String result = ShortMessageUtil.getPhoneMsg(tel, ShortMessage.VerificationCode, templateParam);
        if (result != null && result.equals("OK")) {
            // 请求成功
            System.out.println("获取验证码成功！！！");
        } else {
            //
            System.out.println("获取验证码失败" + result);
//            throw new ThirdPartException(result);
        }
    }

        /**
         * 生成6位随机数验证码
         * @return
         */
        public static String vcode () {
            StringBuilder code = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                int random = (int) (Math.random() * 10);
                code = code.append(random);
            }
            return code.toString();
//            return null;
        }
}
