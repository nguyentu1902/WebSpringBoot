package DiamonShop.DTO;

public class CartDTO {
	private int quanty;
	private double totalPrice;
	private ProductsDTO product;
	
	public CartDTO() {
		super();
	}

	public CartDTO(int quanty, double totalPrice, ProductsDTO product) {
		super();
		this.quanty = quanty;
		this.totalPrice = totalPrice;
		this.product = product;
	}

	public int getQuanty() {
		return quanty;
	}

	public void setQuanty(int quanty) {
		this.quanty = quanty;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public ProductsDTO getProduct() {
		return product;
	}

	public void setProduct(ProductsDTO product) {
		this.product = product;
	}
	

}
