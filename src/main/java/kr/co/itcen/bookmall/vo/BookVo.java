package kr.co.itcen.bookmall.vo;

public class BookVo {
	private Long no;
	private String title;
	private int price;
	private Long category_no;
	private Long discount_no;
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Long getCategory_no() {
		return category_no;
	}
	public void setCategory_no(Long category_no) {
		this.category_no = category_no;
	}
	public Long getDiscount_no() {
		return discount_no;
	}
	public void setDiscount_no(Long discount_no) {
		this.discount_no = discount_no;
	}
	@Override
	public String toString() {
		return "BookVo [no=" + no + ", title=" + title + ", price=" + price + ", category_no=" + category_no
				+ ", discount_no=" + discount_no + "]";
	}
	
	
	
}
