package com.geeksun.jvm.util;

public class Utils {

    public static int byteToInteger(byte[] codes){
        return Integer.valueOf(byteToHexString(codes), 16);
    }

    public static String byteToHexString(byte[] codes) {
        StringBuilder sb = new StringBuilder();
        for(byte code:codes){
            int c = code&0xff;
            String hex = Integer.toHexString(c);
            if(hex.length() < 2){
                hex = "0" + hex;
            }
            sb.append(hex);
        }
        return sb.toString();
    }

}
