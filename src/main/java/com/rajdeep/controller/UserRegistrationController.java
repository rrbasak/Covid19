package com.rajdeep.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.rajdeep.service.UserRegistrationService;

import com.rajdeep.vo.Admin;
import com.rajdeep.vo.User;
import com.rajdeep.vo.UserDetails;

@Controller
@RequestMapping("/welcome")
public class UserRegistrationController {
	@Autowired
	UserRegistrationService uservice;

	
	
	
	
	
	@GetMapping("/")
	public ModelAndView welcomepage() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("welcome");
		return mv;
	}

	@GetMapping("/login")
	public ModelAndView loginpage() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		return mv;
	}

	@GetMapping("/register")
	public ModelAndView registerpage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("register");
		return mv;
	}

	@PostMapping("/afterlogin")
	public ModelAndView afterloginpage(HttpSession session, @RequestParam("userid") String userid,
			@RequestParam("password") String password) {
		User u = new User();
		u.setUserid(userid);
		u.setPassword(password);
		System.out.println(userid);
		ModelAndView mv = new ModelAndView();
		int ck = uservice.checker(u);
		System.out.println(ck);
		if (ck == 1) {
			session.setAttribute("logAsUser", u.getUserid());
			List<UserDetails> list = uservice.getAllUser();
			mv.addObject("usersview", list);
			mv.setViewName("home");
		} else if (ck == 2) {
			mv.setViewName("register");
		}

		return mv;
	}

	@PostMapping("/home")
	public ModelAndView afterregistrationpage(HttpSession session, @RequestParam("userid") String userid,
			@RequestParam("email") String email, @RequestParam("password") String password) {
		User u = new User();
		u.setUserid(userid);
		u.setEmail(email);
		u.setPassword(password);
		uservice.insertdatauser(u);
		session.setAttribute("logAsUser", u.getUserid());
		List<UserDetails> list = uservice.getAllUser();
		ModelAndView mv = new ModelAndView();
		mv.addObject("usersview", list);
		mv.setViewName("home");
		return mv;
	}

	@GetMapping("/home")
	public ModelAndView afteruserdetails(HttpSession session) {
		List<UserDetails> list = uservice.getAllUser();
		ModelAndView mv = new ModelAndView();
		if (session.getAttribute("logAsUser") != null) {
			mv.addObject("usersview", list);
			mv.setViewName("home");
			return mv;
		} else {
			return new ModelAndView(new RedirectView("/welcome/login", true));
		}

	}

	@GetMapping("/form")
	public ModelAndView userinfoForm() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("userinfo");
		return mv;
	}

	@PostMapping("/userdetailsvies")
	public String listingpage(@RequestParam("name") String name, @RequestParam("age") String age,
			@RequestParam("gender") String gender, @RequestParam("addharno") String addharno,
			@RequestParam("vacdate") String vacdate, @RequestParam("state") String state) {
		UserDetails userd = new UserDetails();
		userd.setName(name);
		userd.setAge(age);
		userd.setGender(gender);
		userd.setAddharno(addharno);
		userd.setState(state);
		userd.setVacdate(vacdate);
		uservice.insertdatauserDetails(userd);

		return "redirect:/welcome/home";
	}

	@GetMapping("/delete/{addharno}")
	public String deleteUserss(@PathVariable String addharno) {
		uservice.deleteUser(addharno);
		return "redirect:/welcome/home";

	}

	@GetMapping("/edit/{addharno}")
	public ModelAndView editUserss(@PathVariable String addharno) {

		ModelAndView mv = new ModelAndView();
		UserDetails userd = uservice.findUserId(addharno);
		mv.setViewName("edit");
		System.out.println("Rajuu" + userd);
		mv.addObject("userdetails", userd);
		return mv;

	}

	@PostMapping("/submitedit")
	public String updateUserss(@RequestParam("vacdate") String vacdate, @RequestParam("addharno12") String addharno12) {
		UserDetails ud = new UserDetails();
		System.out.println("here1");
		ud.setVacdate(vacdate);
		ud.setAddharno(addharno12);
		System.out.println("Here3" + ud);
		uservice.setVacDate(ud);
		System.out.println("here2");
		return "redirect:/welcome/home";

	}

	@GetMapping("/logout")
	public String logoutuser(HttpServletRequest request) {
		HttpSession httpSession = request.getSession();
		httpSession.invalidate();

		return "redirect:/welcome/";
	}

	@GetMapping("/adminlogout")
	public String logoutadmin(HttpServletRequest request) {
		HttpSession httpSession = request.getSession();
		httpSession.invalidate();

		return "redirect:/welcome/";
	}

	@PostMapping("/search")
	public ModelAndView searchpage(@RequestParam("searchaddharno") String addharno) {

		ModelAndView mv = new ModelAndView();
		UserDetails userd = uservice.findUserId(addharno);
		mv.setViewName("searchpage");
		mv.addObject("userdetails", userd);
		return mv;

	}

	@GetMapping("/admin")
	public ModelAndView adminpage() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("adminlogin");
		return mv;

	}

	@PostMapping("/afteradminlogin")
	public ModelAndView afteradminpage(HttpSession session, @RequestParam("id") String id,
			@RequestParam("password") String password) {
		Admin a = new Admin();
		a.setId(id);
		a.setPassword(password);
		ModelAndView mv = new ModelAndView();
		int ck = uservice.checker2(a);
		System.out.println(ck);
		if (ck == 1) {
			session.setAttribute("logAsAdmin", a.getId());
			mv.setViewName("adminview");
		} else if (ck == 2) {
			return new ModelAndView(new RedirectView("/welcome/admin", true));
		}

		return mv;
	}

	@GetMapping("/users")
	public ModelAndView userspageforAdmin() {
		System.out.println("ADMIN");
		ModelAndView mv = new ModelAndView();
		List<Object[]> list = uservice.getAllUserforadmin();
		System.out.println(list);
		mv.addObject("usersviewforadmin", list);
		mv.setViewName("users");
		return mv;

	}

	@GetMapping("/usersdetails")
	public ModelAndView usersdetailspageforAdmin() {
		List<UserDetails> list = uservice.getAllUser();
		ModelAndView mv = new ModelAndView();

		mv.addObject("usersview", list);
		mv.setViewName("userdetailsforadmin");
		return mv;

	}
	@PostMapping("/searchforadminuser")
	public ModelAndView searchadminforusers(@RequestParam("searchuserid") String userid) {

		ModelAndView mv = new ModelAndView();
		List<Object[]> list= uservice.findUserIdforadmin(userid);
		mv.setViewName("searchpageforadminforuser");
		mv.addObject("userdetails", list);
		list.stream().map(o->o[0]).forEach(System.out::println);
		return mv;

	}
	@PostMapping("/searchforadminuserdetails")
	public ModelAndView searchpageforadminforuserdetails(@RequestParam("searchaddharno") String addharno) {

		ModelAndView mv = new ModelAndView();
		UserDetails userd = uservice.findUserId(addharno);
		mv.setViewName("searchpageforadminUserdetails");
		mv.addObject("userdetails", userd);
		return mv;

	}

	
	
}
