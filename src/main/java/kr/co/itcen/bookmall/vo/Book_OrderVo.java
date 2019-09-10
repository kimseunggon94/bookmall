package kr.co.itcen.bookmall.vo;

public class Book_OrderVo {
	private Long no;
	private int amount;
	private Long book_no;
	private Long order_no;
	private Long coupon_no;
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Long getBook_no() {
		return book_no;
	}
	public void setBook_no(Long book_no) {
		this.book_no = book_no;
	}
	public Long getOrder_no() {
		return order_no;
	}
	public void setOrder_no(Long order_no) {
		this.order_no = order_no;
	}
	public Long getCoupon_no() {
		return coupon_no;
	}
	public void setCoupon_no(Long coupon_no) {
		this.coupon_no = coupon_no;
	}
	@Override
	public String toString() {
		return "Book_OrderVO [no=" + no + ", amount=" + amount + ", book_no=" + book_no + ", order_no=" + order_no
				+ ", coupon_no=" + coupon_no + "]";
	}
}
