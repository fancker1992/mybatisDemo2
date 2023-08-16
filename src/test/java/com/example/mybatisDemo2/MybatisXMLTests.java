package com.example.mybatisDemo2;

import com.example.mapper.EmpMapperXML;
import com.example.pojo.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class MybatisXMLTests {

    @Autowired
    public EmpMapperXML empMapperXML;


    @Test
    public void select() {
        System.out.println(empMapperXML.getEmpListAll());
    }

    @Test
    public void selectByID() {
        System.out.println(empMapperXML.getEmpByID(18));
    }


    /**
     * 模糊查询
     */
    @Test
    public void getEmpList() {
        LocalDate startTime = LocalDate.parse("2000-01-01");
        LocalDate endTime = LocalDate.parse("2023-01-02");
        System.out.println(empMapperXML.getEmpList("宋", startTime, endTime));

        // 只通过时间查询
        System.out.println(empMapperXML.getEmpList(null, startTime, endTime));
        // 无附加条件，就是查询所有
        System.out.println(empMapperXML.getEmpList(null, null, null));
    }


    @Test
    public void updateEmp() {
        // 只更新name，传哪个字段就只更新哪个字段
        Emp emp = new Emp();
        emp.setId(16);
        emp.setName("123");
        empMapperXML.update(emp);
    }

    @Test
    public void deleteByIds() {
        List<Integer> ids = new ArrayList<>();
        ids.add(17);
        ids.add(16);

        empMapperXML.deleteByIds(ids);
    }


}
