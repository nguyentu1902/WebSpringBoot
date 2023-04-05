package DiamonShop.Service.User;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamonShop.DAO.UsersDAO;
import DiamonShop.Entity.Users;

@Service
public class AccountServiceImpl implements IAccountService{

	@Autowired
	UsersDAO usersDAO = new UsersDAO();
	
	public int AddAccount(Users users) {
		//users.setPassword(BCrypt.hashpw(users.getPassword(), BCrypt.gensalt(12)));
		return usersDAO.AddAccount(users);
	}

	public Users CheckAccount(Users users) {
		String pass = users.getPassword();
		users = usersDAO.GetUserByAcc(users);
		if(users != null)
		{
			if(pass.equals(users.getPassword()))
			{
				return users;
			}
			else {
				return null;
			}
		}
		return null;
	}

}
