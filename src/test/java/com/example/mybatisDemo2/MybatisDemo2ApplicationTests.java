package com.example.mybatisDemo2;

import com.example.mapper.EmpMapper;
import com.example.pojo.Emp;
import org.apache.ibatis.annotations.Select;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class MybatisDemo2ApplicationTests {

    @Autowired
    private EmpMapper empMapper;

    @Test
    public void delete() {
        empMapper.delete(17);
    }


    @Test
    public void select() {
        System.out.println(empMapper.getEmpByID(16));

    }

    @Test
    public void Insert() {
        Emp emp = new Emp();
        emp.setUsername("tom2");
        emp.setName("汤姆");
        emp.setImage("1.jpg");
        emp.setGender((short) 1);
        emp.setJob((short) 1);
        emp.setEntrydate(LocalDate.of(2000, 1, 1));
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(1);

        empMapper.insert(emp);
    }

    @Test
    public void Update() {

        Emp emp = new Emp();
        emp.setId(17);
        emp.setUsername("tom3");
        emp.setName("汤姆123");
        emp.setImage("1.jpg");
        emp.setGender((short) 1);
        emp.setJob((short) 1);
        emp.setEntrydate(LocalDate.of(2000, 1, 1));
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(1);

        empMapper.update(emp);
    }


    /**
     * 条件查询、模糊查询
     */
    @Test
    public void Select() {
        LocalDate startTime = LocalDate.parse("2000-01-01");
        LocalDate endTime = LocalDate.parse("2022-01-01");
        System.out.println(empMapper.getEmpList("宋", startTime, endTime));
    }
}
