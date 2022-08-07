

// 3-6 通过接受bean的业务对象引出验证框架
// 3-7 使用Hibernate对Bean参数进行校验


package com.imooc.pojo.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;
import java.util.List;


@Data
@ToString
@AllArgsConstructor
public class DbStuBO {

    private String id;
    @NotBlank   //3-7
    private String name;
    @NotNull    //3-7
    private Integer sex;

    // 3-8 Hibernate校验参数扩展
    @Min(value = 1, message = "学生的年纪最小为1年级")
    @Max(value = 6, message = "学生的年纪最大为6年级")
    private Integer grade;
    @Range(min = 1, max = 6, message = "学生的所在班级区间为1~18")
    private Integer classroom;
    @Size(min = 2, max = 5, message = "技能写至少2个，最多5个")
    private List<String > skill;
    @Length(min = 3, max = 8, message = "英文名长度区间在3~8")
    private String englishName;
    @Email(message = "邮箱格式不正确")
    private String email;

}
