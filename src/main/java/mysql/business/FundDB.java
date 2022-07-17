package mysql.business;

import java.sql.*;
import java.util.*;
import java.time.LocalDate;

public class FundDB {
	
	private static String url = "jdbc:mysql://localhost/siarium?serverTimezone=Europe/Moscow&useSSL=false&allowPublicKeyRetrieval=true";
	private static String username = "root";
	private static String password = "tytmanyan";
	
	public static List<String> selectAllFundsList () {
		
		List<String> fundsList = new ArrayList<String>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
			
			try(Connection conn = DriverManager.getConnection(url, username, password)) {
				String sqlRequestSelect = "SELECT LowFund FROM FundsList ORDER BY MiddleFund";
				
				Statement statement = conn.createStatement();
				ResultSet resultSet = statement.executeQuery(sqlRequestSelect);
				
				while(resultSet.next()) {
					String LLFund = resultSet.getString(1);
					fundsList.add(LLFund);
				}
			}
		} catch(Exception ex) {
			System.out.println(ex);
		}
		return fundsList;
		
	}
	
	public static Map<Integer, ArrayList<TableData>> selectExpensesTable(List<String> fundsList, int monthNumber) { 

		Map<Integer, ArrayList<TableData>> expensesTable = new HashMap<Integer, ArrayList<TableData>>();
		List<TableData> expensesList = new ArrayList<TableData>();
		
		StringBuffer sqlFunds = new StringBuffer("");
		fundsList.stream().forEach(fund -> sqlFunds.append(", ").append(fund));

			try {
				Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
				
				try(Connection conn = DriverManager.getConnection(url, username, password)) {
					String sqlRequestSelect = "SELECT _date" + sqlFunds + " FROM ExpensesList WHERE MONTH(_date) = ? ORDER BY DAYOFMONTH(_date)";
					
					try (PreparedStatement preparedStatement = conn.prepareStatement(sqlRequestSelect)) {
						preparedStatement.setInt(1, monthNumber);
						ResultSet resultSet = preparedStatement.executeQuery();
						
						while(resultSet.next()) {
							LocalDate localDate = LocalDate.parse(resultSet.getString(1));
							for(int i = 2; i <= (fundsList.size() + 1); ++i) {
								TableData expenseData = new TableData(resultSet.getInt(i), localDate, fundsList.get(i - 2));
								expensesList.add(expenseData);
							}
							
							expensesTable.put(localDate.getDayOfMonth(), new ArrayList<TableData>(expensesList));
							expensesList.clear();
						}
					}
				}
			} catch(Exception ex) {
				System.out.println(ex);
			}

			return expensesTable;

	}
	
	public static int updateExpensesTable(TableData tableData) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
			
			try(Connection conn = DriverManager.getConnection(url, username, password)) {
				String sqlRequest = "UPDATE ExpensesList SET Home = ? WHERE _date = ?";
				
				try(PreparedStatement preparedStatement = conn.prepareStatement(sqlRequest)) {
					preparedStatement.setInt(1, tableData.getExpenseValue());
					preparedStatement.setString(2, tableData.getDate().toString());
					return preparedStatement.executeUpdate();
				}
			}
		} catch(Exception ex) {
			System.out.println(ex);
		}

		return 0;

	} 
	
}
