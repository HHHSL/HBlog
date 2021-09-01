package cn.hhhsl.hblog.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 图片管理
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@TableName(value = "picture")
public class Picture {
    private int id;//id
    private int pid;//pid
    private String picturename;//图片名字
    private String picturebyte;//图片字节
    private String type;//图片类型
}
