import java.io.IOException;
import java.util.*;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mysql.business.FundDB;
import mysql.business.TableData;


public class ExpensesTableServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			int monthNumber = LocalDate.now().getMonthValue();
			String month = request.getParameter("month");
			if(month != null) monthNumber = Integer.parseInt(month);
			
			List<String> listAllFunds = FundDB.selectAllFundsList();
			Map<Integer, ArrayList<TableData>> expensesTable = FundDB.selectExpensesTable(listAllFunds, monthNumber);
			
			request.setAttribute("expensesTable", expensesTable);
			request.setAttribute("listAllFunds", listAllFunds);
			request.setAttribute("monthNumber", monthNumber);	
			
			ServletContext servletContext = getServletContext();
		    RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/expensesTable.jsp");
		    requestDispatcher.forward(request, response);
		} catch (Exception ex) {
			System.out.println(ex);
			getServletContext().getRequestDispatcher("/error.jsp").forward(request, response); 
		}
		
	}

}
