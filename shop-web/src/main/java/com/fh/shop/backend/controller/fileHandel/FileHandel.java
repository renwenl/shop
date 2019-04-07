package com.fh.shop.backend.controller.fileHandel;

import com.fh.core.utils.COSUtils;
import com.fh.shop.backend.common.ServerResponse;
import com.fh.shop.backend.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/file")
public class FileHandel extends BaseController {

    @Autowired
    private HttpServletRequest request;

    public static void deleteFile(String fileName){
        COSUtils.delete(fileName);
    }

    @RequestMapping("uploadFile")
    public ServerResponse uploadFile(@RequestParam MultipartFile file) {
        String uploadFileName = "";
        try {
            String filename = file.getOriginalFilename();
            InputStream inputStream = file.getInputStream();
            uploadFileName = COSUtils.upload2COS(filename, inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  ServerResponse.success(uploadFileName);
    }
}
