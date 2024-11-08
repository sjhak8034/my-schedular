package com.example.jhschedular.repository;

import com.example.jhschedular.dto.response.user.ResponseToEditUserDto;
import com.example.jhschedular.dto.response.user.ResponseToRegisterUserDto;
import com.example.jhschedular.entity.User;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Optional;


@Repository
public class JdbcTemplateUserRepository implements UserRepository {
    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateUserRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public ResponseToRegisterUserDto registerUser(User entity) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(this.jdbcTemplate);
        simpleJdbcInsert.withTableName("user").usingGeneratedKeyColumns("user_id");
        MapSqlParameterSource params = new MapSqlParameterSource();

        params.addValue("user_name", entity.getUserName());
        params.addValue("register_date", entity.getRegisterDate());
        params.addValue("edit_date", entity.getEditDate());
        params.addValue("email", entity.getEmail());

        try {
            Number userId = simpleJdbcInsert.executeAndReturnKey(params);
            return new ResponseToRegisterUserDto(Optional.of(userId).map(Number::longValue));
        } catch (DataIntegrityViolationException e) {
            System.out.println(e.getMessage());
            return new ResponseToRegisterUserDto(null);
        }

    }
    @Override
    public ResponseToEditUserDto editUser(User entity) {
        int result = jdbcTemplate.update("update user set user_name= ?, edit_date = ?, email = ? where user_id = ?",
                entity.getUserName(), entity.getEditDate(), entity.getEmail(), entity.getUserId());
        return new ResponseToEditUserDto(entity.getUserId(), result);
    }
}
