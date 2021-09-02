package data;

import Utilities.Xls_Reader;

public class DataFile {
	Xls_Reader r = new Xls_Reader("data\\data_login_page.xlsx");
	
	//login
	public String wrongEmail =r.getCellData("data", "Email", 2);
	public String wrongPassword =r.getCellData("data", "Password", 2);
	public String emailWithSpecialChar = r.getCellData("data", "Email", 3);
	public String emailWithSpecialCharErr = r.getCellData("data", "Error", 3);
	public String gobalErr = r.getCellData("data", "Error", 2);
	public String emptyEmailErr = r.getCellData("data", "Error", 4);
	
}
