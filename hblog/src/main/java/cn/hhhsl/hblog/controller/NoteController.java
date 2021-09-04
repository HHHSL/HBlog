package cn.hhhsl.hblog.controller;

import cn.hhhsl.hblog.pojo.Note;
import cn.hhhsl.hblog.pojo.Recommend;
import cn.hhhsl.hblog.pojo.vo.ReturnResults;
import cn.hhhsl.hblog.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


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

    @PostMapping("/add")
    public ReturnResults add(@RequestParam("file") MultipartFile file, Note note){
        if (noteService.addnote(file,note) == 1){
            return new ReturnResults().success();
        }else {
            return new ReturnResults().error();
        }
    }
    @GetMapping("/sel/{id}")
    public ReturnResults selrecommendbyid(@PathVariable int id) {
        if (noteService.selnotebyid(id) != null){
            return new ReturnResults().success(noteService.selnotebyid(id));
        }else {
            return new ReturnResults().error();
        }
    }

    @PostMapping("/up")
    public ReturnResults up(Note note) {
        if (noteService.up(note) == 1){
            return new ReturnResults().success();
        }else {
            return new ReturnResults().error();
        }
    }
    @GetMapping("/del/{id}")
    public ReturnResults del(@PathVariable int id) {
        if (noteService.del(id) == 1){
            return new ReturnResults().success();
        }else {
            return new ReturnResults().error();
        }
    }
}
