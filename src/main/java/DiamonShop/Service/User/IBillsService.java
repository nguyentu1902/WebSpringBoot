package DiamonShop.Service.User;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import DiamonShop.DTO.Bills;
import DiamonShop.DTO.CartDTO;

@Service
public interface IBillsService {
	
	public int AddBills(Bills bills);
	public void AddBillsDetail(HashMap<Long, CartDTO> carts);

}
