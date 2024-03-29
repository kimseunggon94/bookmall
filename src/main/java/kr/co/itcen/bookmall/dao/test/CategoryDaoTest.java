package kr.co.itcen.bookmall.dao.test;

import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.dao.CategoryDao;
import kr.co.itcen.bookmall.vo.CategoryVo;

public class CategoryDaoTest {
	public static void main(String[] args) {
		insertTest();
		readTest();
	}
	
	private static void insertTest() {
		CategoryDao dao = new CategoryDao();
		
		CategoryVo vo1 = new CategoryVo();
		vo1.setName("소설");
		dao.insert(vo1);
		
		CategoryVo vo2 = new CategoryVo();
		vo2.setName("인문");
		dao.insert(vo2);
		
		CategoryVo vo3 = new CategoryVo();
		vo3.setName("사회");
		dao.insert(vo3);
	}
	
	private static void readTest() {
		
		CategoryDao dao = new CategoryDao();
		ArrayList list = dao.getList();
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}
	
	private static void updateTest() {
		CategoryDao dao = new CategoryDao();
		dao.update((long) 1, "Test성공");
	}

	private static void deleteAllTest() {
		new CategoryDao().delete();	
	}
}
