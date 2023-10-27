package com.example.mapper;

import com.example.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {

    @Select("select * from dept")
    List<Dept> list();

    @Delete("delete from dept where id = #{id}")
    void delete(Integer id);

    @Insert("insert into dept(name, create_time, update_time) values(#{name},now(),now())")
    void insert(Dept dept);

    @Select("select * from dept where id=#{id}")
    Dept selectById(Integer id);

    @Update("update dept set id=#{id},name=#{name},create_time=now(),update_time=now() where id=#{id}")
    void update(Dept dept);
}
