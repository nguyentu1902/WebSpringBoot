package DiamonShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamonShop.DAO.CategorysDAO;
import DiamonShop.DAO.MenuDAO;
import DiamonShop.DAO.ProductsDAO;
import DiamonShop.DAO.SlidesDAO;
import DiamonShop.DTO.ProductsDTO;
import DiamonShop.Entity.Categorys;
import DiamonShop.Entity.Menus;
import DiamonShop.Entity.Slides;

@Service
public class HomeServiceImpl implements IHomeService{
	
	@Autowired
	private SlidesDAO slidesDAO;
	@Autowired
	private CategorysDAO categorysDAO;
	@Autowired
	private MenuDAO menuDAO;
	@Autowired
	private ProductsDAO productsDAO;
	
	public List<Slides> GetDataSlide()
	{
		return slidesDAO.GetDataSlide();
	}

	public List<Categorys> GetDataCategorys() 
	{
		return categorysDAO.GetDataCategorys();
	}

	public List<Menus> GetDataMenus() 
	{
		return menuDAO.GetDataMenus();
	}

	public List<ProductsDTO> GetDataHighLightProducts() {
		List<ProductsDTO> lstProductsDTO = productsDAO.GetDataHighLightProducts();
		return lstProductsDTO;
	}

	public List<ProductsDTO> GetDataNewProducts() {
		List<ProductsDTO> lstProductsDTO = productsDAO.GetDataNewProducts();
		return lstProductsDTO;
	}

}
