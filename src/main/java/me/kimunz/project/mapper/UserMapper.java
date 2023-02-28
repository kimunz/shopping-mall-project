package me.kimunz.project.mapper;

import me.kimunz.project.entity.Authority;
import me.kimunz.project.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

@Mapper
public interface UserMapper {
    Optional<User> findOneWithAuthoritiesByUsername(String username);
    int save(User user);
    int saveAuthority(@Param("user") User user, @Param("authority") Authority authority);
}
