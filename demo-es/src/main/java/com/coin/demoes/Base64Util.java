package com.coin.demoes;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * @ClassName Base64Util
 * @Description: TODO
 * @Author kh
 * @Date 2020-09-22 11:41
 * @Version V1.0
 **/
public class Base64Util {

    /**
     * @MethodName getFileStr
     * @Description 将文件转化为字节数组字符串，并对其进行Base64编码处理
     * @param imgFile
     * @return java.lang.String
     * @throws
     * @author kh
     * @date 2020-09-22 11:42
     */
    public String getFileStr(String imgFile) {
        InputStream in = null;
        byte[] data = null;
        //读取文件字节数组
        try {
            in = new FileInputStream(imgFile);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //返回Base64编码过的字节数组字符串
        return Base64.getEncoder().encodeToString(data);
    }
}
