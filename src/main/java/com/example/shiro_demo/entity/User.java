package com.example.shiro_demo.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;

/**
 * (User)实体类
 *
 * @author XingGao
 * @since 2022-03-24 14:31:20
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("user")
public class User extends Model<User> {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * ${column.comment}
     */
    @TableField(value = "account")
    private String account;

    /**
     * ${column.comment}
     */
    @TableField(value = "password")
    private String password;

    /**
     * ${column.comment}
     */
    @TableField(value = "role")
    private String role;

}

