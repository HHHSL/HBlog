package cn.hhhsl.hblog.service.impl;

import cn.hhhsl.hblog.mapper.NoteMapper;
import cn.hhhsl.hblog.pojo.Note;
import cn.hhhsl.hblog.pojo.Recommend;
import cn.hhhsl.hblog.service.NoteService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteMapper noteMapper;

    @Override
    public List<Note> getnote() {
        QueryWrapper<Note> noteQueryWrapper = new QueryWrapper<>();
        return noteMapper.selectList(noteQueryWrapper);
    }
}
