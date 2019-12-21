package com.ms.dao;

import com.ms.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserMapper {

    @Select("SELECT * FROM user WHERE username = #{username} AND password = #{password}")
    public User selectByUsernameAndPassword(@Param("username") String username,
                                            @Param("password") String password);

    @Update("UPDATE user SET username = #{username},password = #{password}," +
            "realName = #{realName},sex = #{sex} WHERE user_id = #{user_id}")
    public int updateUser(User user);

    @Options(useGeneratedKeys = true,keyColumn = "user_id")
    @Insert("INSERT INTO user (user_id, username, password, realName, sex) " +
            "VALUES (#{user_id},#{username},#{password},#{realName},#{sex})")
    public int insertUser(User user);

    @Select("SELECT * FROM user WHERE user_id = #{id}")
    public User selectUserById(@Param("id") Integer id);

    @Select("SELECT * FROM user")
    public List<User> selectAll();

}
