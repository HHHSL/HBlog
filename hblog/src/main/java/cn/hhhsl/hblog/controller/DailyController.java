package cn.hhhsl.hblog.controller;

import cn.hhhsl.hblog.pojo.vo.ReturnResults;
import cn.hhhsl.hblog.service.DailyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/daily")
@CrossOrigin
public class DailyController {
    @Autowired
    private DailyService dailyService;

    @GetMapping("/sel")
    public ReturnResults sel(){
        return new ReturnResults().success(dailyService.getdaily());
    }
}
