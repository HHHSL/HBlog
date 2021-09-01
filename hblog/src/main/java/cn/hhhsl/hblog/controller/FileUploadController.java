package cn.hhhsl.hblog.controller;

import cn.hhhsl.hblog.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("api/fileupload")
@CrossOrigin
public class FileUploadController {
    @Autowired
    private FileUploadService fileUploadService;

    @PostMapping("/add/{catalogue}")
    public void add(@RequestParam("file") MultipartFile file,@PathVariable String catalogue){
        fileUploadService.addfile(file,catalogue);
    }
}
