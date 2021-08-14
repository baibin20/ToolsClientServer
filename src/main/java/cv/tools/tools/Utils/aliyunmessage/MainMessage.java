package cv.tools.tools.Utils.aliyunmessage;

public class MainMessage {
    private static String code = "123456";

    /**
     * 获取短信验证码
     *
     * @param tel
     */
    public static String getVerificationCode(String tel) {
        String templateParam = "{\"code\":\"" + vcode() + "\"}";
        String result = ShortMessageUtil.getPhoneMsg(tel, ShortMessage.VerificationCode, templateParam);
        if (result != null && result.equals("OK")) {
            // 请求成功
            return  1 + "+" + templateParam;
        } else {
            return 2 + "+" + templateParam;
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
