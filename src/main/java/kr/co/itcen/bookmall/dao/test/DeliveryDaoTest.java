package kr.co.itcen.bookmall.dao.test;

import java.util.List;

import kr.co.itcen.bookmall.dao.DeliveryDao;
import kr.co.itcen.bookmall.vo.DeliveryVo;

public class DeliveryDaoTest {
	public static void main(String[] args) {
		insertTest();
		readTest();
		updateTest();
	}
	
	private static void insertTest() {
		DeliveryDao dao = new DeliveryDao();
		
		DeliveryVo vo1 = new DeliveryVo();
		vo1.setName("배송중");
		dao.insert(vo1);
		
		DeliveryVo vo2 = new DeliveryVo();
		vo2.setName("배송완료");
		dao.insert(vo2);
	}
	
	private static void readTest() {
		DeliveryDao dao = new DeliveryDao();
		List<DeliveryVo> list = dao.getList();
		for(DeliveryVo vo : list) {
			System.out.println(vo);
		}
	}
	
	private static void updateTest() {
		DeliveryDao dao = new DeliveryDao();
		dao.update((long) 1, "Test성공");
	}

	private static void deleteAllTest() {
		new DeliveryDao().delete();	
	}
}
