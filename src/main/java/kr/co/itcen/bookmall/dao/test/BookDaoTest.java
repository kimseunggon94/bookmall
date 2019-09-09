package kr.co.itcen.bookmall.dao.test;

import java.util.List;

import kr.co.itcen.bookmall.dao.BookDao;
import kr.co.itcen.bookmall.vo.BookVo;

public class BookDaoTest {
	public static void main(String[] args) {
		insertTest();
		readTest();
		updateTest();		//이름 업데이트
	}
	
	private static void insertTest() {
		BookDao dao = new BookDao();
		
		BookVo vo1 = new BookVo();
		vo1.setTitle("소설책1");
		vo1.setPrice((long)10000);
		vo1.setCategory_no((long)1);
		dao.insert(vo1);
		
		BookVo vo2 = new BookVo();
		vo2.setTitle("인문책2");
		vo2.setCategory_no((long)2);
		vo2.setPrice((long)15000);
		dao.insert(vo2);
		
		BookVo vo3 = new BookVo();
		vo3.setTitle("사회책3");
		vo3.setCategory_no((long)3);
		vo3.setPrice((long)5000);
		dao.insert(vo3);
	}
	
	private static void readTest() {
		BookDao dao = new BookDao();
		List<BookVo> list = dao.getList();
		for(BookVo vo : list) {
			System.out.println(vo);
		}
	}
	
	private static void updateTest() {
		BookDao dao = new BookDao();
		dao.update((long) 1, "Test성공");
	}

	private static void deleteAllTest() {
		new BookDao().delete();	
	}
}
