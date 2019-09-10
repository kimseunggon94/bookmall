package kr.co.itcen.bookmall.dao.test;

import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.dao.CartDao;
import kr.co.itcen.bookmall.vo.CartVo;

public class CartDaoTest {
	public static void main(String[] args) {
		insertTest();
		readTest();
	}
	
	private static void insertTest() {
		CartDao dao = new CartDao();
		
		CartVo vo1 = new CartVo();
		vo1.setAmount( 10);
		vo1.setBook_no((long)1);
		vo1.setUser_no((long)2);
		dao.insert(vo1);
		
		CartVo vo2 = new CartVo();
		vo2.setAmount( 20);
		vo2.setBook_no((long)2);
		vo2.setUser_no((long)1);
		dao.insert(vo2);
		
	}
	
	private static void readTest() {
		CartDao dao = new CartDao();
		ArrayList list = dao.getList();
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}
	
	private static void updateTest() {
		CartDao dao = new CartDao();
		dao.update((long) 1, 13131);
	}

	private static void deleteAllTest() {
		new CartDao().delete();	
	}
}
