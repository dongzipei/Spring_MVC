package com.itheima.controllor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.UUID;

@Controller
@RequestMapping("/upload")
public class UploadController {
    private String[] allowType={"image/jpeg","image/png"};
    @RequestMapping("/fileUpload")
    public String fileUpload(HttpServletRequest request,MultipartFile upload){
        if(!Arrays.asList(allowType).contains(upload.getContentType())){
            throw new RuntimeException("你上传的文档类型不符合要求");
        }

        String path = request.getSession().getServletContext().getRealPath("/upload/");
        File file = new File(path);
        if (!file.exists()){
            file.mkdirs();
        }
        String filename = upload.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        filename = uuid + filename;
        try {
            upload.transferTo(new File(file,filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }
}
