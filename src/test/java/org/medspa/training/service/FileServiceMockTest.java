package org.medspa.training.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.medspa.training.ApplicationBootstrap;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationBootstrap.class)
public class FileServiceMockTest {
    @Autowired
    FileService fileService;
    @Autowired
    private AmazonS3 s3Client;
    @Mock
    private MultipartFile file;

    @Test
    public void uploadFileTest_happyPath() throws IOException {
        //when(file.getName()).thenReturn("/file.txt");
        //File file = new File("/file.txt");
        fileService.uploadFile("training-asc-medspa",file);
        verify(s3Client, times(1)).putObject(any(PutObjectRequest.class));
        //verify(s3Client,times(1)).putObject(any(String.class));
    }

    @Test
    public void uploadFileTest_fileIsNull(){

    }
}
