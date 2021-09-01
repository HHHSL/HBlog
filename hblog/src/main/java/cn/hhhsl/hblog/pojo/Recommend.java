package cn.hhhsl.hblog.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 推荐内容
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@TableName(value = "recommend")
public class Recommend {
    @TableId(type = IdType.AUTO)
    private int id;//id
    private String title;//标题
    private String introduce;//介绍
    private String address;//文章地址
    private String language;//使用语言
    private String picture;//图片地址
    private String picturename;//图片名字

}
