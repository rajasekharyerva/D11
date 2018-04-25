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
	XSSFSheet sheet, batting, bowling = null;
	//XSSFSheet sheet = null;
	//XSSFSheet sheet = null;
	String JOINED_STATS = "JoinedStats.xlsx";
	String MOST_STATS = "MostStats.xlsx";
	String MATCHES_STATS = "MatchesStats.xlsx";
	String MONEY_STATS = "MoneyStats.xlsx";
	String IN_PROGRESS = "InProgress.xlsx";
	String READ_FILE = "PlayerTeams.txt";
	String WRITE_FILE = "PlayerTeamsUpdated.txt";
	String contestName = null;
	String[] headers = null;
	int contests = 0;
	int rowNum = 1;
	int bowRowNo = 1;
	int counter = 1;
	int rowNo = 1;
	Map<String, String> playerTeamMap = new HashMap<String, String>();

	@BeforeClass
	public void loadPages() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
	}

	@Test()
	public void getMatchesStats() {
		batting = workbook.createSheet("Batting");
		bowling = workbook.createSheet("Bowling");
		Row row = null;
		Cell cell =null;
		homePage.clickResults();
		
		
		
		for(int mIndex = 0; mIndex <1; mIndex++) {
		//for(int mIndex = 0; mIndex < 1; mIndex++) {

			String winner = homePage.getMatchWinner(mIndex);
			String loser = homePage.getMatchLoser(mIndex);
			String vs = winner.concat(" VS ".concat(loser));

			//homePage.waitFor(2);
			//homePage.clickMatchCentre(mIndex);
			if(mIndex < 10)
			driver.get("https://www.iplt20.com/match/2018/0"+(mIndex + 1)+"?tab=scorecard");
			else
			driver.get("https://www.iplt20.com/match/2018/"+(mIndex + 1)+"?tab=scorecard");
			homePage.waitFor(5);	
			
			//Batsmen
			if(mIndex == 0) {
				row = batting.createRow(0);
				cell = row.createCell(0);
				cell.setCellValue((String) "VS");
				cell = row.createCell(1);
				cell.setCellValue((String) "Winner");
				cell = row.createCell(2);
				cell.setCellValue((String) "Loser");

				String[] headers = homePage.getBatsmenHeaders();
				for(int hIndex = 0; hIndex < headers.length; hIndex++) {
					cell = row.createCell(hIndex + 3);
					cell.setCellValue((String) headers[hIndex] == null ? "" : headers[hIndex]);
				}
			}
			
			int batsmenCount = homePage.getBatsmenCount();
			
			for(int index = 0; index< batsmenCount; index++){

				String[] rowText =	homePage.getBatsmenDataFromMatchResults(index);
				row = batting.createRow(rowNum);
				for(int cInd = 0; cInd < rowText.length; cInd++) {
					if(index == 0) {
					cell = row.createCell(0);
					cell.setCellValue((String) vs);
					cell = row.createCell(1);
					cell.setCellValue((String) winner);
					cell = row.createCell(2);
					cell.setCellValue((String) loser);
					}
					
					cell = row.createCell(3 + cInd);
					cell.setCellValue((String) rowText[cInd]);
					
				}
				System.out.println(index + "completed");
				rowNum++;
			}
			
			//Bowlers
			if(mIndex == 0) {
				row = bowling.createRow(0);
				cell = row.createCell(0);
				cell.setCellValue((String) "VS");
				cell = row.createCell(1);
				cell.setCellValue((String) "Winner");
				cell = row.createCell(2);
				cell.setCellValue((String) "Loser");

				String[] headers = homePage.getBowlersHeaders();
				for(int hIndex = 0; hIndex < headers.length; hIndex++) {
					cell = row.createCell(hIndex + 3);
					cell.setCellValue((String) headers[hIndex] == null ? "" : headers[hIndex]);
				}
			}
			
			int bowlerCount = homePage.getBowlerCount();
			
			for(int index = 0; index< bowlerCount; index++){

				String[] rowText =	homePage.getBowlerDataFromMatchResults(index);
				row = bowling.createRow(bowRowNo);
				for(int cInd = 0; cInd < rowText.length; cInd++) {
					if(index == 0) {
					cell = row.createCell(0);
					cell.setCellValue((String) vs);
					cell = row.createCell(1);
					cell.setCellValue((String) winner);
					cell = row.createCell(2);
					cell.setCellValue((String) loser);
					}
					
					cell = row.createCell(3 + cInd);
					cell.setCellValue((String) rowText[cInd]);
					
				}
				System.out.println(index + "completed");
				bowRowNo++;
			}

			driver.navigate().back();
			homePage.waitFor(5);
		}

		try {
			FileOutputStream outputStream = new FileOutputStream(MATCHES_STATS);
			workbook.write(outputStream);
			workbook.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test()
	public void getMostStats() {
		sheet = workbook.createSheet("MostRuns");
		Row row = null;
		Cell cell =null;
		homePage.clickMostRuns();

		for(int index = 1; index < homePage.getRowsSize(); index++){
			if(index == 1) {
				row = sheet.createRow(0);
				cell = row.createCell(0);
				cell.setCellValue((String) "Team");

				String[] headers = homePage.getHeaders();
				for(int hIndex = 0; hIndex < headers.length; hIndex++) {
					cell = row.createCell(hIndex + 1);
					cell.setCellValue((String) headers[hIndex]);
				}
			}
			String[] rowText =	homePage.getRowText(index);
			for(int rInd = 0; rInd < rowText.length; rInd++) {
				row = sheet.createRow(index);
				cell = row.createCell(0);
				cell.setCellValue((String) homePage.getLogoText(index - 1));
				//Team
				for(int rIndex = 0; rIndex < rowText.length; rIndex++) {
					cell = row.createCell(rIndex +1);
					cell.setCellValue((String) rowText[rIndex]);
				}
			}
			System.out.println(index + "completed");
		}

		homePage.clickMostWickets();
		sheet = workbook.createSheet("MostWickets");

		for(int index = 1; index < homePage.getRowsSize(); index++){
			if(index == 1) {
				row = sheet.createRow(0);
				cell = row.createCell(0);
				cell.setCellValue((String) "Team");

				String[] headers = homePage.getHeaders();
				for(int hIndex = 0; hIndex < headers.length; hIndex++) {
					cell = row.createCell(hIndex + 1);
					cell.setCellValue((String) headers[hIndex]);
				}
			}
			String[] rowText =	homePage.getRowText(index);
			for(int rInd = 0; rInd < rowText.length; rInd++) {
				row = sheet.createRow(index);
				cell = row.createCell(0);
				cell.setCellValue((String) homePage.getLogoText(index - 1));
				//Team
				for(int rIndex = 0; rIndex < rowText.length; rIndex++) {
					cell = row.createCell(rIndex +1);
					cell.setCellValue((String) rowText[rIndex]);
				}
			}
			System.out.println(index + "completed");
		}

		try {
			FileOutputStream outputStream = new FileOutputStream(MOST_STATS);
			workbook.write(outputStream);
			workbook.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test()
	public void getMoneyStats() {
		sheet = workbook.createSheet("MoneyStats");
		long winnings = 0;
		int entry =0;
		long rank =0;
		long teams = 0;
		//My Contest, Results
		homePage.clickMyContests();
		homePage.clickResults();
		//Index starts from 0(1), 1(2)
		contests = homePage.getContestJoinedCount();

		for(int contestNo = 0; contestNo < contests; contestNo++){
			if(contestNo != 0)
				homePage.clickResults();

			homePage.clickContestJoined(contestNo);
			contestName = homePage.getContestName();

			int inProgress = homePage.getInProgressCount();
			for(int ind = 0; ind < inProgress; ind++){
				winnings = homePage.getWinnings(ind);
				entry = homePage.getEntry(ind);
				rank =homePage.getRank(ind);
				teams = homePage.getTeams(ind);

				//Select Entry
				homePage.clickInProgress(ind);
				//int lBCount = homePage.getLeaderBoardCount();
				int myTeams = homePage.getMyTeamsCount();

				//Select Team
				for(int tInd = 0; tInd < myTeams; tInd++) {
					String myTeam = homePage.getMyTeamName(tInd);
					String myPoints = homePage.getMyTeamPoints(tInd);
					String myRank = homePage.getMyTeamRank(tInd);
					int myWon = homePage.getMyTeamWon(tInd);
					writeToExcelWon(tInd, winnings, entry, teams, rank, myTeam, myPoints, myRank, myWon);
				}
				homePage.clickArrowBack();
			}
			homePage.clickArrowBack();
		}

		int pRows = sheet.getPhysicalNumberOfRows();
		double ents = 0;
		double won = 0;

		for(int i =1; i <pRows; i++) {
			Row currentRow = sheet.getRow(i);
			if(currentRow.getCell(1) != null){
				ents = currentRow.getCell(1).getNumericCellValue() + ents;
			}

			if(currentRow.getCell(7) != null){
				won = currentRow.getCell(7).getNumericCellValue() + won;
			}
		}
		Row resRow = sheet.createRow(rowNo);
		Cell cell = resRow.createCell(1);
		cell.setCellValue((Double) ents);
		cell = resRow.createCell(7);
		cell.setCellValue((Double) won);

		try {
			FileOutputStream outputStream = new FileOutputStream(MONEY_STATS);
			workbook.write(outputStream);
			workbook.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test()
	public void getJoinedStats() {
		sheet = workbook.createSheet("JoinedStats");
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
			FileOutputStream outputStream = new FileOutputStream(JOINED_STATS);
			workbook.write(outputStream);
			workbook.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test()
	public void getLiveStats() {
		sheet = workbook.createSheet("InProgress");
		int winnings = 0;
		int entry = 0;
		int rank = 0;
		int teams = 0;
		int teamsInfo = 0;
		//My Contest, Results
		homePage.clickMyContests();
		homePage.clickLive();
		homePage.clickContestJoined(0);
		int inProgress = homePage.getInProgressCount();

		for(int ind = 0; ind < inProgress; ind++){
			winnings = homePage.getWinnings(ind);
			entry = homePage.getEntry(ind);
			rank =homePage.getRank(ind);
			teams = homePage.getTeams(ind);

			//Select Entry
			homePage.clickInProgress(ind);

			//Select Team
			teamsInfo  = homePage.getAllTeamsCount();
			for(int tInd = 0; tInd < teamsInfo; tInd++) {
				String tPoins = homePage.getTeamPoints(tInd);
				homePage.clickTeam(tInd);

				writeToExcelLive(tInd, winnings, entry, rank, teams, tPoins);
				homePage.clickClose();
			}

			int pRows = sheet.getPhysicalNumberOfRows();
			double wins = 0;
			double ents = 0;
			double amt = 0;

			for(int i =1; i <pRows; i++) {
				Row currentRow = sheet.getRow(i);
				if(currentRow.getCell(0) != null) {
					wins = currentRow.getCell(0).getNumericCellValue() + wins;
				}
				if(currentRow.getCell(1) != null){
					ents = currentRow.getCell(1).getNumericCellValue() + ents;
				}

				if(currentRow.getCell(3) != null){
					if(currentRow.getCell(3).getNumericCellValue() == 1.0)
						amt = currentRow.getCell(0).getNumericCellValue() + amt;
				}
			}
			Row resRow = sheet.createRow(rowNo);
			Cell cell = resRow.createCell(0);
			cell.setCellValue((Double) wins);
			cell = resRow.createCell(1);
			cell.setCellValue((Double) ents);
			cell = resRow.createCell(3);
			cell.setCellValue((Double) amt);

			homePage.clickArrowBack();
		}

		try {
			FileOutputStream outputStream = new FileOutputStream(homePage.getDateTime().concat(IN_PROGRESS));
			workbook.write(outputStream);
			workbook.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		homePage.clickArrowBack();
	}

	private void writeToExcel(String[][] playersInfo, String contestName) {
		int colNum = 3;
		Row row = null;
		String playerName = null;
		//Player Header
		if(sheet.getPhysicalNumberOfRows() == 0) {
			row = sheet.createRow(0);
			Cell cell = row.createCell(0);
			cell.setCellValue((String) "VS");
			cell = row.createCell(1);
			cell.setCellValue((String) "Team");
			cell = row.createCell(2);
			cell.setCellValue((String) "SNo");
			for (String header : headers) {
				cell = row.createCell(colNum++);
				cell.setCellValue((String) header);
			}
		}

		//Player Data
		colNum = 3;
		for (String[] player : playersInfo) {
			row = sheet.createRow(rowNum++);
			Cell cell = row.createCell(0);
			cell.setCellValue((String) contestName);
			//String[] teams = contestName.split("vs");

			for (String field : player) {
				cell = row.createCell(colNum++);
				if(colNum == 4) {
					cell.setCellValue((String) field);
					playerName = field;
				}
				else
					cell.setCellValue((Double) Double.parseDouble(field));	
			}
			colNum = 3;

			cell = row.createCell(1);
			cell.setCellValue((String) playerTeamMap.get(playerName));
			cell = row.createCell(2);
			cell.setCellValue((Integer) counter);
		}
		counter++;
	}

	private void writeToExcelLive(int tInd, int winnings, int entry, int rank, int teams, String tPoints) {
		int colNum = 6;
		Row row = null;
		Cell cell = null;
		String playerName = null;
		String playerPoints = null;
		String teamName = null;
		//Player Header
		if(sheet.getPhysicalNumberOfRows() == 0) {
			row = sheet.createRow(0);
			cell = row.createCell(0);
			cell.setCellValue((String) "Winnings");
			cell = row.createCell(1);
			cell.setCellValue((String) "Entry");
			cell = row.createCell(2);
			cell.setCellValue((String) "Teams");
			cell = row.createCell(3);
			cell.setCellValue((String) "Rank");
			cell = row.createCell(4);
			cell.setCellValue((String) "Team Name");
			cell = row.createCell(5);
			cell.setCellValue((String) "Team Points");
			for (int i = 1; i < 12; i++) {
				cell = row.createCell(colNum++);
				cell.setCellValue((String) "Player" + i);
			}
		}

		String captain = homePage.getCaptainName();
		String vCaptain = homePage.getViceCaptainName();

		//Team name
		row = sheet.createRow(rowNo);
		if(tInd == 0) {
			cell = row.createCell(0);
			cell.setCellValue((Integer) winnings);
			cell = row.createCell(1);
			cell.setCellValue((Integer) entry);
			cell = row.createCell(2);
			cell.setCellValue((Integer) teams);
			cell = row.createCell(3);
			cell.setCellValue((Integer) rank);
		}

		cell = row.createCell(4);
		teamName = homePage.getTeamName();
		cell.setCellValue((String) teamName);
		cell = row.createCell(5);
		cell.setCellValue((String) tPoints);

		colNum = 6;
		//Player Data
		for(int plInd = 0; plInd < 11; plInd++) {
			cell = row.createCell(colNum);
			playerName = homePage.getPlayerName(plInd);
			playerPoints = homePage.getPlayerPoints(plInd);
			playerPoints = playerPoints.substring(0, (playerPoints.length() - 3));
			if(captain.equals(playerName)) {
				cell.setCellValue((String) "C-".concat(playerName.substring(0, 5)+":"+playerPoints));
			} else if(vCaptain.equals(playerName)) {
				cell.setCellValue((String) "VC-".concat(playerName.substring(0, 5)+":"+playerPoints));
			} else {
				cell.setCellValue((String) playerName.substring(0, 5)+":"+playerPoints);
			}
			colNum++;
		}

		rowNo++;
	}

	private void writeToExcelWon(int tInd, long winnings, int entry, long teams, long rank, String myTeam, String myPoints, String myRank, int myWon) {
		Row row = null;
		Cell cell = null;
		//Player Header
		if(sheet.getPhysicalNumberOfRows() == 0) {
			row = sheet.createRow(0);
			cell = row.createCell(0);
			cell.setCellValue((String) "Winnings");
			cell = row.createCell(1);
			cell.setCellValue((String) "Entry");
			cell = row.createCell(2);
			cell.setCellValue((String) "Teams");
			cell = row.createCell(3);
			cell.setCellValue((String) "Rank");
			cell = row.createCell(4);
			cell.setCellValue((String) "Team Name");
			cell = row.createCell(5);
			cell.setCellValue((String) "Team Points");
			cell = row.createCell(6);
			cell.setCellValue((String) "Team Rank");
			cell = row.createCell(7);
			cell.setCellValue((String) "Amount");
		}

		//Team name
		row = sheet.createRow(rowNo);
		if(tInd == 0) {
			cell = row.createCell(0);
			cell.setCellValue((Long) winnings);
			cell = row.createCell(1);
			cell.setCellValue((Integer) entry);
			cell = row.createCell(2);
			cell.setCellValue((Long) teams);
			cell = row.createCell(3);
			cell.setCellValue((Long) rank);
		}

		cell = row.createCell(4);
		cell.setCellValue((String) myTeam);
		cell = row.createCell(5);
		cell.setCellValue((String) myPoints);
		cell = row.createCell(6);
		cell.setCellValue((String) myRank);
		cell = row.createCell(7);
		cell.setCellValue((Integer) myWon);

		rowNo++;
	}
}
