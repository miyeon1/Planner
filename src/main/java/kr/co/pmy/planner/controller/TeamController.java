package kr.co.pmy.planner.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import egovframework.rte.fdl.cmmn.exception.FdlException;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import kr.co.pmy.planner.service.TeamService;
import kr.co.pmy.planner.vo.TeamVo;

@Controller
public class TeamController {
	
	@Resource(name = "teamCodeGnr")
	private EgovIdGnrService teamCodeGnr;
	
	@Autowired
	TeamService teamService;
	
	@GetMapping("/teamInsert.do")
	public String insert(HttpSession session, Model model, TeamVo vo) {
//			insert화면에 현재 접속중인 사용자의 id
			String id = (String) session.getAttribute("id");
			model.addAttribute("id",id);
			
			return "/team/insert";
	}
	
	@PostMapping("/teamInsert.do")
	public String insert(TeamVo vo, HttpSession session) throws Exception {
		
//		팀코드 자동생성
		String teamCode = (String) session.getAttribute("id")+teamCodeGnr.getNextStringId(); //현재 로그인한 아이디와 TEAMCODE숫자로 조합된 자동채번
		vo.setCode(teamCode);
		
		teamService.insert(vo);
		return "redirect:/myPage.do";
	}
}
