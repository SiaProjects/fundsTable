package mysql.business;

public class Fund {
	
	private String name;
	private String superName;
	
	Fund() {}
	Fund(String name, String superName) {
		this.name = name;
		this.superName = superName;
	}
	
	public void setName(String name) { this.name = name; }
	public String getName() { return this.name; }
	
	public void setSuperName(String superName) { this.superName = superName; }
	public String getSuperName() { return this.superName; }
}
