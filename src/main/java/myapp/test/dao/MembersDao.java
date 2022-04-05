package myapp.test.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import myapp.test.vo.LoginDto;

@Mapper
public interface MembersDao {
	String login(String id);
}



