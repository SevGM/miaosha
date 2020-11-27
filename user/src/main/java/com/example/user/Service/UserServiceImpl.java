package com.example.user.Service;

import com.example.user.Dao.UserMapper;
import com.example.user.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserMapper userMapper;

    /**
     * 用户注册
     * @param user：传入name,phone,password
     * @return 以上三项不能为空，否则会报错，若插入成功会返回注册成功提示
     */
    @Override
    @Transactional
    public Map<String, Object> insertUser(User user) {
        Map<String, Object> res = new HashMap<>();
        if(user.getUserName() == null || user.getUserName().equals("")){
            res.put("msg", "用户名不能为空");
            res.put("result", false);
            return res;
        }
        if(user.getPassword() == null || user.getPassword().equals("")){
            res.put("msg", "密码不能为空");
            res.put("result", false);
            return res;
        }
        if(user.getPhone() == null || user.getPhone().equals("")){
            res.put("msg", "手机号不能为空");
            res.put("result", false);
            return res;
        }
        // 添加时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = simpleDateFormat.format(new Date());
        user.setCreat_time(Timestamp.valueOf(now));
        user.setUpdate_time(Timestamp.valueOf(now));
        int insert = userMapper.addUser(user);
        if(insert > 0){
            res.put("msg", "注册成功");
            res.put("result", true);
            return res;
        }else{
            res.put("msg", "数据库写入失败");
            res.put("result", false);
            return res;
        }
    }

    @Override
    public Map<String, Object> login(User user) {
        return null;
    }
}
