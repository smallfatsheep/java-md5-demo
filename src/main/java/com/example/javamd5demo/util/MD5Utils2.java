package com.example.javamd5demo.util;

import org.springframework.util.DigestUtils;
/**
 * @Author: huangwc
 * @Description:
 * @Date: 2020/08/27 15:54:59
 * @Version: 1.0
 */
public class MD5Utils2 {
    //密文
    private static final String SECRET = "key";
    /**
     * MD5方法
     *
     * @param text 明文
     * @return md5
     * @throws Exception
     */
    public static String md5(String text) throws Exception {
        //加密
        String md5code= DigestUtils.md5DigestAsHex((text + SECRET).getBytes());
        return md5code;
    }

    /**
     * MD5验证方法
     *
     * @param text 明文
     * @param md5
     * @return true/false
     * @throws Exception
     */
    public static boolean verify(String text, String md5) throws Exception {
        //重新加密获取md5
        String md5Text = md5(text);
        //校验
        if(md5Text.equalsIgnoreCase(md5))
        {
            System.out.println("MD5验证通过");
            return true;
        }
        return false;
    }
}
