package cn.chenzw.springboot.mybatis.plus.modules.idkey.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@TableName("tb_user")
public class User {

    /**
     * 指定ID生成方式
     */
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    private String name;

    /**
     * 逻辑状态值（查询只会查询生效的值）
     */
    @TableLogic(value = "0", delval = "1")
    @TableField(fill = FieldFill.INSERT)
    private Boolean isDeleted;

    /**
     * 新增时自动填充
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 新增、修改时自动填充
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

}
