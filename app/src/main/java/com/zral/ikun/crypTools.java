package com.zral.ikun;


import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class crypTools {
    public String genMd5(String inStr) {
        // 生成md5
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
            byte[] byteArr = md5.digest(inStr.getBytes(StandardCharsets.UTF_8));
            return byte2hex(byteArr);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";

    }

    public static String byte2hex(byte[] b) {
        StringBuilder hs = new StringBuilder();
        String stmp = "";
        for (byte value : b) {
            //为了保证二进制机器数不变，这里需要& 0XFF
            stmp = (Integer.toHexString(value & 0XFF));
            //如果只有一位，需要在前面补上0凑足两位
            if (stmp.length() == 1) {
                hs.append("0").append(stmp);
            } else {
                hs.append(stmp);
            }
        }
        return hs.toString();
    }

//    public static void main(String[] args) {
//        crypTools crypTools = new crypTools();
//        System.out.println(crypTools.genMd5("123"));
//    }
}
