package cn.hhhsl.hblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
@CrossOrigin
public class JumpController {
    //    前台
    @RequestMapping("")
    public String index1(){return "index";}
    @RequestMapping("index")
    public String index(){return "index";}
    @RequestMapping("/recommend")
    public String recommend(){return "recommend";}
    @RequestMapping("/note")
    public String note(){return "note";}
    @RequestMapping("/daily")
    public String daily(){return "daily";}


    @GetMapping("/404")
    public String notFoundPage() {return "404";}
    @GetMapping("/403")
    public String accessError() {return "403";}
    @GetMapping("/500")
    public String internalError() {return "500";}
    //后台页面
    @RequestMapping("/signin")
    public String login(){return "signin";}
    @RequestMapping("/admin")
    public String admin(){return "admin";}
    @RequestMapping("/admin/recommend")
    public String admin_recommend(){return "admin/recommend";}
    @RequestMapping("/admin/note")
    public String admin_note(){return "admin/note";}
    @RequestMapping("/admin/daily")
    public String admin_daily(){return "admin/daily";}
}
