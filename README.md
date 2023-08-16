### Mybatis基础操作

- mybatis 入门，参考上一个工程 mybatisDemo
- 本工程讲解mybatis增删改查功能

##### 前置步骤

- 新建mapper文件
- 新建mapper接口（例：empMapper）

#### 注解方式

- 可参考EmpMapper文件

##### 增

- 使用注解:@Insert

##### 删

- 使用注解 @Delete
- 例:@Delete("delete from emp where id = #{id}")
- 预编译方式，1、性能高 2、防止sql注入

##### 改

- 使用注解:@Update()

##### 查

- 使用注解Select(),例： @Select("select * from emp where id = #{id}")
- 变量可以用 #{} 的形式传递

##### 模糊查询

- 使用concat函数拼接，例：
- @Select("select * from emp where name like concat('%',#{name},'%') and entrydate between #{begin} and #{end} order by
  create_time desc")
- 预编译方式，1、性能高 2、防止sql注入

##### 练习参考

- test目录下 MybatisDemo2ApplicationTests类

##### 日志

- 指定mybatis输出日志的位置, 输出控制台
- 配置参考文件：application.yml 下mybatis目录

#### XML配置方式

- 1、新建mapper文件，例：EmpMapperXML文件
- 2、resources目录下新建包名，路径同mapper一致  例：com/example/mapper
  - 注意：虽然显示的目录为 com.example.mapper,但是新建时需要用'/' 代替， 这样写 com/example/mapper  ，否则  xml配置文件无法绑定mapper
- 2、resources目录下新建xml配置文件 例：[EmpMapperXML.xml]
- 3、test目录下 MybatisXMLTests测试类
- 知识点（xml配置文件）：
    - select 标签
    - where 子标签
    - if 子标签
    - delete 标签
    - update 标签
    - foreach 标签
- 规范：
  - 

      1. XML映射文件的名称与Mapper接口名称一致，并且将XML映射文件和Mapper接口放置在相同包下（同包同名）
      2. XML映射文件的namespace属性为Mapper接口全限定名一致
      3. XML映射文件中sql语句的id与Mapper接口中的方法名一致，并保持返回类型一致。

- 这些标签，可以构造动态sql语句，根据输入条件操作不同的数据

#### 提效工具
- mybatisX   国产优秀框架
