package cn.hhhsl.hblog.service.impl;


import cn.hhhsl.hblog.service.FileUploadService;

import cn.hhhsl.hblog.utils.FileUtil;
import com.alibaba.fastjson.JSONObject;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;


@Service
public class FileUploadServiceImpl implements FileUploadService {
    // 设置好账号的ACCESS_KEY和SECRET_KEY
    String ACCESS_KEY = "nmgpWujY_Ll9QQZY_xdDC4ClgKju1cVtGSrm73Ir";
    String SECRET_KEY = "APSKWHjn0vIquZZuuXuvQVcl3EsWGqvQJMJoIgB1";
    // 要上传的空间
    String bucketname = "hhhsl";

    // 密钥配置
    Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
    // 构造一个带指定Zone对象的配置类,不同的七云牛存储区域调用不同的zone
    Configuration cfg = new Configuration(Zone.zone2());
    // ...其他参数参考类注释
    UploadManager uploadManager = new UploadManager(cfg);

    // 测试域名，只有30天有效期
    private static String QINIU_IMAGE_DOMAIN = "http://qzawadqtq.hn-bkt.clouddn.com/";

    // 简单上传，使用默认策略，只需要设置上传的空间名就可以了
    public String getUpToken() {
        return auth.uploadToken(bucketname);
    }
    @Override
    public String saveImage(MultipartFile file) {
        try {
            int dotPos = file.getOriginalFilename().lastIndexOf(".");
            if (dotPos < 0) {
                return null;
            }
            String fileExt = file.getOriginalFilename().substring(dotPos + 1).toLowerCase();
            // 判断是否是合法的文件后缀
            if (!FileUtil.isFileAllowed(fileExt)){
                return null;
            }

            String fileName = UUID.randomUUID().toString().replaceAll("-", "") + "." + fileExt;
            // 调用put方法上传
            Response res = uploadManager.put(file.getBytes(), fileName, getUpToken());
            // 打印返回的信息
            if (res.isOK() && res.isJson()) {
                // 返回这张存储照片的地址
                return QINIU_IMAGE_DOMAIN + JSONObject.parseObject(res.bodyString()).get("key");
            } else {
                return null;
            }
        } catch (QiniuException e) {
            // 请求失败时打印的异常的信息
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

//    @Override
//    public List addfile(MultipartFile file, String catalogue) {
//        String filename = null;
//        List list = new ArrayList();
//        final String ROUTE = "C:/Users/20368/Desktop/HHHSL/Code/HBlog/hblogweb/img/";
//        InputStream is = null;
//        FileOutputStream fos = null;
//        try {
//            filename = System.currentTimeMillis()+file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
//            is = file.getInputStream();
//            fos = new FileOutputStream(new File(ROUTE+catalogue+"/"+filename));
//            byte datas[] = new byte[1024*8];
//            int len = 0;//创建长度
//            while((len = is.read(datas))!=-1){
//                fos.write(datas,0,len);
//            }
//            fos.close();
//            is.close();
//            list.add("img/"+catalogue+"/");
//            list.add(filename);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return list;
//    }

}
