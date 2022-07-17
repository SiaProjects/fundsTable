import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SQLServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
		try {
			String url = "jdbc:mysql://localhost/siarium?serverTimezone=Europe/Moscow&useSSL=false&allowPublicKeyRetrieval=true";
			String username = "root";
			String password = "tytmanyan";
			Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
			
			try (Connection con = DriverManager.getConnection(url, username, password)) {
				writer.printf("Connection to siarium succesfull!!!");
			}
			
		} catch (Exception ex) {
			writer.printf("Connection failed.../n/n");
			writer.println(ex);
		} finally {
			writer.close();
		}
		
	}

}
