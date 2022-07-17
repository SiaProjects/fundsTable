import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
import java.io.IOException;

//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mysql.business.FundDB;
import mysql.business.TableData;

public class EditDataTableServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			int expenseValue = Integer.parseInt(request.getParameter("value"));
			String LLFundName = request.getParameter("fund");
			int day = Integer.parseInt(request.getParameter("day"));
			
			int monthNumber = LocalDate.now().getMonthValue();
			String month = request.getParameter("month");
			if(month != null) monthNumber = Integer.parseInt(month);
			
			LocalDate date = LocalDate.of(LocalDate.now().getYear(), monthNumber, day);
			TableData tableData = new TableData(expenseValue, date, LLFundName);

			request.setAttribute("tableData", tableData);
			getServletContext().getRequestDispatcher("/editDataTable.jsp").forward(request, response);
		} catch (Exception ex) {
			System.out.println(ex);
			getServletContext().getRequestDispatcher("/error.jsp").forward(request, response); 
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			int expenseValue = Integer.parseInt(request.getParameter("new-value"));
			String LLFundName = request.getParameter("fund");
			LocalDate date = LocalDate.parse(request.getParameter("date"));
			
			TableData tableData = new TableData(expenseValue, date, LLFundName);
			FundDB.updateExpensesTable(tableData);
			response.sendRedirect(request.getContextPath() + "/expenses-table");
		} catch (Exception ex) {
			System.out.println(ex);
			getServletContext().getRequestDispatcher("/error.jsp").forward(request, response); 
		}
		
	}

}
