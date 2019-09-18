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
			
			String sql1 = "select price from book where no = ?";
			pstmt = connection.prepareStatement(sql1);
			pstmt.setLong(1, vo1.getBook_no());
			rs = pstmt.executeQuery();
			
			int total_price =0;

			while(rs.next()){
				int price = rs.getInt(1);
				total_price = price * vo1.getAmount();
			}
			
			String sql2 = "select total_price from bookmall.order where no=?";
			pstmt = connection.prepareStatement(sql2);
			pstmt.setLong(1, vo1.getOrder_no());
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
			
			String sql = "select book.no, book.title, book.price, book_order.amount, bookmall.order.total_price "
					+ "from bookmall.order, book_order, book where book_order.book_no =book.no "
					+ "and book_order.order_no=bookmall.order.no order by book_order.no asc";
			pstmt = connection.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Long no = rs.getLong(1);
				String title =rs.getString(2);
				String price = rs.getString(3);
				int amount = rs.getInt(4);
				int total_price = rs.getInt(5);
				
				ArrayList temp = new ArrayList();
				
				temp.add("책 번호 : "+no);
				temp.add("책 제목 : "+title);
				temp.add("책 가격 : "+price);
				temp.add("수량 : " + amount);
				temp.add("총가격 : "+total_price);
				
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
		ResultSet rs = null;
		Long book_no=(long)0;
		Long order_no=(long)0;
		int pree_amount=0;
		try {
			connection = getConnection();
			
			String sql1 = "select book_no, order_no,amount from book_order where no=?";
			pstmt = connection.prepareStatement(sql1);
			pstmt.setLong(1, no);
			rs = pstmt.executeQuery();
			while(rs.next()){
				book_no = rs.getLong(1);
				order_no = rs.getLong(2);
				pree_amount = rs.getInt(3);
			}
			
			String sql = "update book_order set amount = ? where no = ?";
			pstmt = connection.prepareStatement(sql);
			
			pstmt.setInt(1, amount);									
			pstmt.setLong(2, no);
			
			int count = pstmt.executeUpdate();
			result = (count==1);
						
			String sql2 = "select price from book where no = ?";
			pstmt = connection.prepareStatement(sql2);
			pstmt.setLong(1, book_no);
			rs = pstmt.executeQuery();
			
			int total_price =0;
			
			while(rs.next()){
				int price = rs.getInt(1);
				System.out.println(price);
				total_price = price * (amount-pree_amount);
			}
			
			String sql3 = "select total_price from bookmall.order where no=?";
			pstmt = connection.prepareStatement(sql3);
			pstmt.setLong(1, order_no);
			rs = pstmt.executeQuery(); 
			
			while(rs.next()){
				int price = rs.getInt(1);
				total_price += price;
			}
			
			String sql4 = "update bookmall.order set total_price = ? where no = ?";
			
			pstmt = connection.prepareStatement(sql4);
			;
			pstmt.setInt(1, total_price);									
			pstmt.setLong(2, order_no);
			
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
	
	public void delete(Long no) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Long book_no=(long)0;
		Long order_no=(long)0;
		int pree_amount=0;
		try {
			connection = getConnection();
			
			String sql1 = "select book_no, order_no,amount from book_order where no=?";
			pstmt = connection.prepareStatement(sql1);
			pstmt.setLong(1, no);
			rs = pstmt.executeQuery();
			while(rs.next()){
				book_no = rs.getLong(1);
				order_no = rs.getLong(2);
				pree_amount = rs.getInt(3);
			}
			
			String sql = "delete from book_order where no=?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setLong(1, no);
			pstmt.executeUpdate();
			
			String sql2 = "select price from book where no = ?";
			pstmt = connection.prepareStatement(sql2);
			pstmt.setLong(1, book_no);
			rs = pstmt.executeQuery();
			
			int total_price =0;
			
			while(rs.next()){
				int price = rs.getInt(1);
				System.out.println(price);
				total_price = -price * pree_amount;
			}
			
			String sql3 = "select total_price from bookmall.order where no=?";
			pstmt = connection.prepareStatement(sql3);
			pstmt.setLong(1, order_no);
			rs = pstmt.executeQuery(); 
			
			while(rs.next()){
				int price = rs.getInt(1);
				total_price += price;
			}
			
			String sql4 = "update bookmall.order set total_price = ? where no = ?";
			
			pstmt = connection.prepareStatement(sql4);
			;
			pstmt.setInt(1, total_price);									
			pstmt.setLong(2, order_no);
			
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
