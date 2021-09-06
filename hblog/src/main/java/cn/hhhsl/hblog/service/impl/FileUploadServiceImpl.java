package cn.hhhsl.hblog.service.impl;

import cn.hhhsl.hblog.service.FileUploadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


@Service
public class FileUploadServiceImpl implements FileUploadService {
    @Override
    public List addfile(MultipartFile file, String catalogue) {
        String filename = null;
        List list = new ArrayList();
        final String ROUTE = "C:/Users/20368/Desktop/HHHSL/Code/HBlog/hblogweb/img/";
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            filename = System.currentTimeMillis()+file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
            is = file.getInputStream();
            fos = new FileOutputStream(new File(ROUTE+catalogue+"/"+filename));
            byte datas[] = new byte[1024*8];
            int len = 0;//创建长度
            while((len = is.read(datas))!=-1){
                fos.write(datas,0,len);
            }
            fos.close();
            is.close();
            list.add("img/"+catalogue+"/");
            list.add(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
