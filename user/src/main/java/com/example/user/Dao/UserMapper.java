package com.example.user.Dao;

import com.example.user.Entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jdbc.repository.query.Query;

import java.util.List;

@Mapper
public interface UserMapper {
    @Query("SELECT username,password FROM tb_user WHERE username=#{user.getUserName()}")
    public List<User> queryUser(User user);

    @Query("INSERT INTO tb_user(username, password, phone, creat_time, update_time) " +
            "VALUES(user.getUserName(), user.getPassword(), user.getPhone(), " +
            "user.getCreat_time(), user.getUpdate_time())")
    int addUser(User user);
}
