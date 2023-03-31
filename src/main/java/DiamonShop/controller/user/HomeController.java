package DiamonShop.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController extends BaseController{
	
	@RequestMapping(value = {"/", "/trang-chu"}, method = RequestMethod.GET)
	public ModelAndView Index()
	{
		//ModelAndView mv = new ModelAndView("user/index");
		
		_mvShare.addObject("slides", _homeService.GetDataSlide());
		_mvShare.addObject("categorys", _homeService.GetDataCategorys());
		_mvShare.addObject("highlight_products", _homeService.GetDataHighLightProducts());
		_mvShare.addObject("new_products", _homeService.GetDataNewProducts());
		
		_mvShare.setViewName("user/index");
		return _mvShare;
	}

}


//ngocthao
