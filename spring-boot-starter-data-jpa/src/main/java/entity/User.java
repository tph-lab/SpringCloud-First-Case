package entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "user")
public class User {
    @Id  // JPA注解,指定此属性为表中的主键
    //@GeneratedValue 用于标注主键的生成策略，通过 strategy 属性指定。默认情况下，JPA 自动选择一个最适合底层数据库的主键生成策略：
    // SqlServer 对应 identity，MySQL 对应 auto increment。
    //  在 javax.persistence.GenerationType 中定义了以下几种可供选择的策略：
    @GeneratedValue(strategy = GenerationType.IDENTITY)         //mybatis获取新插入的id，必须要写的
    private Long id;
    private String name;
    private Integer age;
    private String email;
}