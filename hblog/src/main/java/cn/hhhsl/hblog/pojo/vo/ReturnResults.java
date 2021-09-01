package cn.hhhsl.hblog.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class  ReturnResults {
    private int status;
    private String message;
    private Object data;

    public ReturnResults success(){
        return new ReturnResults(200,"消息发送成功",null);
    }
    public ReturnResults success(Object data){
        return new ReturnResults(200,"消息发送成功",data);
    }
    public ReturnResults error(){
        return new ReturnResults(500,"消息发送失败",null);
    }
}
