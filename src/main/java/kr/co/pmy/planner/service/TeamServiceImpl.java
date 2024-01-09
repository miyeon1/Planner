package kr.co.pmy.planner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.pmy.planner.mapper.TeamMapper;
import kr.co.pmy.planner.vo.TeamVo;

@Service
public class TeamServiceImpl implements TeamService {

	@Autowired
	TeamMapper mapper;
	
	@Override
	public void insert(TeamVo vo) {
		mapper.insert(vo);
	}

	@Override
	public List<TeamVo> teamList() {
		return mapper.teamList();
	}

}
