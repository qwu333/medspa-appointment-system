package org.medspa.training.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.medspa.training.ApplicationBootstrap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationBootstrap.class)
public class FileServiceTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private FileService fileService;
    String filename = "test1.png";
    String filePath ="/Users/qionghuiwu/Desktop/test1.png";
    String contentType = "image/x-png";
    public MultipartFile getMultipartFile(String fileName){
        Path path = Paths.get(filePath);
        String name = fileName;
        String originalFileName = fileName;
        String contType = contentType;
        byte[] content = null;

        try{
            content = Files.readAllBytes(path);
        }catch(final IOException e){
            logger.error("Could not retrieve file.");
        }

        MultipartFile result = new MockMultipartFile(name,originalFileName,contType,content);
        return result;
    }



    @Test
    public void uploadFileTest() throws IOException {
        MultipartFile file = getMultipartFile(filename);
        fileService.uploadFile("training-asc-medspa",file);
    }


}