package com.asd.backened;

import org.junit.jupiter.api.Test;


/**
 * <br>
 * 〈〉
 *
 * @author Xuhao Guo
 * @create 2022/10/3
 * @since 1.0.0
 */

public class UploadFileTest {
    @Test
    public void testUpload(){
        String fileName = "ererewe.jpg";
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        System.out.println(suffix);
    }
}
