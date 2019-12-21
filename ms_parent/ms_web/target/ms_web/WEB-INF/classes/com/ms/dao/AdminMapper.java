package com.ms.dao;

import com.ms.entity.Admin;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface AdminMapper {

    @Select("SELECT * FROM admin WHERE username = #{username} AND password = #{password}")
    public Admin selectAdminByUsernameAndPassword(@Param("username") String username ,
                                                  @Param("password") String password);


}
