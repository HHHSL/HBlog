package cn.hhhsl.hblog.service.impl;

import cn.hhhsl.hblog.mapper.DailyMapper;
import cn.hhhsl.hblog.pojo.Daily;
import cn.hhhsl.hblog.service.DailyService;
import cn.hhhsl.hblog.service.FileUploadService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class DailyServiceImpl implements DailyService {
    @Autowired
    private DailyMapper dailyMapper;
    @Autowired
    private FileUploadService fileUploadService;

    @Override
    public List<Daily> getdaily() {
        QueryWrapper<Daily> queryWrapper = new QueryWrapper();
        return dailyMapper.selectList(queryWrapper);
    }

    @Override
    public int adddaily(MultipartFile file, Daily daily) {
        if (file != null){
            String s = fileUploadService.saveImage(file,"daily");

        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
        daily.setTime(simpleDateFormat.format(new Date()));
        return dailyMapper.insert(daily);
    }

    @Override
    public Daily seldailybyid(int id) {
        return dailyMapper.selectById(id);
    }

    @Override
    public int up(Daily daily) {
        return dailyMapper.updateById(daily);
    }

    @Override
    public int del(int id) {
        return dailyMapper.deleteById(id);
    }
}
