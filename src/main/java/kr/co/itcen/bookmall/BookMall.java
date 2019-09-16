package kr.co.itcen.bookmall;

import java.util.ArrayList;

import kr.co.itcen.bookmall.dao.BookDao;
import kr.co.itcen.bookmall.dao.Book_OrderDao;
import kr.co.itcen.bookmall.dao.CartDao;
import kr.co.itcen.bookmall.dao.CategoryDao;
import kr.co.itcen.bookmall.dao.OrderDao;
import kr.co.itcen.bookmall.dao.UserDao;

public class BookMall {
	
	public static void main(String[] args) {

		CategoryDao dao1 = new CategoryDao();
		ArrayList list1 = dao1.getList();
		for(int i=0;i<list1.size();i++) {
			System.out.println(list1.get(i));
		}
		System.out.println("-------------------------------------------------------------------------------");
		
		BookDao dao2 = new BookDao();
		ArrayList list2 = dao2.getList();
		for(int i=0;i<list2.size();i++) {
			System.out.println(list2.get(i));
		}
		System.out.println("-------------------------------------------------------------------------------");
		
		UserDao dao3 = new UserDao();
		ArrayList list3 = dao3.getList();
		for(int i=0;i<list3.size();i++) {
			System.out.println(list3.get(i));
		}
		
		System.out.println("-------------------------------------------------------------------------------");
		CartDao dao4 = new CartDao();
		ArrayList list4 = dao4.getList();
		for(int i=0;i<list4.size();i++) {
			System.out.println(list4.get(i));
		}
		
		System.out.println("-------------------------------------------------------------------------------");
		OrderDao dao5 = new OrderDao();
		ArrayList list5 = dao5.getList();
		for(int i=0;i<list5.size();i++) {
			System.out.println(list5.get(i));
		}
		
		System.out.println("-------------------------------------------------------------------------------");
		Book_OrderDao dao6 = new Book_OrderDao();
		ArrayList list6 = dao6.getList();
		for(int i=0;i<list6.size();i++) {
			System.out.println(list6.get(i));
		}
		
		System.out.println("-------------------------------------------------------------------------------");
		
	}

}
