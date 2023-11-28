package kr.co.pmy.planner.service;

import kr.co.pmy.planner.vo.UserVo;

public interface UserService {

	void insert(UserVo vo);

	UserVo login(UserVo vo);

}
