package org.medspa.training.service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

//file size， type
//安全性（不要用爆，下载权限，重名）
//批量
@Service
public class FileService {
        private final Logger logger = LoggerFactory.getLogger(this.getClass());
        private String clientRegion = "us-west-1";

        @Autowired
        AmazonS3 s3Client;

        public String uploadFile(String bucketName, MultipartFile file) throws IOException {
            if(file == null){
                logger.error("Cannot upload a null file");
                return bucketName;
            }

            PutObjectRequest request = new PutObjectRequest(bucketName,
                    file.getOriginalFilename(),file.getInputStream(), null);
            s3Client.putObject(request);
            return getUrl(bucketName, file.getName());
    }
//uuid
    private String getUrl(String bucketName, String s3Key){
            return s3Client.getUrl(bucketName, s3Key).toString();
    }
    }

