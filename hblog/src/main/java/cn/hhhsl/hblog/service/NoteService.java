package cn.hhhsl.hblog.service;


import cn.hhhsl.hblog.pojo.Note;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface NoteService {

    List<Note> getnote();

    int addnote(MultipartFile file,Note note);

    Object selnotebyid(int id);

    int up(Note note);

    int del(int id);
}
