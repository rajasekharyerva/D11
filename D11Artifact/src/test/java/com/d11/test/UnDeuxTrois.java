package com.d11.test;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class UnDeuxTrois extends BaseTest {
	XSSFWorkbook workbook = new XSSFWorkbook();
	XSSFSheet unDeuxTrois = null;
	String UNDEUXTROIS_STATS = "UnDeuxTrois.xlsx";
	int rowNo = 1;
	boolean header = true;

	@Test()
	public void getUnDeuxTroisStats() {
		List<String> rowList = new ArrayList<String>();

		homePage.clickTransactionHistory();
		homePage.setConfirmPassword("b10906038A!");
		homePage.clickOKConfirmPassword();
		homePage.selectDateRange30Days("");
		homePage.selectTransactionType("");
		homePage.clickSubmit();
		rowList = homePage.getRowData();
		generateUnDeuxTroisStats(rowList);
		
		//writeToMaster();

	}

	private void generateUnDeuxTroisStats(List<String> rowList) {
		//S.NoTransaction TypeAmountClosing BalanceDate
		unDeuxTrois = workbook.createSheet("UnDeuxTrois");
		Row row = null;
		Cell cell =null;
		int listSize = rowList.size();

		for(int index = 0; index < listSize; index++) {
			//Write to Excel
			if(header) {
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
				header = false;
			}

			String[] mInfo = rowList.get(index).split("\n");
			row = unDeuxTrois.createRow(rowNo);
			cell = row.createCell(0);
			cell.setCellValue((Integer) Integer.parseInt(mInfo[0]));
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
