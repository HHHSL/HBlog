package cn.hhhsl.hblog.service.impl;

import cn.hhhsl.hblog.mapper.NoteMapper;
import cn.hhhsl.hblog.pojo.Note;
import cn.hhhsl.hblog.pojo.Recommend;
import cn.hhhsl.hblog.service.FileUploadService;
import cn.hhhsl.hblog.service.NoteService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
        List list = fileUploadService.addfile(file, "note");
        if (list != null){
            note.setPicture((String) list.get(0));
            note.setPicturename((String) list.get(1));
        }
        return noteMapper.insert(note);
    }

    @Override
    public Object selnotebyid(int id) {
        return noteMapper.selectById(id);
    }

    @Override
    public int up(Note note) {
        return noteMapper.updateById(note);
    }

    @Override
    public int del(int id) {
        return noteMapper.deleteById(id);
    }
}
