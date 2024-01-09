package kr.co.pmy.planner.mapper;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.co.pmy.planner.vo.TeamVo;

@Mapper
public interface TeamMapper {

	void insert(TeamVo vo);

	List<TeamVo> teamList();

}
