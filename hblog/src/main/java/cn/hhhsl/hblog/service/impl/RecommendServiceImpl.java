package cn.hhhsl.hblog.service.impl;

import cn.hhhsl.hblog.mapper.RecommendMapper;
import cn.hhhsl.hblog.pojo.Recommend;
import cn.hhhsl.hblog.service.FileUploadService;
import cn.hhhsl.hblog.service.RecommendService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;
@Service
public class RecommendServiceImpl implements RecommendService {
    @Autowired
    private RecommendMapper recommendMapper;
    @Autowired
    private FileUploadService fileUploadService;
    @Override
    public List<Recommend> getrecommend() {
        QueryWrapper<Recommend> recommendQueryWrapper = new QueryWrapper<>();
        return recommendMapper.selectList(recommendQueryWrapper);
    }


    @Override
    public int add(MultipartFile file,Recommend recommend) {
        System.out.println(fileUploadService.saveImage(file));
//        List list = fileUploadService.addfile(file, "recommend");
//        if (list != null){
//            recommend.setPicture((String) list.get(0));
//            recommend.setPicturename((String) list.get(1));
//        }
        return 0;
    }

    @Override
    public int delrecommend(int id) {
        return recommendMapper.deleteById(id);
    }

    @Override
    public Recommend selrecommendbyid(int id) {
        return recommendMapper.selectById(id);
    }

    @Override
    public int up(Recommend recommend) {
        return recommendMapper.updateById(recommend);
    }


}
