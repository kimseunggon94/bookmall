package kr.co.itcen.bookmall.vo;

public class DiscountVo {
	private Long no;
	private String name;
	private int rate;
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
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	@Override
	public String toString() {
		return "Discount [no=" + no + ", name=" + name + ", rate=" + rate + "]";
	}
	
}
