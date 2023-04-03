package DiamonShop.DAO;

import java.lang.invoke.ConstantCallSite;
import java.util.ArrayList;
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
	
	private StringBuffer SqlProductsByID(int id) {
		StringBuffer sql = SqlString();
		sql.append("WHERE 1 = 1 ");
		sql.append("AND id_category = " + id + " ");
		return sql;
	}
	
	private String SqlProductsPaginate(int id, int start, int totalPage) {
		StringBuffer sql = SqlString();
		sql.append("LIMIT " + start + ", "+ totalPage);
		return sql.toString();
	}
	
	public List<ProductsDTO> GetAllProductsByID(int id) {
		String sql = SqlProductsByID(id).toString();
		List<ProductsDTO> listProducts = _jdbcTemplate.query(sql, new ProductsDTOMapper());
		return listProducts;
	}
	
	public List<ProductsDTO> GetDataProductsPaginate(int id, int start, int totalPage) {
		StringBuffer sqlGetDataByID = SqlProductsByID(id);
		List<ProductsDTO> listProductsByID = _jdbcTemplate.query(sqlGetDataByID.toString(), new ProductsDTOMapper());
		List<ProductsDTO> listProducts = new ArrayList<ProductsDTO>();
		if(listProductsByID.size() > 0) {
			String sql = SqlProductsPaginate(id, start, totalPage);
			listProducts = _jdbcTemplate.query(sql, new ProductsDTOMapper());
		}
		return listProducts;
	}

	private String SqlProductByID(long id) {
		StringBuffer sql = SqlString();
		sql.append("WHERE 1 = 1 ");
		sql.append("AND p.id = " + id + " ");
		sql.append("LIMIT 1 ");
		return sql.toString();
	}
	
	public List<ProductsDTO> GetProductByID(long id) {
		String sql = SqlProductByID(id);
		List<ProductsDTO> listProduct = _jdbcTemplate.query(sql, new ProductsDTOMapper());
		return listProduct;
	}
	
	//cart
	public ProductsDTO FindProductByID(long id) {
		String sql = SqlProductByID(id);
		ProductsDTO product = _jdbcTemplate.queryForObject(sql, new ProductsDTOMapper());
		return product;
	}
	
}
