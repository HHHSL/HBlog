package cn.hhhsl.hblog.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
/**
 * 日常内容
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@TableName(value = "daily")
public class Daily {
    @TableId(type = IdType.AUTO)
    private int id; //id
    private String content; //内容
    private String time;//时间
    private String source;//来源
    private String picture;//图片地址
    private String picturename;//图片名字
}
