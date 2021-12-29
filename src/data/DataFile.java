package data;

import utilities.Xls_Reader;

public class DataFile {
	
	//LoginTest Data
	Xls_Reader d= new Xls_Reader("/Users/amitmehta/Desktop/SeleniumDocs/ScotiaBankData.xlsx");
	public String wrongEmail=d.getCellData("Data1","UserName", 3);
	public String wrongPass=d.getCellData("Data1","Password", 2);
	public String emailWithSpecialChar=d.getCellData("Data1","UserName", 5);
	public String globalErr =d.getCellData("Data1","Global Error", 2);
	public String emptyEmailErr=d.getCellData("Data1","Email Error", 4);
	public String emptyPassErr=d.getCellData("Data1","Password Error", 3);
	public String emailSpecialCharErr= d.getCellData("Data1","Email Error", 5);

}
