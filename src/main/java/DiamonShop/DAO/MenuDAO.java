package DiamonShop.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import DiamonShop.Entity.Categorys;
import DiamonShop.Entity.MapperCategorys;
import DiamonShop.Entity.MapperMenus;
import DiamonShop.Entity.Menus;

@Repository
public class MenuDAO extends BaseDAO{

	public List<Menus> GetDataMenus()
	{
		List<Menus> lstMenus = new ArrayList<Menus>();
		String sql = "SELECT * FROM `menus`";
		lstMenus = _jdbcTemplate.query(sql, new MapperMenus());
		return lstMenus;
	}
}
