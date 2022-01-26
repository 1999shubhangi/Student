import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class StudentsDetails {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		 Connection conn = null;

		    String url = "jdbc:mysql://localhost:3306/student_db";
		    String username = "root";
		    String password = "mysql";

		    try {
		      Class.forName("com.mysql.jdbc.Driver");
		      conn = DriverManager.getConnection(url, username, password);

		      System.out.println("Connected!");
		      
		      Scanner sc = new Scanner(System.in); 
		      int  n=0;
		   
			do {
				
				System.out.println("Please enter number to execute opertaion:");
				System.out.println("1.INSERT");
				System.out.println("2.UPDATE");
				System.out.println("3.DELETE");
				System.out.println("4.List of Students");
				System.out.println("5.Filter through Student ID");
				
				n = sc.nextInt();

		     switch(n) {
		     			case 1:
		     
		     				 String sql1 ="INSERT INTO student(STUDENT_NO,STUDENT_NAME,STUDENT_DOB,STUDENT_DOJ) VALUES (?, ?, ?, ?)";
		     				  PreparedStatement statement1 = conn.prepareStatement(sql1);
		     				  statement1.setString(1, "5"); 
		     				  statement1.setString(2, "Apple");
		     				  statement1.setString(3, "1997/4/2"); 
		     				  statement1.setString(4, "2018/5/3");
		     				 
		     				  int rowsInserted = statement1.executeUpdate(); 
		     				  if (rowsInserted > 0) {
		     					  System.out.println("A new user was inserted successfully!");
		     					  }
		     			   break;
		     			 case 2: //UPDATE
		     				
		     				String sql2 = "UPDATE  STUDENT SET STUDENT_NAME=?, STUDENT_DOB=?, STUDENT_DOJ=? WHERE STUDENT_NO=?";
		     				 
		     				PreparedStatement statement2 = conn.prepareStatement(sql2);
		     				statement2.setString(1, "REEMA");
		     				statement2.setString(2, "1999/1/6");
		     				statement2.setString(3, "2020/3/15");
		     				statement2.setString(4, "4");
		     				 
		     				int rowsUpdated1 = statement2.executeUpdate();
		     				if (rowsUpdated1 > 0) {
		     				    System.out.println("An existing user was updated successfully!");
		     				}
		     				break;
		     			case 3:	//DELETE
		     				
		     				String sql3 = "DELETE FROM STUDENT WHERE STUDENT_NO=?";
		     				 
		     				PreparedStatement statement3 = conn.prepareStatement(sql3);
		     				statement3.setString(1, "5");
		     				 
		     				int rowsDeleted1 = statement3.executeUpdate();
		     				if (rowsDeleted1 > 0) {
		     				    System.out.println("A user was deleted successfully!");
		     				}
		     				break;
		     			case 4: 
		     				String sql4 = "SELECT * FROM student";
		     				Statement statement4 = conn.createStatement();
		     				ResultSet result4 = statement4.executeQuery(sql4);
		     
		     				
		     
		     				while (result4.next()){
		     					String Student_No = result4.getString(1);
		     					String Student_Name = result4.getString(2);
		     					String Student_DOB = result4.getString(3);
		     					String Student_DOJ = result4.getString(4);
		     
		     					String output = " %s   %s   %s   %s";
		     					System.out.println(String.format(output, Student_No, Student_Name, Student_DOB, Student_DOJ)); 
		    
		     					}
		     				break;
		     			case 5://FILTER THROUGH ID
		     				
		     				String sql5 = "SELECT* FROM STUDENT WHERE STUDENT_NO='5'";
		     				Statement statement5 = conn.createStatement();
		     				ResultSet result5 = statement5.executeQuery(sql5);
		     
		     				
		     
		     				while (result5.next()){
		     					String Student_No = result5.getString(1);
		     					String Student_Name = result5.getString(2);
		     					String Student_DOB = result5.getString(3);
		     					String Student_DOJ = result5.getString(4);
		     
		     					String output = " %s   %s   %s   %s";
		     					System.out.println(String.format(output, Student_No, Student_Name, Student_DOB, Student_DOJ)); 
		    
		     					}
		     				break;
			
			}
			 
		     }while(n==6); 
		    
		    } catch (SQLException ex) {
		        throw new Error("Error ", ex);
		    } finally {
		      try {
		        if (conn != null) {
		            conn.close();
		            System.out.println("Connection Close");
		        }
		      } catch (SQLException ex) {
		          System.out.println(ex.getMessage());
		      }
		    }
	}

	private static void While() {
		// TODO Auto-generated method stub
		
	}

}

