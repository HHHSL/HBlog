package cn.hhhsl.hblog.controller;

import cn.hhhsl.hblog.pojo.Daily;
import cn.hhhsl.hblog.pojo.Note;
import cn.hhhsl.hblog.pojo.vo.ReturnResults;
import cn.hhhsl.hblog.service.DailyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @PostMapping("/add")
    public ReturnResults add(@RequestParam("file") MultipartFile file, Daily daily){
        if (dailyService.adddaily(file,daily) == 1){
            return new ReturnResults().success();
        }else {
            return new ReturnResults().error();
        }
    }

    @GetMapping("/sel/{id}")
    public ReturnResults selrecommendbyid(@PathVariable int id) {
        if (dailyService.seldailybyid(id) != null){
            return new ReturnResults().success(dailyService.seldailybyid(id));
        }else {
            return new ReturnResults().error();
        }
    }

    @PostMapping("/up")
    public ReturnResults up(Daily daily) {
        if (dailyService.up(daily) == 1){
            return new ReturnResults().success();
        }else {
            return new ReturnResults().error();
        }
    }
    @GetMapping("/del/{id}")
    public ReturnResults del(@PathVariable int id) {
        if (dailyService.del(id) == 1){
            return new ReturnResults().success();
        }else {
            return new ReturnResults().error();
        }
    }
}
