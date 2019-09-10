package kr.co.itcen.bookmall.dao.test;

import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.dao.OrderDao;
import kr.co.itcen.bookmall.vo.OrderVo;

public class OrderDaoTest {
	public static void main(String[] args) {
		insertTest();
		readTest();
	}
	
	private static void insertTest() {
		OrderDao dao = new OrderDao();
		
		OrderVo vo1 = new OrderVo();
		vo1.settotal_Price(0);
		vo1.setDeli_address("안산시");
		vo1.setUser_no((long)2);
		dao.insert(vo1);
		
	}
	
	private static void readTest() {
		OrderDao dao = new OrderDao();
		ArrayList list = dao.getList();
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}
	
	private static void updateTest() {
		OrderDao dao = new OrderDao();
		dao.update((long) 1, "부산시");
	}

	private static void deleteAllTest() {
		new OrderDao().delete();	
	}
}
