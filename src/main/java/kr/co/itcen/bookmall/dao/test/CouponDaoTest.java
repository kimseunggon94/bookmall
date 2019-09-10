package kr.co.itcen.bookmall.dao.test;

import java.util.List;

import kr.co.itcen.bookmall.dao.CouponDao;
import kr.co.itcen.bookmall.vo.CouponVo;

public class CouponDaoTest {
	public static void main(String[] args) {
		insertTest();
		readTest();
		updateTest();
	}
	
	private static void insertTest() {
		CouponDao dao = new CouponDao();
		
		CouponVo vo1 = new CouponVo();
		vo1.setName("행사1");
		dao.insert(vo1);
		
		CouponVo vo2 = new CouponVo();
		vo2.setName("행사2");
		dao.insert(vo2);
		
	}
	
	private static void readTest() {
		CouponDao dao = new CouponDao();
		List<CouponVo> list = dao.getList();
		for(CouponVo vo : list) {
			System.out.println(vo);
		}
	}
	
	private static void updateTest() {
		CouponDao dao = new CouponDao();
		dao.update((long) 1, "Test성공");
	}

	private static void deleteAllTest() {
		new CouponDao().delete();	
	}
}
