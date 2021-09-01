package cn.hhhsl.hblog.service.impl;

import cn.hhhsl.hblog.mapper.RecommendMapper;
import cn.hhhsl.hblog.pojo.Recommend;
import cn.hhhsl.hblog.service.RecommendService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class RecommendServiceImpl implements RecommendService {
    @Autowired
    private RecommendMapper recommendMapper;
    @Override
    public List<Recommend> getrecommend() {
        QueryWrapper<Recommend> recommendQueryWrapper = new QueryWrapper<>();
        return recommendMapper.selectList(recommendQueryWrapper);
    }
}
