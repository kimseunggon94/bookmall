package kr.co.itcen.bookmall;

import java.util.ArrayList;

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

		CategoryDao dao1 = new CategoryDao();
		
		CategoryVo vo_11 = new CategoryVo();
		vo_11.setName("소설");
		dao1.insert(vo_11);
		
		CategoryVo vo_12 = new CategoryVo();
		vo_12.setName("인문");
		dao1.insert(vo_12);
		
		CategoryVo vo_13 = new CategoryVo();
		vo_13.setName("사회");
		dao1.insert(vo_13);
		
		ArrayList list1 = dao1.getList();
		for(int i=0;i<list1.size();i++) {
			System.out.println(list1.get(i));
		}
		System.out.println("-------------------------------------------------------------------------------");

		BookDao dao2 = new BookDao();
		
		BookVo vo_21 = new BookVo();
		vo_21.setTitle("소설책1");
		vo_21.setPrice(10000);
		vo_21.setCategory_no((long)1);
		dao2.insert(vo_21);
		
		BookVo vo_22 = new BookVo();
		vo_22.setTitle("인문책2");
		vo_22.setCategory_no((long)2);
		vo_22.setPrice(15000);
		dao2.insert(vo_22);
		
		BookVo vo_23 = new BookVo();
		vo_23.setTitle("사회책3");
		vo_23.setCategory_no((long)3);
		vo_23.setPrice(5000);
		dao2.insert(vo_23);
		
		ArrayList list2 = dao2.getList();
		for(int i=0;i<list2.size();i++) {
			System.out.println(list2.get(i));
		}
		System.out.println("-------------------------------------------------------------------------------");
		
		UserDao dao3 = new UserDao();

		UserVo vo_31 = new UserVo();
		vo_31.setName("김승곤");
		vo_31.setPhone("010-1111-1111");
		vo_31.setEmail("fullc");
		vo_31.setPassword("1111");
		vo_31.setAddress("안산");
		dao3.insert(vo_31);

		UserVo vo_32 = new UserVo();
		vo_32.setName("김민준");
		vo_32.setPhone("010-2222-2222");
		vo_32.setEmail("Kim");
		vo_32.setPassword("2222");
		vo_32.setAddress("서울");
		dao3.insert(vo_32);

		ArrayList list3 = dao3.getList();
		for(int i=0;i<list3.size();i++) {
			System.out.println(list3.get(i));
		}

		System.out.println("-------------------------------------------------------------------------------");
		CartDao dao4 = new CartDao();
		
		CartVo vo_41 = new CartVo();
		vo_41.setAmount( 10);
		vo_41.setBook_no((long)1);
		vo_41.setUser_no((long)2);
		dao4.insert(vo_41);
		
		CartVo vo_42 = new CartVo();
		vo_42.setAmount( 20);
		vo_42.setBook_no((long)2);
		vo_42.setUser_no((long)1);
		dao4.insert(vo_42);
		
		ArrayList list4 = dao4.getList();
		for(int i=0;i<list4.size();i++) {
			System.out.println(list4.get(i));
		}

		System.out.println("-------------------------------------------------------------------------------");
		OrderDao dao5 = new OrderDao();
		
		OrderVo vo_51 = new OrderVo();
		vo_51.settotal_Price(0);
		vo_51.setDeli_address("안산시");
		vo_51.setUser_no((long)2);
		dao5.insert(vo_51);
		
		
		ArrayList list5 = dao5.getList();
		for(int i=0;i<list5.size();i++) {
			System.out.println(list5.get(i));
		}

		System.out.println("-------------------------------------------------------------------------------");
		Book_OrderDao dao6 = new Book_OrderDao();
		
		Book_OrderVo vo_61 = new Book_OrderVo();
		vo_61.setAmount(15);
		vo_61.setBook_no((long)3);
		vo_61.setOrder_no((long)1);
		
		dao6.insert(vo_61);
		
		ArrayList list6 = dao6.getList();
		for(int i=0;i<list6.size();i++) {
			System.out.println(list6.get(i));
		}
		list5 = dao5.getList();
		for(int i=0;i<list5.size();i++) {
			System.out.println(list5.get(i));
		}
		System.out.println("-------------------------------------------------------------------------------");

	}

}
