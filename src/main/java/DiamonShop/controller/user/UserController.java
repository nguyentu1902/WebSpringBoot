package DiamonShop.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import DiamonShop.Entity.Users;
import DiamonShop.Service.User.AccountServiceImpl;

@Controller
public class UserController extends BaseController{
	
	@Autowired
	AccountServiceImpl accountService = new AccountServiceImpl();
	
	@RequestMapping(value = "/dang-ky", method = RequestMethod.GET)
	public ModelAndView Register()
	{
		_mvShare.setViewName("user/account/register");
		_mvShare.addObject("user", new Users());
		return _mvShare;
	}
	
	@RequestMapping(value = "/dang-ky", method = RequestMethod.POST)
	public ModelAndView CreateAcc(@ModelAttribute("user") Users users)
	{
		int count = accountService.AddAccount(users);
		if(count > 0)
		{
			_mvShare.addObject("status", "Đăng ký tài khoản thành công!");
		}
		else {
			_mvShare.addObject("status", "Đăng ký tài khoản thất bại!");
		}
		_mvShare.setViewName("user/account/register");
		return _mvShare;
	}
	
	@RequestMapping(value = "/dang-nhap", method = RequestMethod.POST)
	public ModelAndView Login(HttpSession session,@ModelAttribute("user") Users users)
	{
		users = accountService.CheckAccount(users);
		if(users != null)
		{
			_mvShare.setViewName("redirect:trang-chu");
			session.setAttribute("LoginInfo", users);
		}
		else {			
			_mvShare.addObject("statusLogin", "Đăng nhập thất bại! Vui lòng thử lại");
		}
		return _mvShare;
	}
	
	@RequestMapping(value = "/dang-xuat", method = RequestMethod.GET)
	public String Logout(HttpSession session, HttpServletRequest request)
	{
		session.removeAttribute("LoginInfo");
		return "redirect:" + request.getHeader("Referer");
	}

}
