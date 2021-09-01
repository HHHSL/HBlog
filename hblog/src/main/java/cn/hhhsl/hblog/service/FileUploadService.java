package cn.hhhsl.hblog.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {

    void addfile(MultipartFile file,String catalogue);
}
