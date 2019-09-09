package kr.co.itcen.bookmall.vo;

public class OrderVo {
	private Long no;
	private Long total_price;
	private String deli_address;
	private Long user_no;
	private Long deli_no;
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public Long gettotal_Price() {
		return total_price;
	}
	public void settotal_Price(Long total_price) {
		this.total_price = total_price;
	}
	public String getDeli_address() {
		return deli_address;
	}
	public void setDeli_address(String deli_address) {
		this.deli_address = deli_address;
	}
	public Long getUser_no() {
		return user_no;
	}
	public void setUser_no(Long user_no) {
		this.user_no = user_no;
	}
	public Long getDeli_no() {
		return deli_no;
	}
	public void setDeli_no(Long deli_no) {
		this.deli_no = deli_no;
	}
	@Override
	public String toString() {
		return "OrderVo [no=" + no + ", price=" + total_price + ", deli_address=" + deli_address + ", user_no=" + user_no
				+ ", deli_no=" + deli_no + "]";
	}
	
}
