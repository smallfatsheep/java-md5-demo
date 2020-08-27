package com.example.javamd5demo;

import com.example.javamd5demo.util.MD5Utils;
import com.example.javamd5demo.util.MD5Utils2;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@SpringBootTest
class JavaMd5DemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void testMd5() throws NoSuchAlgorithmException {
        // java自带工具包MessageDigest
        MessageDigest md = MessageDigest.getInstance("md5");
        byte[] secretBytes = md.digest("1234".getBytes());
        String md5code = new BigInteger(1, secretBytes).toString(16);
        System.out.println(md5code);
        System.out.println("=============================================");
        String resultString1 = MD5Utils.stringToMD5("1234");
        System.out.println(resultString1);
        //81dc9bdb52d04dc20036dbd8313ed055
        System.out.println("=============================================");
        // spring自带工具包DigestUtils
        System.out.println(DigestUtils.md5DigestAsHex("1234".getBytes()));
        // 81dc9bdb52d04dc20036dbd8313ed055
    }

    @Test
    public void testMD52() throws Exception {
        String md5code = MD5Utils2.md5("1234");
        System.out.println(md5code);
        System.out.println("=============================================");
        boolean bl = MD5Utils2.verify("1234",md5code);
        System.out.println(bl);
    }
}
