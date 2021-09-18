package cn.hhhsl.hblog.service.impl;


import cn.hhhsl.hblog.service.FileUploadService;


import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.ObjectMetadata;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.UUID;


@Service
public class FileUploadServiceImpl implements FileUploadService {
    String endpoint = "**************";
    String accessKeyId = "**************";
    String accessKeySecret = "**************";;
    String bucketName = "**************";;
    @Override
    public String saveImage(MultipartFile file,String type) {
        OSS ossClient = null;
        URL url = null;
        //文件后缀
        String fileSuffix = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
        //文件名
        String fileName =  UUID.randomUUID().toString() + fileSuffix;
        //文件地址
        String fileAddress = type + "/" + fileName;
        try {
            ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
            ObjectMetadata meta = new ObjectMetadata();
            meta.setContentType("image/jpg");
            ossClient.putObject(bucketName, fileAddress, file.getInputStream(),meta);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            ossClient.shutdown();
        }
        return "http://"+bucketName+"."+endpoint+"/"+fileAddress;
    }
}
