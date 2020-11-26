package com.want.entity;
 
import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.want.annotation.MyConstraint;

import lombok.Data;

 
@Data
public class User_1 implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
     * 主键ID
     */
    private Long id;

    @NotBlank(message = "用户名不能为空")
    @Length(min = 5, max = 20, message = "用户名长度为5-20个字符")
    private String name;

    @NotNull(message = "年龄不能为空")
    @Min(value = 18 ,message = "最小18岁")
    @Max(value = 60,message = "最大60岁")
    private Integer age;

/*    @NotBlank(message = "电话不可以为空")
    @Length(min = 1, max = 13, message = "电话长度需要在13个字符以内")
    private String phone;*/

    @Email(message = "请输入邮箱")
    @NotBlank(message = "邮箱不能为空")
    private String email;

   /* @NotNull(message = "必须指定用户状态")
    @Min(value = 0, message = "用户状态不合法")
    @Max(value = 1, message = "用户状态不合法")
    private Integer status;*/

    @MyConstraint
    private String answer;

}
