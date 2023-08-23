package org.medspa.training.controller;

import org.medspa.training.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;

@RestController
@RequestMapping(value = {"/files"})
public class FileController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    FileService fileService;

    @RequestMapping(value = "",method = RequestMethod.POST,consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String uploadFile(@RequestParam("file") MultipartFile file){
        try{
            String url = fileService.uploadFile("training-asc-medspa",file);
            logger.info("Successfully uploaded file {} to S3",file.getOriginalFilename());
            return url;
        }catch (IOException e){
            logger.error("Unable to upload file to AWS S3, error = {}", e.getMessage());
        }
        return null;
    }
}
