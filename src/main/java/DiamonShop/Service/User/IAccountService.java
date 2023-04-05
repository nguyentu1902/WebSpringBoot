package DiamonShop.Service.User;

import org.springframework.stereotype.Service;

import DiamonShop.Entity.Users;
import DiamonShop.controller.user.UserController;

@Service
public interface IAccountService {
	public int AddAccount(Users users);
	public Users CheckAccount(Users users);
}
