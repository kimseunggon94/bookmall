package kr.co.itcen.bookmall.dao.test;

import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.dao.Book_OrderDao;
import kr.co.itcen.bookmall.vo.Book_OrderVo;

public class Book_OrderDaoTest {
	public static void main(String[] args) {
		
		readTest();
		deleteTest();
	}
	
	private static void insertTest() {
		Book_OrderDao dao = new Book_OrderDao();
		
		Book_OrderVo vo1 = new Book_OrderVo();
		vo1.setAmount(15);
		vo1.setBook_no((long)3);
		vo1.setOrder_no((long)1);
		
		dao.insert(vo1);
		
	}
	
	private static void readTest() {
		Book_OrderDao dao = new Book_OrderDao();
		ArrayList list = dao.getList();
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}
	
	private static void updateTest() {
		Book_OrderDao dao = new Book_OrderDao();
		dao.update((long) 5,0);
	}

	private static void deleteTest() {
		new Book_OrderDao().delete(8L);	
	}
}
