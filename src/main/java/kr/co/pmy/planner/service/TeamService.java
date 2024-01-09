package kr.co.pmy.planner.service;

import java.util.List;

import kr.co.pmy.planner.vo.TeamVo;

public interface TeamService {

	void insert(TeamVo vo);

	List<TeamVo> teamList();

}
