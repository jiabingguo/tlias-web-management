package com.example.controller;

import com.example.pojo.Dept;
import com.example.pojo.Result;
import com.example.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j//日志注解
@RestController
@RequestMapping("/depts")
public class DeptController {

    @Autowired
    private DeptService deptService;

    //查询部门信息
    @GetMapping
    public Result list(){
        List<Dept> list = deptService.list();
        return Result.success(list);
    }

    //删除部门信息
    //请求响应-路径参数
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        deptService.delete(id);
        return Result.success();
    }

    //增加部门信息
    @PostMapping
    public Result insert(@RequestBody Dept dept){
        boolean a=false;
        List<Dept> list = deptService.list();
        for(int i=0;i<list.size();i++){
            boolean flag=dept.getName().equals(list.get(i).getName());
            if(flag==true){
                a=true;
            }
        }
        if(a){
            return Result.error("部门已存在");
        }else {
            deptService.insert(dept);
            return Result.success();
        }
    }

    //根据Id查询部门信息
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        Dept dept = deptService.selectById(id);
        return Result.success(dept);
    }

    //修改部门
    @PutMapping
    private Result update(@RequestBody Dept dept){
        boolean a=false;
        List<Dept> list = deptService.list();
        for(int i=0;i<list.size();i++){
            boolean flag=dept.getName().equals(list.get(i).getName());
            if(flag==true){
                a=true;
            }
        }
        if(a){
            return Result.error("部门已存在");
        }else {
            deptService.update(dept);
            return Result.success();
        }

    }
}
