package com.coin.minio;

import com.coin.minio.config.MinioConfig;
import io.minio.GetPresignedObjectUrlArgs;
import io.minio.PutObjectArgs;
import io.minio.UploadObjectArgs;
import io.minio.errors.*;
import io.minio.http.Method;
import org.junit.jupiter.api.Test;
import org.simpleframework.xml.Text;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

@SpringBootTest
class DemoMinioApplicationTests {

    @Autowired
    MinioConfig minioConfig;

    @Test
    void contextLoads() throws IOException, InvalidKeyException, InvalidResponseException, InsufficientDataException, NoSuchAlgorithmException, ServerException, InternalException, XmlParserException, InvalidBucketNameException, ErrorResponseException {
        // PutObjectArgs
        // minioConfig.minioClient().putObject();
        String name = UUID.randomUUID().toString().replaceAll("-","");
        UploadObjectArgs build = UploadObjectArgs.builder()
                .bucket("jiangjin")
                .object(name + ".pdf")
                .filename("C:\\Users\\shenzhanwang\\Downloads\\一种基于Docker的监控系统的设计与实现_肖遥 (1).pdf")
                .build();
        minioConfig.minioClient().uploadObject(build);
    }

    @Test
    void download() throws IOException, InvalidKeyException, InvalidResponseException, InsufficientDataException, NoSuchAlgorithmException, ServerException, InternalException, XmlParserException, InvalidBucketNameException, ErrorResponseException {
        String jiangjin = minioConfig.minioClient().getObjectUrl("jiangjin", "02319afd6462417fb6c74c1533862d7b.pdf");
        System.out.println("jiangjin = " + jiangjin);

    }

    @Test
    void downloadage() throws IOException, InvalidKeyException, InvalidResponseException, InsufficientDataException, InvalidExpiresRangeException, ServerException, InternalException, NoSuchAlgorithmException, XmlParserException, InvalidBucketNameException, ErrorResponseException {
        GetPresignedObjectUrlArgs presigned = GetPresignedObjectUrlArgs.builder()
                .expiry(10)
                .bucket("jiangjin")
                .object("02319afd6462417fb6c74c1533862d7b.pdf")
                .method(Method.GET)
                .build();
        String presignedObjectUrl = minioConfig.minioClient().getPresignedObjectUrl(presigned);
        System.out.println("presignedObjectUrl = " + presignedObjectUrl);
    }

}
