package com.example.controller;


import com.example.pojo.Emp;
import com.example.pojo.PageBean;
import com.example.pojo.Result;
import com.example.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
public class EmpController {

    @Autowired
    private EmpService empService;

    //查询员工信息
    @GetMapping("/emps")
    public Result selectByPage(@RequestParam(defaultValue = "1") Integer page,
                               @RequestParam(defaultValue = "10") Integer pageSize,
                               String name, Short gender,
                               @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin, LocalDate end) {
        PageBean pageBean = empService.page(page,pageSize,name,gender,begin,end);
        return Result.success(pageBean);

    }

    //批量删除员工
    @DeleteMapping("/emps/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        empService.delete(ids);
        return Result.success();
    }

    //增加员工
    @PostMapping("/emps")
    public Result insert(@RequestBody Emp emp){
        empService.insert(emp);
        return Result.success();
    }

    //根据id查询
    @GetMapping("/emps/{id}")
    public Result select(@PathVariable Integer id){
        Emp emp=empService.select(id);
        return Result.success(emp);
    }

    //修改员工信息
    @PutMapping("/emps")
    public Result update(@RequestBody Emp emp){
        System.out.println(emp);
        empService.upadte(emp);
        return Result.success();
    }
}
