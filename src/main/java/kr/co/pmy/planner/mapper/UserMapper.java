package kr.co.pmy.planner.mapper;


import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.co.pmy.planner.vo.UserVo;

@Mapper
public interface UserMapper {

	void insert(UserVo vo);

	UserVo login(UserVo vo);

}
