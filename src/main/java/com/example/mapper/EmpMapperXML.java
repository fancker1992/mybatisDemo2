package com.example.mapper;

import com.example.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

/*@Mapper注解：表示当前接口为mybatis中的Mapper接口
  程序运行时会自动创建接口的实现类对象(代理对象)，并交给Spring的IOC容器管理
*/
@Mapper
public interface EmpMapperXML {

    /**
     * 查询所有
     */
    public List<Emp> getEmpListAll();

    /**
     * 通过ID查询
     */
    public List<Emp> getEmpByID(Integer id);

    /**
     * 模糊查询
     */

    public List<Emp> getEmpList(String name, LocalDate begin, LocalDate end);


    /**
     * 删除
     * //@Delete("delete from emp where id = 17")
     * //public void delete();
     * //以上delete操作的SQL语句中的id值写成固定的17，就表示只能删除id=17的用户数据
     * //SQL语句中的id值不能写成固定数值，需要变为动态的数值
     * //解决方案：在delete方法中添加一个参数(用户id)，将方法中的参数，传给SQL语句
     */

    @Delete("delete from emp where id = #{id}")  //使用#{key}方式获取方法中的参数值
    public void delete(Integer id);

    //批量删除
    public void deleteByIds(List<Integer> ids);


    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time) values (#{username}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime})")
    public void insert(Emp emp);


    public void update(Emp emp);

}
