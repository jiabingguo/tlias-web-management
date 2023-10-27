package com.example.mapper;

import com.example.pojo.Emp;
import com.example.pojo.PageBean;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface EmpMapper {

    //分页查询对数据的操作
    @Select("select count(*) from emp")
    Integer count();

    List<Emp> list(Integer start, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);


    void delete(List<Integer> ids);

    void insert(Emp emp);

    @Select("select * from emp where id=#{id}")
    Emp select(Integer id);


    //可使用动态SQL语句，只更新有修改的字段，提高效率
//    @Update("update emp set " +
//            "id=#{id},username=#{username},name=#{name}," +
//            "gender=#{gender},image=#{image},job=#{job}," +
//            "entrydate=#{entrydate},dept_id=#{deptId}," +
//            "create_time=now(),update_time=now() " +
//            "where id=#{id}")

    void update(Emp emp);
}
