package kr.co.pmy.planner.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.pmy.planner.service.UserService;
import kr.co.pmy.planner.vo.UserVo;

@Controller
public class RootController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "redirect:/main.do";
	}
	
	@GetMapping("/main.do")
	public String main() {
		return "/main";
	}
	
	@GetMapping("/login.do")
	public String login() {
		return "/login";
	}
	
	@PostMapping("/login.do")
	public String login(UserVo vo, HttpSession session) {
		UserVo login = userService.login(vo);
		
		if (login == null) {
			System.out.println("RootController -> login fail");
			return "redirect:/login.do";
		}else {
			System.out.println("RootController -> login success");
			session.setAttribute("id", vo.getId());
			session.setAttribute("pw", vo.getPw());
			
			return "redirect:/myPage.do";
		}
		
	}
	
	@PostMapping("/logOut.do")
	public String logOut(HttpSession session) {
		session.invalidate();
		return "redirect:/main.do";
	}
}
