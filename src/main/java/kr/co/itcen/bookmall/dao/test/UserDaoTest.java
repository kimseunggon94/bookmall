package kr.co.itcen.bookmall.dao.test;

import java.util.List;

import kr.co.itcen.bookmall.dao.UserDao;
import kr.co.itcen.bookmall.vo.UserVo;

public class UserDaoTest {
	public static void main(String[] args) {
		insertTest();
		readTest();
		updateTest();
	}
	
	private static void insertTest() {
		UserDao dao = new UserDao();
		
		UserVo vo1 = new UserVo();
		vo1.setName("김승곤");
		vo1.setPhone("010-1111-1111");
		vo1.setEmail("fullc");
		vo1.setPassword("1111");
		vo1.setAddress("안산");
		dao.insert(vo1);
		
		UserVo vo2 = new UserVo();
		vo2.setName("김민준");
		vo2.setPhone("010-2222-2222");
		vo2.setEmail("Kim");
		vo2.setPassword("2222");
		vo2.setAddress("서울");
		dao.insert(vo2);
	}
	
	private static void readTest() {
		UserDao dao = new UserDao();
		List<UserVo> list = dao.getList();
		for(UserVo vo : list) {
			System.out.println(vo);
		}
	}
	
	private static void updateTest() {
		UserDao dao = new UserDao();
		dao.update((long) 1, "Test성공");
	}

	private static void deleteAllTest() {
		new UserDao().delete();	
	}
}
