package cn.hhhsl.hblog.service.impl;

import cn.hhhsl.hblog.mapper.NoteMapper;
import cn.hhhsl.hblog.pojo.Note;
import cn.hhhsl.hblog.pojo.Recommend;
import cn.hhhsl.hblog.service.FileUploadService;
import cn.hhhsl.hblog.service.NoteService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteMapper noteMapper;
    @Autowired
    private FileUploadService fileUploadService;
    @Override
    public List<Note> getnote() {
        QueryWrapper<Note> noteQueryWrapper = new QueryWrapper<>();
        return noteMapper.selectList(noteQueryWrapper);
    }

    @Override
    public int addnote(MultipartFile file,Note note) {
        String imgUrl = fileUploadService.saveImage(file);
        note.setPictureaddress(imgUrl);
        note.setTime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        return noteMapper.insert(note);
    }

    @Override
    public Object selnotebyid(int id) {
        return noteMapper.selectById(id);
    }

    @Override
    public int up(MultipartFile file, Note note) {
        String imgUrl = fileUploadService.saveImage(file);
        note.setPictureaddress(imgUrl);
        note.setTime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        return noteMapper.updateById(note);
    }

    @Override
    public int del(int id) {
        return noteMapper.deleteById(id);
    }
}
