package DiamonShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamonShop.DAO.ProductsDAO;
import DiamonShop.DTO.ProductsDTO;

@Service
public class CategoryServiceImpl implements ICategorysService{

	@Autowired
	private ProductsDAO productsDao;
	
	public List<ProductsDTO> GetAllProductsByID(int id) {
		return productsDao.GetAllProductsByID(id);
	}
	
	public List<ProductsDTO> GetDataProductsPaginate(int id, int start, int totalPage)
	{
		return productsDao.GetDataProductsPaginate(id, start, totalPage);
	}

}
