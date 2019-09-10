package kr.co.itcen.bookmall.dao.test;

import java.util.List;

import kr.co.itcen.bookmall.dao.DiscountDao;
import kr.co.itcen.bookmall.vo.DiscountVo;

public class DiscountDaoTest {
	public static void main(String[] args) {
		insertTest();
		readTest();
		updateTest();
	}
	
	private static void insertTest() {
		DiscountDao dao = new DiscountDao();
		
		DiscountVo vo1 = new DiscountVo();
		vo1.setName("베스트");
		dao.insert(vo1);
		
		DiscountVo vo2 = new DiscountVo();
		vo2.setName("신간");
		dao.insert(vo2);
		
	}
	
	private static void readTest() {
		DiscountDao dao = new DiscountDao();
		List<DiscountVo> list = dao.getList();
		for(DiscountVo vo : list) {
			System.out.println(vo);
		}
	}
	
	private static void updateTest() {
		DiscountDao dao = new DiscountDao();
		dao.update((long) 1, "Test성공");
	}

	private static void deleteAllTest() {
		new DiscountDao().delete();	
	}
}
