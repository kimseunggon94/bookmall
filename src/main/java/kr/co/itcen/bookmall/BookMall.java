package kr.co.itcen.bookmall;

import java.util.List;

import kr.co.itcen.bookmall.dao.BookDao;
import kr.co.itcen.bookmall.dao.Book_OrderDao;
import kr.co.itcen.bookmall.dao.CartDao;
import kr.co.itcen.bookmall.dao.CategoryDao;
import kr.co.itcen.bookmall.dao.OrderDao;
import kr.co.itcen.bookmall.dao.UserDao;
import kr.co.itcen.bookmall.vo.BookVo;
import kr.co.itcen.bookmall.vo.Book_OrderVo;
import kr.co.itcen.bookmall.vo.CartVo;
import kr.co.itcen.bookmall.vo.CategoryVo;
import kr.co.itcen.bookmall.vo.OrderVo;
import kr.co.itcen.bookmall.vo.UserVo;

public class BookMall {
	
	public static void main(String[] args) {
		CategoryDao categorydao = new CategoryDao();
		List<CategoryVo> categorylist = categorydao.getList();
		for(CategoryVo vo : categorylist) {
			System.out.println(vo);
		}
		System.out.println("-------------------------------------------------------------------------------");
		
		
		BookDao bookdao = new BookDao();
		List<BookVo> booklist = bookdao.getList();
		for(BookVo vo : booklist) {
			System.out.println(vo);
		}
		System.out.println("-------------------------------------------------------------------------------");
		
		UserDao userdao = new UserDao();
		List<UserVo> userlist = userdao.getList();
		for(UserVo vo : userlist) {
			System.out.println(vo);
		}
		System.out.println("-------------------------------------------------------------------------------");
		
		CartDao cartdao = new CartDao();
		List<CartVo> cartlist = cartdao.getList();
		for(CartVo vo : cartlist) {
			System.out.println(vo);
		}
		System.out.println("-------------------------------------------------------------------------------");
		
		OrderDao orderdao = new OrderDao();
		List<OrderVo> orderlist = orderdao.getList();
		for(OrderVo vo : orderlist) {
			System.out.println(vo);
		}
		System.out.println("-------------------------------------------------------------------------------");
		
		Book_OrderDao book_orderdao = new Book_OrderDao();
		List<Book_OrderVo> book_orderlist = book_orderdao.getList();
		for(Book_OrderVo vo : book_orderlist) {
			System.out.println(vo);
		}
		System.out.println("-------------------------------------------------------------------------------");
		
		
		
		
	}

}
