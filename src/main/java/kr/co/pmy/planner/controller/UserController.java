package kr.co.pmy.planner.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.pmy.planner.service.TeamService;
import kr.co.pmy.planner.service.UserService;
import kr.co.pmy.planner.vo.TeamVo;
import kr.co.pmy.planner.vo.UserVo;

@Controller
public class UserController {
	
	@Autowired
	UserService userService; //회원가입 등 유저 정보에 대한 서비스
	
	@Autowired
	TeamService teamService; //team 개설에 대한 정보
	
	@GetMapping("/myPage.do")
	public String list(UserVo vo, Model model, HttpSession session) {
//		로그인이 되어 있는지 확인
		if ((String)session.getAttribute("id") != null) {
			
			vo.setId((String)session.getAttribute("id"));
			vo.setPw((String)session.getAttribute("pw"));
			
//			개인정보 가져오기 / 로그인 쿼리 사용 중
			UserVo myInfo = userService.login(vo);
			model.addAttribute("user", myInfo);
			
			List<TeamVo> teamList = teamService.teamList();
			model.addAttribute("teamList", teamList);
			
			return "/user/myPage";
		}else{
			return "redirect:/main.do";
		}
	}
	
	@GetMapping("/insert.do")
	public String insert() {
		return "/user/insert";
	}
	
	@PostMapping("/insert.do")
	public String insert(UserVo vo) {
		userService.insert(vo);
		return "redirect:/login.do";
	}
}
