package bhanu.prakash.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ONDC")
public class FoodOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="orderid")
	private Integer Orderid;
	private String area;
	private Integer pincode;
	private double amount;
	
	
	public Integer getOrderid() {
		return Orderid;
	}
	public void setOrderid(Integer orderid) {
		Orderid = orderid;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public Integer getPincode() {
		return pincode;
	}
	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public FoodOrder(Integer orderid, String area, Integer pincode, double amount) {
		super();
		Orderid = orderid;
		this.area = area;
		this.pincode = pincode;
		this.amount = amount;
	}
	
	public FoodOrder()
	{
		
	}
	
}
