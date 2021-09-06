package cn.hhhsl.hblog.service;

import cn.hhhsl.hblog.pojo.Daily;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface DailyService {
    List<Daily> getdaily();

    int adddaily(MultipartFile file, Daily daily);

    Object seldailybyid(int id);

    int up(Daily daily);

    int del(int id);
}
