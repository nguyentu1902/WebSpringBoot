package DiamonShop.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import DiamonShop.Entity.Categorys;
import DiamonShop.Entity.MapperCategorys;
import DiamonShop.Entity.MapperSlides;
import DiamonShop.Entity.Slides;

@Repository
public class CategorysDAO extends BaseDAO{
	
	
	public List<Categorys> GetDataCategorys()
	{
		List<Categorys> lstCategorys = new ArrayList<Categorys>();
		String sql = "SELECT * FROM `categorys`";
		lstCategorys = _jdbcTemplate.query(sql, new MapperCategorys());
		return lstCategorys;
	}

}
