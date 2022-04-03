package com.example.demo_backend.mapper;

import com.example.demo_backend.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    @Insert("insert into User (id, email, tel, username, password) values (#{id}, #{email}, #{tel}, #{username}, #{password})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    Boolean insertUser(User user);

    @Select("select * from User where username=#{username}")
    User findUserByUsername(String username);
}
