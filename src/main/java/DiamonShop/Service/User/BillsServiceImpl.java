package DiamonShop.Service.User;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamonShop.DAO.BillsDAO;
import DiamonShop.DTO.BillDetail;
import DiamonShop.DTO.Bills;
import DiamonShop.DTO.CartDTO;

@Service
public class BillsServiceImpl implements IBillsService{
	
	@Autowired
	private BillsDAO billsDAO;

	public int AddBills(Bills bills) {
		return billsDAO.AddBills(bills);
	}

	public void AddBillsDetail(HashMap<Long, CartDTO> carts) {
		long idBills = billsDAO.GetIDLastBills();
		
		for(Map.Entry<Long, CartDTO> itemCart : carts.entrySet())
		{
			BillDetail billDetail = new BillDetail();
			billDetail.setId_bills(idBills);
			billDetail.setId_product(itemCart.getValue().getProduct().getId_product());
			billDetail.setQuanty(itemCart.getValue().getQuanty());
			billDetail.setTotal(itemCart.getValue().getTotalPrice());
			billsDAO.AddBillsDetail(billDetail);
		}
		
	}

}
