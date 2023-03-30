package DiamonShop.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import DiamonShop.Entity.MapperSlides;
import DiamonShop.Entity.Slides;

@Repository
public class SlidesDAO extends BaseDAO{
	
	public List<Slides> GetDataSlide()
	{
		List<Slides> lstSlides = new ArrayList<Slides>();
		String sql = "SELECT * FROM `slides`";
		lstSlides = _jdbcTemplate.query(sql, new MapperSlides());
		return lstSlides;
	}
	

}
