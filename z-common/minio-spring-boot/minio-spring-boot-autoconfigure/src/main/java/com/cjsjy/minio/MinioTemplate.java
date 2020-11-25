package com.cjsjy.minio;

import io.minio.*;
import io.minio.errors.*;
import io.minio.http.Method;
import io.minio.messages.Bucket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName MinioTemplate
 * @Description: TODO
 * @Author kh
 * @Date 2020-10-15 18:24
 * @Version V1.0
 **/
@Configuration
@ConditionalOnProperty(name = "minio.endpoint")
public class MinioTemplate {
    
    @Autowired
    MinioClient minioClient;

    /**
     * @MethodName createBucket
     * @Description 创建bucket
     * @param name 桶名称
     * @return void
     * @throws 
     * @author kh
     * @date 2020-10-15 18:36
     */
    public void createBucket(String name) throws IOException, InvalidKeyException, InvalidResponseException, RegionConflictException, InsufficientDataException, NoSuchAlgorithmException, ServerException, InternalException, XmlParserException, InvalidBucketNameException, ErrorResponseException {
        MakeBucketArgs makeBucketArgs = MakeBucketArgs.builder().bucket(name).build();
        if(!bucketExists(name)) {
            minioClient.makeBucket(makeBucketArgs);
        }
    }

    /**
     * @MethodName bucketExists
     * @Description 桶是否已存在
     * @param name 桶名称
     * @return boolean
     * @throws
     * @author kh
     * @date 2020-10-15 18:38
     */
    public boolean bucketExists(String name) throws IOException, InvalidKeyException, InvalidResponseException, InsufficientDataException, NoSuchAlgorithmException, ServerException, InternalException, XmlParserException, InvalidBucketNameException, ErrorResponseException {
        BucketExistsArgs bucketExistsArgs = BucketExistsArgs.builder().bucket(name).build();
        boolean b = minioClient.bucketExists(bucketExistsArgs);
        return b;
    }

    /**
     * @MethodName listBuckets
     * @Description 查询所有的桶信息
     * @param
     * @return java.util.List<io.minio.messages.Bucket>
     * @throws
     * @author kh
     * @date 2020-10-15 19:00
     */
    public List<Bucket> listBuckets() throws IOException, InvalidKeyException, InvalidResponseException, InsufficientDataException, NoSuchAlgorithmException, ServerException, InternalException, XmlParserException, InvalidBucketNameException, ErrorResponseException {
        List<Bucket> buckets = minioClient.listBuckets();
        return buckets;
    }

    /**
     * @MethodName upload
     * @Description 文件路径上传文件
     * @param name 桶名称
     * @param filepath 待上传文件路径
     * @param fileSavename 文件上传到minio名称
     * @return io.minio.ObjectWriteResponse
     * @throws
     * @author kh
     * @date 2020-10-15 18:43
     */
    public ObjectWriteResponse upload(String name, String filepath, String fileSavename) throws IOException, InvalidKeyException, InvalidResponseException, InsufficientDataException, NoSuchAlgorithmException, ServerException, InternalException, XmlParserException, InvalidBucketNameException, ErrorResponseException {
        UploadObjectArgs uploadObjectArgs = UploadObjectArgs.builder()
                .bucket(name)
                .filename(fileSavename)
                .object(filepath)
                .build();
        ObjectWriteResponse objectWriteResponse = minioClient.uploadObject(uploadObjectArgs);
        return objectWriteResponse;
    }

    /**
     * @MethodName upload
     * @Description 文件路径上传文件
     * @param name 桶名称
     * @param filepath 待上传文件路径
     * @param fileSavename 文件上传到minio名称
     * @param contentType 类型
     * @return io.minio.ObjectWriteResponse
     * @throws
     * @author kh
     * @date 2020-10-15 18:43
     */
    public ObjectWriteResponse upload(String name, String filepath, String fileSavename, String contentType) throws IOException, InvalidKeyException, InvalidResponseException, InsufficientDataException, NoSuchAlgorithmException, ServerException, InternalException, XmlParserException, InvalidBucketNameException, ErrorResponseException {
        UploadObjectArgs uploadObjectArgs = UploadObjectArgs.builder()
                .bucket(name)
                .contentType(contentType)
                .filename(fileSavename)
                .object(filepath)
                .build();
        ObjectWriteResponse objectWriteResponse = minioClient.uploadObject(uploadObjectArgs);
        return objectWriteResponse;
    }

    /**
     * @MethodName putObject
     * @Description 上传文件
     * @param name 桶名称
     * @param inputStream 流
     * @param fileSavename minio保存名称
     * @return io.minio.ObjectWriteResponse
     * @throws
     * @author kh
     * @date 2020-10-16 8:41
     */
    public ObjectWriteResponse putObject(String name, InputStream inputStream, String fileSavename) throws IOException, InvalidKeyException, InvalidResponseException, InsufficientDataException, NoSuchAlgorithmException, ServerException, InternalException, XmlParserException, InvalidBucketNameException, ErrorResponseException {
        PutObjectArgs putObjectArgs = PutObjectArgs.builder()
                .bucket(name)
                .stream(inputStream, -1, 10485760)
                .object(fileSavename)
                .build();
        ObjectWriteResponse objectWriteResponse = minioClient.putObject(putObjectArgs);
        return objectWriteResponse;
    }

    /**
     * @MethodName putObject
     * @Description 上传文件
     * @param name 桶名称
     * @param inputStream 流
     * @param fileSavename minio保存名称
     * @param size 文件大小，未知时-1
     * @param partSize 部分大小
     * @return io.minio.ObjectWriteResponse
     * @throws
     * @author kh
     * @date 2020-10-16 8:41
     */
    public ObjectWriteResponse putObject(String name, InputStream inputStream, String fileSavename, long size, long partSize) throws IOException, InvalidKeyException, InvalidResponseException, InsufficientDataException, NoSuchAlgorithmException, ServerException, InternalException, XmlParserException, InvalidBucketNameException, ErrorResponseException {
        PutObjectArgs putObjectArgs = PutObjectArgs.builder()
                .bucket(name)
                .stream(inputStream, size, 10485760)
                .object(fileSavename)
                .build();
        ObjectWriteResponse objectWriteResponse = minioClient.putObject(putObjectArgs);
        return objectWriteResponse;
    }

    /**
     * @MethodName putObject
     * @Description 上传文件
     * @param name 桶名称
     * @param inputStream 流
     * @param fileSavename minio保存名称
     * @param size 文件大小，未知时-1
     * @param partSize 部分大小
     * @param contentType 类型
     * @return io.minio.ObjectWriteResponse
     * @throws
     * @author kh
     * @date 2020-10-16 8:41
     */
    public ObjectWriteResponse putObject(String name, InputStream inputStream, String fileSavename, long size, long partSize, String contentType) throws IOException, InvalidKeyException, InvalidResponseException, InsufficientDataException, NoSuchAlgorithmException, ServerException, InternalException, XmlParserException, InvalidBucketNameException, ErrorResponseException {
        PutObjectArgs putObjectArgs = PutObjectArgs.builder()
                .bucket(name)
                .stream(inputStream, size, partSize)
                .object(fileSavename)
                .contentType(contentType)
                .build();
        ObjectWriteResponse objectWriteResponse = minioClient.putObject(putObjectArgs);
        return objectWriteResponse;
    }

    /**
     * @MethodName getObject
     * @Description 下载
     * @param name 桶名称
     * @param filename 文件在minio名称
     * @return java.io.InputStream
     * @throws
     * @author kh
     * @date 2020-10-16 8:48
     */
    public InputStream getObject(String name, String filename) throws IOException, InvalidKeyException, InvalidResponseException, InsufficientDataException, NoSuchAlgorithmException, ServerException, InternalException, XmlParserException, InvalidBucketNameException, ErrorResponseException {
        GetObjectArgs getObjectArgs = GetObjectArgs.builder().bucket(name).object(filename).build();
        InputStream stream = minioClient.getObject(getObjectArgs);
        return stream;
    }

    /**
     * @MethodName getPresignedObjectUrl
     * @Description 获取有有效期的文件访问地址
     * @param name 桶名称
     * @param filename minio保存文件名称
     * @param expiry 过期时间
     * @param method 方法
     * @return String
     * @throws
     * @author kh
     * @date 2020-10-16 8:55
     */
    public String getPresignedObjectUrl(String name, String filename, int expiry, Method method) throws IOException, InvalidKeyException, InvalidResponseException, InsufficientDataException, InvalidExpiresRangeException, ServerException, InternalException, NoSuchAlgorithmException, XmlParserException, InvalidBucketNameException, ErrorResponseException {
        GetPresignedObjectUrlArgs getPresignedObjectUrlArgs = GetPresignedObjectUrlArgs.builder().bucket(name).object(filename).method(method).expiry(expiry).build();
        String url = minioClient.getPresignedObjectUrl(getPresignedObjectUrlArgs);
        return url;
    }

    /**
     * @MethodName getPresignedObjectUrl
     * @Description 获取有有效期的文件访问地址
     * @param name 桶名称
     * @param filename minio保存文件名称
     * @param expiry 过期时间
     * @param unit 过期时间单位
     * @param method 方法
     * @return String
     * @throws
     * @author kh
     * @date 2020-10-16 8:55
     */
    public String getPresignedObjectUrl(String name, String filename, int expiry, TimeUnit unit, Method method) throws IOException, InvalidKeyException, InvalidResponseException, InsufficientDataException, InvalidExpiresRangeException, ServerException, InternalException, NoSuchAlgorithmException, XmlParserException, InvalidBucketNameException, ErrorResponseException {
        GetPresignedObjectUrlArgs getPresignedObjectUrlArgs = GetPresignedObjectUrlArgs.builder().bucket(name).object(filename).method(method).expiry(expiry, unit).build();
        String url = minioClient.getPresignedObjectUrl(getPresignedObjectUrlArgs);
        return url;
    }

    /**
     * @MethodName removeObject
     * @Description 删除文件
     * @param name 桶名称
     * @param filename minio保存文件名称
     * @return void
     * @throws
     * @author kh
     * @date 2020-10-16 15:51
     */
    public void removeObject (String name, String filename) throws IOException, InvalidKeyException, InvalidResponseException, InsufficientDataException, NoSuchAlgorithmException, ServerException, InternalException, XmlParserException, InvalidBucketNameException, ErrorResponseException {
        RemoveObjectArgs removeObjectArgs = RemoveObjectArgs.builder().bucket(name).object(filename).build();
        minioClient.removeObject(removeObjectArgs);
    }
}
