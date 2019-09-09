package kr.co.itcen.bookmall.vo;

public class CouponVo {
	private Long no;
	private String name;
	private Long price;
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "CouponVo [no=" + no + ", name=" + name + ", price=" + price + "]";
	}
	
	
}
