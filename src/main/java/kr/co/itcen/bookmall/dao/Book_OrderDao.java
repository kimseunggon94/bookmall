package kr.co.itcen.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.vo.BookVo;
import kr.co.itcen.bookmall.vo.Book_OrderVo;

public class Book_OrderDao {
	

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
	
	public Boolean insert(Book_OrderVo vo1) {
		Boolean result = false;
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			connection = getConnection();
			
			String sql = "insert into book_order values(null, ?, ?, ?, null)";
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, vo1.getAmount());
			pstmt.setLong(2, vo1.getBook_no());
			pstmt.setLong(3, vo1.getOrder_no());
			
			
			int count = pstmt.executeUpdate();
			result = (count == 1);
			
			String sql1 = "select price from book where no = "+vo1.getBook_no();

			pstmt = connection.prepareStatement(sql1);

			rs = pstmt.executeQuery();
		
			while(rs.next()){
				int price = rs.getInt(1);
				int total_price = price * vo1.getAmount();
			}
			
			
			String sql2 = "update order set amount = ? where no = ?";
			pstmt = connection.prepareStatement(sql2);
			
			pstmt.setInt(1, amount);									
			pstmt.setLong(2, no);
			
			int count = pstmt.executeUpdate();
			
			
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

	public List<Book_OrderVo> getList() {
		List<Book_OrderVo> result = new ArrayList<Book_OrderVo>();
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			connection = getConnection();
			
			String sql = "select * from book_order order by no asc";
			pstmt = connection.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Long no = rs.getLong(1);
				int amount = rs.getInt(2);
				Long book_no = rs.getLong(3);
				Long order_no = rs.getLong(4);
				
				Book_OrderVo vo= new Book_OrderVo();
				vo.setNo(no);
				vo.setAmount(amount);
				vo.setBook_no(book_no);
				vo.setOrder_no(order_no);
				
				result.add(vo);
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
	
	public boolean update(Long no, int amount) {
		boolean result = false;
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		try {
			connection = getConnection();
			
			String sql = "update book_order set amount = ? where no = ?";
			pstmt = connection.prepareStatement(sql);
			
			pstmt.setInt(1, amount);									
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
			
			String sql = "delete from book_order";
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
