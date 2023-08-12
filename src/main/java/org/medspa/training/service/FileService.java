package org.medspa.training.service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class FileService {
        private final Logger logger = LoggerFactory.getLogger(this.getClass());
        private String clientRegion = "us-west-1";
        String bucketName = "training-asc-medspa";
        String stringObjKeyName = "sampleFile.txt";

        @Autowired
        AmazonS3 s3Client;
        public void uploadFile(File file) {
            if(file == null){
                return;
            }
            try {
                s3Client.putObject(bucketName, file.getName(), file);
            }catch(AmazonServiceException e){
                e.printStackTrace();
            }catch(SdkClientException e){
                e.printStackTrace();
            }
    }
    }

