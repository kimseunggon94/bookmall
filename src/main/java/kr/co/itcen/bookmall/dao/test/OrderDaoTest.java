package kr.co.itcen.bookmall.dao.test;

import java.util.List;

import kr.co.itcen.bookmall.dao.OrderDao;
import kr.co.itcen.bookmall.vo.OrderVo;

public class OrderDaoTest {
	public static void main(String[] args) {
		insertTest();
		readTest();
		updateTest();
		deleteAllTest();
	}
	
	private static void insertTest() {
		OrderDao dao = new OrderDao();
		
		OrderVo vo1 = new OrderVo();
		vo1.setPrice((long) 13000);
		vo1.setDeli_no((long)1);
		vo1.setDeli_address("안산시");
		vo1.setUser_no((long)2);
		dao.insert(vo1);
		
	}
	
	private static void readTest() {
		OrderDao dao = new OrderDao();
		List<OrderVo> list = dao.getList();
		for(OrderVo vo : list) {
			System.out.println(vo);
		}
	}
	
	private static void updateTest() {
		OrderDao dao = new OrderDao();
		dao.update((long) 1, "Test성공");
	}

	private static void deleteAllTest() {
		new OrderDao().delete();	
	}
}