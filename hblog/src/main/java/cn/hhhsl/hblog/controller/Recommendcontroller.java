package cn.hhhsl.hblog.controller;

import cn.hhhsl.hblog.pojo.Recommend;
import cn.hhhsl.hblog.pojo.vo.ReturnResults;
import cn.hhhsl.hblog.service.FileUploadService;
import cn.hhhsl.hblog.service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("api/recommend")
@CrossOrigin
public class Recommendcontroller {

    @Autowired
    private RecommendService recommendService;

    @GetMapping("/sel")
    public ReturnResults sel() {
        return new ReturnResults().success(recommendService.getrecommend());
    }

    @PostMapping("/add")
    public ReturnResults add(@RequestParam("file") MultipartFile file, Recommend recommend) {
        System.out.println(recommendService.add(file,recommend));
        return new ReturnResults().success();
    }



}
