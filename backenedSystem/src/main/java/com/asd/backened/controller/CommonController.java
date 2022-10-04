package com.asd.backened.controller;

import com.asd.backened.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * File upload and download
 */
@RestController
@RequestMapping("/common")
@Slf4j
public class CommonController {

    @Value("${benjamen.path}")
    private String basePath;

    /**
     * files upload
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public R<String> upload(MultipartFile file){
        //File is a temporary file, which needs to be transferred to a specified location. Otherwise, the temporary file will be deleted after this request is completed
        log.info(file.toString());

        //Original file name
        String originalFilename = file.getOriginalFilename();//abc.jpg
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));

        //Use the UUID to generate the file name again to prevent file overwriting caused by repeated file names
        String fileName = UUID.randomUUID().toString() + suffix;//dfsdfdfd.jpg

        //Create a directory object
        File dir = new File(basePath);
        //Check whether the current directory exists
        if(!dir.exists()){
            //The directory does not exist and needs to be created
            dir.mkdirs();
        }

        try {
            //Dump the temporary file to the specified location
            file.transferTo(new File(basePath + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return R.success(fileName);
    }

    /**
     * file download
     * @param name
     * @param response
     */
    @GetMapping("/download")
    public void download(String name, HttpServletResponse response){

        try {
            //Input stream through which file contents are read
            FileInputStream fileInputStream = new FileInputStream(new File(basePath + name));

            //Output stream, through which files are written back to the browse
            ServletOutputStream outputStream = response.getOutputStream();

            response.setContentType("image/jpeg");

            int len = 0;
            byte[] bytes = new byte[1024];
            while ((len = fileInputStream.read(bytes)) != -1){
                outputStream.write(bytes,0,len);
                outputStream.flush();
            }

            //Close the resource
            outputStream.close();
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
