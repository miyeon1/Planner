package kr.co.pmy.planner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.pmy.planner.mapper.UserMapper;
import kr.co.pmy.planner.vo.UserVo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public void insert(UserVo vo) {
		userMapper.insert(vo);
	}

	@Override
	public UserVo login(UserVo vo) {
		
		return userMapper.login(vo);
	}

}
