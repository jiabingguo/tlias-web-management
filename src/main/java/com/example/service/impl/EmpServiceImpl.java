package com.example.service.impl;


import com.example.mapper.EmpMapper;
import com.example.pojo.Emp;
import com.example.pojo.PageBean;
import com.example.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    //分页查询员工信息
    @Override
    public PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
        //获取总记录数
        Integer count=empMapper.count();
        //每页的起始页码
        Integer start=(page - 1) * pageSize;
        List<Emp> empList=empMapper.list(start,pageSize,name,gender,begin,end);
        PageBean pageBean = new PageBean(count,empList);
        return pageBean;
    }

    @Override
    public void delete(List<Integer> ids) {
        empMapper.delete(ids);
    }

    @Override
    public void insert(Emp emp) {
        empMapper.insert(emp);
    }

    @Override
    public Emp select(Integer id) {
        return empMapper.select(id);
    }

    @Override
    public void upadte(Emp emp) {
        empMapper.update(emp);


    }


    //分页查询员工信息（简化版）插件版本不匹配
//    public PageBean page(Integer page, Integer pageSize) {
//        //设置分页参数
//        PageHelper.startPage(page,pageSize);
//        List<Emp> empList=empMapper.list();
//        Page<Emp> p=(Page<Emp>) empList;
//        PageBean pageBean = new PageBean((int) p.getTotal(),p.getResult());
//        return pageBean;
//    }



}
