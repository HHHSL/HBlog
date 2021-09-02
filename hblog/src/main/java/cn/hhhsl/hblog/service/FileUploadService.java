package cn.hhhsl.hblog.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileUploadService {

    List addfile(MultipartFile file, String catalogue);
}
