package cn.hhhsl.hblog.service.impl;

import cn.hhhsl.hblog.mapper.RecommendMapper;
import cn.hhhsl.hblog.pojo.Recommend;
import cn.hhhsl.hblog.service.FileUploadService;
import cn.hhhsl.hblog.service.RecommendService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.text.SimpleDateFormat;
import java.util.Date;
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
        String imgUrl = fileUploadService.saveImage(file,"recommend");
        recommend.setPictureaddress(imgUrl);
        recommend.setTime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        return recommendMapper.insert(recommend);
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
    public int up(MultipartFile file,Recommend recommend) {
        String imgUrl = fileUploadService.saveImage(file,"recommend");
        recommend.setPictureaddress(imgUrl);
        recommend.setTime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        return recommendMapper.updateById(recommend);
    }


}
