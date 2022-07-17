package mysql.business;

import java.time.LocalDate;

public class TableData {
	
	private int expenseValue;
	private LocalDate date;
	private String LLFundName;
	private String MLFundName;
	private String HLFundName;
	//private String comment;
	
	TableData() {};

	public TableData(int expenseValue, LocalDate date, String LLFundName) {
		this.expenseValue = expenseValue;
		this.date = date;
		this.LLFundName = LLFundName;
	}

	public TableData(int expenseValue, LocalDate date, String LLFundName, String MLFundName, String HLFundName) {
		this.expenseValue = expenseValue;
		this.date = date;
		this.LLFundName = LLFundName;
		this.MLFundName = MLFundName;
		this.HLFundName = HLFundName;
	}
	
	public void setExpenseValue(int expenseValue) { this.expenseValue = expenseValue; }
	public int getExpenseValue() { return this.expenseValue; }

	public void setDate(LocalDate date) { this.date = date; }
	public LocalDate getDate() { return this.date; }

	public void setLLFundName(String LLFundName) { this.LLFundName = LLFundName; }
	public String getLLFundName() { return this.LLFundName; }
	
	public void setMLFundName(String MLFundName) { this.MLFundName = MLFundName; }
	public String getMLFundName() { return this.MLFundName; }
	
	public void setHLFundName(String HLFundName) { this.HLFundName = HLFundName; }
	public String getHLFundName() { return this.HLFundName; }
	
}
