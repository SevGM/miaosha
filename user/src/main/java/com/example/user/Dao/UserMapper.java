package com.example.user.Dao;

import com.example.user.Entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jdbc.repository.query.Query;

import java.util.List;

@Mapper
public interface UserMapper {
    @Query("SELECT username,password FROM tb_user WHERE username=#{user.getUserName()}")
    List<User> getUser(User user);

    @Insert("INSERT INTO tb_user(username, password, phone, create_time, update_time) " +
            "VALUES(#{userName}, #{password}, #{phone}, " +
            "#{creat_time}, #{update_time})")
    int addUser(User user);
}
