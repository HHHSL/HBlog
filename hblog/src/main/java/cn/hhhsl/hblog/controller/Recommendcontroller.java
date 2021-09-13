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
        if (recommendService.add(file,recommend) == 1){
            return new ReturnResults().success();
        }else {
            return new ReturnResults().error();
        }

    }

    @GetMapping("/del/{id}")
    public ReturnResults del(@PathVariable int id) {
        if (recommendService.delrecommend(id) == 1){
            return new ReturnResults().success();
        }else {
            return new ReturnResults().error();
        }
    }

    @GetMapping("/sel/{id}")
    public ReturnResults selrecommendbyid(@PathVariable int id) {
        if (recommendService.selrecommendbyid(id) != null){
            return new ReturnResults().success(recommendService.selrecommendbyid(id));
        }else {
            return new ReturnResults().error();
        }
    }
    @PostMapping("/up")
    public ReturnResults up(@RequestParam("file") MultipartFile file,Recommend recommend) {
        if (recommendService.up(file,recommend) == 1){
            return new ReturnResults().success();
        }else {
            return new ReturnResults().error();
        }
    }

}
