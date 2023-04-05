package DiamonShop.DAO;

import org.springframework.stereotype.Repository;

import DiamonShop.DTO.BillDetail;
import DiamonShop.DTO.Bills;

@Repository
public class BillsDAO extends BaseDAO{
	
	public int AddBills(Bills bills)
	{
		StringBuffer sql = new StringBuffer();
		sql.append("insert into bills ");
		sql.append("( ");
		sql.append(" `user`, `phone`, `display_name`, `address`, `total`, `quanty`, `note`  ");
		sql.append(") ");
		sql.append("values ");
		sql.append("( ");
		sql.append("  '" + bills.getUser() + "', ");
		sql.append("  '" + bills.getPhone() + "', ");
		sql.append("  '" + bills.getDisplay_name() + "', ");
		sql.append("  '" + bills.getAddress() + "', ");
		sql.append("  '" + bills.getTotal() + "', ");
		sql.append("  '" + bills.getQuanty() + "', ");
		sql.append("  '" + bills.getNote() + "'  ");
		sql.append(");");
		
		int insert = _jdbcTemplate.update(sql.toString());
		return insert;
	}
	
	public long GetIDLastBills()
	{
		StringBuffer sql = new StringBuffer();
		sql.append("select MAX(id) from bills");
		long id = _jdbcTemplate.queryForObject(sql.toString(), new Object[] {}, Long.class);
		return id;
	}
	
	public int AddBillsDetail(BillDetail billDetail)
	{
		StringBuffer sql = new StringBuffer();
		sql.append("insert into billdetail ");
		sql.append("( ");
		sql.append("  id_product, ");
		sql.append("  id_bills, ");
		sql.append("  quanty,  ");
		sql.append(" total ");
		sql.append(") ");
		sql.append("values ");
		sql.append("( ");
		sql.append(" " + billDetail.getId_product() + ", ");
		sql.append(" " + billDetail.getId_bills() + ", ");
		sql.append(" " + billDetail.getQuanty() + ", ");
		sql.append(" " + billDetail.getTotal() + " ");
		sql.append(")");
		
		int insert = _jdbcTemplate.update(sql.toString());
		return insert;
	}

}
