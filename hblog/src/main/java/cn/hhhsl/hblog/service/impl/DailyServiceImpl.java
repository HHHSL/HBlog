package cn.hhhsl.hblog.service.impl;

import cn.hhhsl.hblog.mapper.DailyMapper;
import cn.hhhsl.hblog.pojo.Daily;
import cn.hhhsl.hblog.service.DailyService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DailyServiceImpl implements DailyService {
    @Autowired
    private DailyMapper dailyMapper;

    @Override
    public List<Daily> getdaily() {
        QueryWrapper<Daily> queryWrapper = new QueryWrapper();
        return dailyMapper.selectList(queryWrapper);
    }
}
