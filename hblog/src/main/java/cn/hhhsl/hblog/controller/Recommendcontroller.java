package cn.hhhsl.hblog.controller;

import cn.hhhsl.hblog.pojo.vo.ReturnResults;
import cn.hhhsl.hblog.service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



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


}
