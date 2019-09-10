package kr.co.itcen.bookmall.dao.test;

import java.util.List;

import kr.co.itcen.bookmall.dao.Book_OrderDao;
import kr.co.itcen.bookmall.vo.Book_OrderVo;

public class Book_OrderDaoTest {
	public static void main(String[] args) {
		insertTest();
		readTest();
		updateTest();
	}
	
	private static void insertTest() {
		Book_OrderDao dao = new Book_OrderDao();
		
		Book_OrderVo vo1 = new Book_OrderVo();
		vo1.setAmount(10);
		vo1.setBook_no((long)3);
		vo1.setOrder_no((long)1);
		
		dao.insert(vo1);
		
	}
	
	private static void readTest() {
		Book_OrderDao dao = new Book_OrderDao();
		List<Book_OrderVo> list = dao.getList();
		for(Book_OrderVo vo : list) {
			System.out.println(vo);
		}
	}
	
	private static void updateTest() {
		Book_OrderDao dao = new Book_OrderDao();
		dao.update((long) 1, 30);
	}

	private static void deleteAllTest() {
		new Book_OrderDao().delete();	
	}
}