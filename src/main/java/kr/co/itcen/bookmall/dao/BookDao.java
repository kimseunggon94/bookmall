package kr.co.itcen.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.vo.BookVo;

public class BookDao {

	private Connection getConnection() throws SQLException {
		Connection connection = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		
			String url = "jdbc:mariadb://192.168.1.118:3306/bookmall?characterEncoding=utf8";
			connection = DriverManager.getConnection(url, "bookmall", "bookmall");
		
		} catch (ClassNotFoundException e) {
			System.out.println("Fail to Loading Driver:" + e);
		}
		
		return connection;
	}
	
	public Boolean insert(BookVo vo1) {
		Boolean result = false;
		Connection connection = null;
		PreparedStatement pstmt = null;
		try {
			connection = getConnection();
			
			String sql = "insert into book values(null, ?, ?, ?, null)";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, vo1.getTitle());
			pstmt.setInt(2, vo1.getPrice());
			pstmt.setLong(3, vo1.getCategory_no());
			
			
			int count = pstmt.executeUpdate();
			result = (count == 1);
			
			
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {				
				if(pstmt != null) {
					pstmt.close();
				}
				
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	public ArrayList getList() {
		ArrayList result = new ArrayList();
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			connection = getConnection();
			
			String sql = "select book.title, category.name ,book.price from book, category where book.category_no=category.no order by book.no asc";
			pstmt = connection.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				String title = rs.getString(1);
				String name = rs.getString(2);
				int price = rs.getInt(3);
				
				
				ArrayList temp = new ArrayList();
				temp.add("책이름 : "+title);
				temp.add("카테고리 이름 : "+name);
				temp.add("가격 : "+price);
				
				result.add(temp);
			}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public boolean update(Long no, String name) {
		boolean result = false;
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		try {
			connection = getConnection();
			
			String sql = "update book set title = ? where no = ?";
			pstmt = connection.prepareStatement(sql);
			
			pstmt.setString(1, name);									
			pstmt.setLong(2, no);
			
			int count = pstmt.executeUpdate();
			
			result = (count==1);
			
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public void delete() {
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		try {
			connection = getConnection();
			
			String sql = "delete from book";
			pstmt = connection.prepareStatement(sql);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
