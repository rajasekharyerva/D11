package com.d11.test;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.d11.page.HomePage;
import com.d11.page.LoginPage;

public class GetPlayerStats extends BaseTest {

	XSSFWorkbook workbook = new XSSFWorkbook();
	XSSFSheet sheet = workbook.createSheet("Stats");
	String FILE_NAME = "PlayerInfo.xlsx";
	String READ_FILE = "PlayerTeams.txt";
	String WRITE_FILE = "PlayerTeamsUpdated.txt";
	String contestName = null;
	String[] headers = null;
	int contests = 0;
	int rowNum = 1;
	Map<String, String> playerTeamMap = new HashMap<String, String>();

	@BeforeClass
	public void loadPages() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
	}

	@Test
	public void getPlayerStats() {
		//My Contest, Results
		homePage.clickMyContests();
		homePage.clickResults();
		//Index starts from 0(1), 1(2)
		contests = homePage.getContestJoinedCount();

		BufferedReader br = null;
		FileReader fr = null;
		BufferedWriter bw = null;
		FileWriter fw = null;

		try {
			fr = new FileReader(READ_FILE);
			br = new BufferedReader(fr);
			fw = new FileWriter(WRITE_FILE, true);
			bw = new BufferedWriter(fw);
			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				String[] data = sCurrentLine.split(":");
				playerTeamMap.put(data[0].trim(), data[1].trim());
			}
			
			for (Map.Entry<String,String> entry : playerTeamMap.entrySet()) 
				bw.write(entry.getKey() + ":" + entry.getValue()+ "\n");
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}


		for(int contestNo = 0; contestNo < contests; contestNo++){
			if(contestNo != 0)
				homePage.clickResults();

			homePage.clickContestJoined(contestNo);
			homePage.clickArrowRight();
			contestName = homePage.getContestName();
			homePage.clickScore();
			headers = homePage.getHeaders();

			String[][] playersInfo = homePage.getPlayersInfo();
			writeToExcel(playersInfo, contestName);

			for(int i = 0 ; i < 3; i++) {
				homePage.clickArrowBack();
			}
		}

		try {
			FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
			workbook.write(outputStream);
			workbook.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void writeToExcel(String[][] playersInfo, String contestName) {
		int colNum = 2;
		Row row = null;
		String playerName = null;
		//Player Header
		if(sheet.getPhysicalNumberOfRows() == 0) {
			row = sheet.createRow(0);
			Cell cell = row.createCell(0);
			cell.setCellValue((String) "VS");
			cell = row.createCell(1);
			cell.setCellValue((String) "Team");
			for (String header : headers) {
				cell = row.createCell(colNum++);
				cell.setCellValue((String) header);
			}
		}

		//Player Data
		colNum = 2;
		for (String[] player : playersInfo) {
			row = sheet.createRow(rowNum++);
			Cell cell = row.createCell(0);
			cell.setCellValue((String) contestName);
			//String[] teams = contestName.split("vs");
			
			for (String field : player) {
				cell = row.createCell(colNum++);
				if(colNum == 3) {
					cell.setCellValue((String) field);
					playerName = field;
				}
				else
					cell.setCellValue((Double) Double.parseDouble(field));	
			}
			colNum = 2;
			
			cell = row.createCell(1);
			cell.setCellValue((String) playerTeamMap.get(playerName));
		}
	}
}
