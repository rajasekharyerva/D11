package com.d11.test;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UnDeuxTrois extends BaseTest {
	XSSFWorkbook workbook = null; // new XSSFWorkbook();
	XSSFSheet unDeuxTrois, master = null;
	String UNDEUXTROIS_STATS = "UnDeuxTrois.xlsx";
	int rowNo = 1;
	boolean header = true;

	@BeforeClass
	public void setUp() {
		try {
			FileInputStream excelFile = new FileInputStream(new File("UnDeuxTrois.xlsx"));
			workbook = new XSSFWorkbook(excelFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void getUnDeuxTroisStats() {
		List<String> rowList = new ArrayList<String>();

		homePage.clickTransactionHistory();
		homePage.setConfirmPassword("b10906038A!");
		homePage.clickOKConfirmPassword();
		homePage.selectDateRange30Days("");
		homePage.selectTransactionType("");
		homePage.clickSubmit();
		String lastUpdated = getLastRowPhyicalData();
		rowList = homePage.getUpdatedRowData(lastUpdated);
		generateUnDeuxTroisStats(rowList);
	}

	private String getLastRowPhyicalData() {
		String retVal = "-";
		try {
			unDeuxTrois = workbook.getSheet("UnDeuxTrois");
			Row row = unDeuxTrois.getRow(unDeuxTrois.getLastRowNum());
			retVal = Double.toString(row.getCell(5).getNumericCellValue()).concat("\n").concat(row.getCell(6).getStringCellValue());
		} catch (Exception e) {
		}

		return retVal;
	}

	public void writeToMaster() {
		try {


			//Sheet datatypeSheet = workbook.getSheet("UnDeuxTrois");
			//Sheet master = workbook.cloneSheet(0); // UnDeuxTrois (2)
			//String shtName = workbook.getSheetName(1);
			//workbook.setSheetName(workbook.getSheetIndex("shtName"), "Master");
			unDeuxTrois = workbook.getSheet("UnDeuxTrois");
			master = workbook.getSheet("Master");
			int rows = unDeuxTrois.getPhysicalNumberOfRows();
			int mRows = master.getPhysicalNumberOfRows();

			for(int i = mRows - 1; i > 0 ; i--) {
				System.out.println(master.getRow(i).getCell(5).getStringCellValue());
				System.out.println(master.getRow(i).getCell(6).getStringCellValue());
				for(int j = rows - 1; j > 0 ; j--) {
					System.out.println(unDeuxTrois.getRow(j).getCell(5).getStringCellValue());
					System.out.println(unDeuxTrois.getRow(j).getCell(6).getStringCellValue());
				}
			}




			FileOutputStream outputStream = new FileOutputStream(UNDEUXTROIS_STATS);
			workbook.write(outputStream);
			workbook.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void generateUnDeuxTroisStats(List<String> rowList) {
		//S.NoTransaction TypeAmountClosing BalanceDate
		int noOfSheets = workbook.getNumberOfSheets();
		Row row = null;
		Cell cell =null;
		boolean found = false;

		for(int i = 0; i < noOfSheets; i++) {
			String shtName = workbook.getSheetName(i);
			if("UnDeuxTrois".equals(shtName)) {
				//workbook.removeSheetAt(i);
				found=true;
				break;
			}
		}

		if(!found) {
			unDeuxTrois = workbook.createSheet("UnDeuxTrois");
			//if(header) {
			row = unDeuxTrois.createRow(0);
			cell = row.createCell(0);
			cell.setCellValue((String) "S.No");
			cell = row.createCell(1);
			cell.setCellValue((String) "Transaction Type");
			cell = row.createCell(2);
			cell.setCellValue((String) "Game ID");
			cell = row.createCell(3);
			cell.setCellValue((String) "Status");
			cell = row.createCell(4);
			cell.setCellValue((String) "Amount");
			cell = row.createCell(5);
			cell.setCellValue((String) "Closing Balance");
			cell = row.createCell(6);
			cell.setCellValue((String) "Date");
			//header = false;
			//}
		}

		rowNo = unDeuxTrois.getLastRowNum() + 1;
		int listSize = rowList.size();

		for(int index = listSize - 1; index >= 0; index--) {
			//Write to Excel

			String[] mInfo = rowList.get(index).split("\n");
			row = unDeuxTrois.createRow(rowNo);
			cell = row.createCell(0);
			//cell.setCellValue((Integer) Integer.parseInt(mInfo[0]));
			cell.setCellValue((Integer) rowNo);
			String[] txnType = mInfo[1].split("-");
			cell = row.createCell(1);
			cell.setCellValue((String) txnType[0]);
			cell = row.createCell(2);
			if(txnType.length > 1) {
				String[] splitArr = txnType[1].trim().split(" ");
				cell.setCellValue((String) splitArr[0]);
				cell = row.createCell(3);
				cell.setCellValue((String)  splitArr[splitArr.length - 1]);
			} else {
				cell.setCellValue((String) "");
				cell = row.createCell(3);
				cell.setCellValue((String) "");
			}

			cell = row.createCell(4);
			cell.setCellValue((Double) Double.parseDouble(mInfo[2]));
			cell = row.createCell(5);
			cell.setCellValue((Double) Double.parseDouble(mInfo[3]));
			cell = row.createCell(6);
			cell.setCellValue((String) mInfo[4]);
			rowNo++;
		}

		try {
			FileOutputStream outputStream = new FileOutputStream(UNDEUXTROIS_STATS);
			workbook.write(outputStream);
			workbook.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
