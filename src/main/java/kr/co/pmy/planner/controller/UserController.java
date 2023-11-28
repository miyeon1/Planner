package kr.co.pmy.planner.controller;

import javax.jms.Session;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.pmy.planner.service.UserService;
import kr.co.pmy.planner.vo.UserVo;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/myPage.do")
	public String list(UserVo vo, Model model, HttpSession session) {
		if ((String)session.getAttribute("id") != null) {
			
			vo.setId((String)session.getAttribute("id"));
			vo.setPw((String)session.getAttribute("pw"));
			
			UserVo myInfo = userService.login(vo);
			
			model.addAttribute("user", myInfo);
			
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
