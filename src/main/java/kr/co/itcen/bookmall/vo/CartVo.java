package kr.co.itcen.bookmall.vo;

public class CartVo {
	private Long no;
	private int amount;
	private Long book_no;
	private Long user_no;
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
	public Long getUser_no() {
		return user_no;
	}
	public void setUser_no(Long user_no) {
		this.user_no = user_no;
	}
	@Override
	public String toString() {
		return "CartVo [no=" + no + ", amount=" + amount + ", cart_no=" + book_no + ", user_no=" + user_no + "]";
	}
	
	
	
}
