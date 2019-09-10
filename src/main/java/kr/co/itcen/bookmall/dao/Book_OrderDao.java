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
			
			int total_price =0;

			while(rs.next()){
				int price = rs.getInt(1);
				total_price = price * vo1.getAmount();
			}
			
			String sql2 = "select total_price from bookmall.order where no="+vo1.getOrder_no();
			pstmt = connection.prepareStatement(sql2);
			rs = pstmt.executeQuery(); 
			
			while(rs.next()){
				int price = rs.getInt(1);
				total_price += price;
			}
			
			String sql3 = "update bookmall.order set total_price = ? where no = ?";
			
			pstmt = connection.prepareStatement(sql3);
			
			pstmt.setInt(1, total_price);									
			pstmt.setLong(2, vo1.getOrder_no());
			
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
		
		return result;
	}

	public ArrayList getList() {
		ArrayList result = new ArrayList();
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			connection = getConnection();
			
			String sql = "select book.no, book.title, book_order.amount, bookmall.order.total_price "
					+ "from bookmall.order, book_order, book where book_order.book_no =book.no "
					+ "and book_order.order_no=bookmall.order.no order by book_order.no asc";
			pstmt = connection.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Long no = rs.getLong(1);
				String title =rs.getString(2);
				int amount = rs.getInt(3);
				int price = rs.getInt(4);
				
				ArrayList temp = new ArrayList();
				
				temp.add(no);
				temp.add(title);
				temp.add(amount);
				temp.add(price);
				
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
