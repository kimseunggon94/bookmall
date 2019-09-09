package kr.co.itcen.bookmall.dao.test;

import java.util.List;

import kr.co.itcen.bookmall.dao.CartDao;
import kr.co.itcen.bookmall.vo.CartVo;

public class CartDaoTest {
	public static void main(String[] args) {
		insertTest();
		readTest();
		updateTest();
	}
	
	private static void insertTest() {
		CartDao dao = new CartDao();
		
		CartVo vo1 = new CartVo();
		vo1.setAmount((long) 10);
		vo1.setBook_no((long)1);
		vo1.setUser_no((long)2);
		dao.insert(vo1);
		
		CartVo vo2 = new CartVo();
		vo2.setAmount((long) 20);
		vo2.setBook_no((long)2);
		vo2.setUser_no((long)1);
		dao.insert(vo2);
		
	}
	
	private static void readTest() {
		CartDao dao = new CartDao();
		List<CartVo> list = dao.getList();
		for(CartVo vo : list) {
			System.out.println(vo);
		}
	}
	
	private static void updateTest() {
		CartDao dao = new CartDao();
		dao.update((long) 1, (long)13131);
	}

	private static void deleteAllTest() {
		new CartDao().delete();	
	}
}