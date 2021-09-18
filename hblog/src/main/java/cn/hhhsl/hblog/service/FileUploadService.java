package cn.hhhsl.hblog.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {

    String saveImage(MultipartFile file,String type);
}
