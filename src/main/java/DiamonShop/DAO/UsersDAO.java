package DiamonShop.DAO;

import org.springframework.stereotype.Repository;

import DiamonShop.Entity.MapperUsers;
import DiamonShop.Entity.Users;

@Repository
public class UsersDAO extends BaseDAO{

	public int AddAccount(Users users) {
		StringBuffer  sql = new StringBuffer();
		sql.append("INSERT INTO `users`(`user`, `password`, `display_name`, `address`) ");
		sql.append("VALUES ");
		sql.append("( ");
		sql.append(" ");
		sql.append(" '" + users.getUser() + "', ");
		sql.append(" '" + users.getPassword() + "', ");
		sql.append(" '" + users.getDisplay_name() + "', ");
		sql.append(" '" + users.getAddress() + "' ");
		sql.append(")");
		
		int insert = _jdbcTemplate.update(sql.toString());
		return insert;
	}
	
	public Users GetUserByAcc(Users users) {
		
		String sql = "select * from users where user = '" + users.getUser() + "'";
		Users result = _jdbcTemplate.queryForObject(sql, new MapperUsers());
		return result;
	}

}
