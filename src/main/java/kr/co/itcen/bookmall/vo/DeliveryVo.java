package kr.co.itcen.bookmall.vo;

public class DeliveryVo {
	private Long no;
	private String name;
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
	@Override
	public String toString() {
		return "DeliveryVo [no=" + no + ", name=" + name + "]";
	}
	
	
	
}
