package DiamonShop.DAO;

import java.lang.invoke.ConstantCallSite;
import java.util.List;

import org.springframework.stereotype.Repository;

import DiamonShop.DTO.ProductsDTO;
import DiamonShop.DTO.ProductsDTOMapper;

@Repository
public class ProductsDAO extends BaseDAO{
	
	private final boolean YES = true; 
	private final boolean NO = false;
	
	private StringBuffer SqlString()
	{
		StringBuffer sql = new StringBuffer();
		sql.append("select p.id as id_product, p.id_category, p.sizes, p.name, p.price, p.sale, p.title, p.highlight, ");
		sql.append("p.new_product, p.details, c.id as id_color, c.name as name_color, c.code as code_color, c.img, ");
		sql.append("p.created_at, p.updated_at from products as p inner join colors as c on p.id = c.id_product ");
		
		return sql;
	}
	
	private String SqlProducts(boolean newProduct, boolean highLight)
	{
		StringBuffer sql = SqlString();
		
		if(highLight)
		{
			sql.append("where p.highlight = true ");
		}
		
		if(newProduct)
		{
			sql.append("and p.new_product = true ");
		}
		sql.append("group by p.id, c.id_product ");
		sql.append("order by RAND() ");
		
		if(highLight)
		{
			sql.append("LIMIT 9 ");
		}
		
		if(newProduct)
		{
			sql.append("LIMIT 12 ");
		}

		return sql.toString();
	}

	//lay ds san pham noi bat
	public List<ProductsDTO> GetDataHighLightProducts()
	{
		String sql = SqlProducts(NO, YES);
		
		List<ProductsDTO> lstProductsDTO = _jdbcTemplate.query(sql, new ProductsDTOMapper());
		return lstProductsDTO;
	}
	
	//lay ds san pham moi
	public List<ProductsDTO> GetDataNewProducts()
	{
		String sql = SqlProducts(YES, NO);
		
		List<ProductsDTO> lstProductsDTO = _jdbcTemplate.query(sql, new ProductsDTOMapper());
		return lstProductsDTO;
	}
	
}
