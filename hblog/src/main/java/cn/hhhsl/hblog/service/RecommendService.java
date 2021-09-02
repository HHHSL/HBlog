package cn.hhhsl.hblog.service;

import cn.hhhsl.hblog.pojo.Recommend;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface RecommendService {

    List<Recommend> getrecommend();

    int add(MultipartFile file,Recommend recommend);
}
