package cn.hhhsl.hblog.controller;

import cn.hhhsl.hblog.pojo.vo.ReturnResults;
import cn.hhhsl.hblog.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/note")
@CrossOrigin
public class NoteController {
    @Autowired
    private NoteService noteService;

    @GetMapping("/sel")
    public ReturnResults sel(){
        return new ReturnResults().success(noteService.getnote());
    }

}
