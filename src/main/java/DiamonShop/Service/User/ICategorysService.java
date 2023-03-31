package DiamonShop.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import DiamonShop.DAO.ProductsDAO;
import DiamonShop.DTO.ProductsDTO;


@Service
public interface ICategorysService {
	public List<ProductsDTO> GetAllProductsByID(int id);

}
