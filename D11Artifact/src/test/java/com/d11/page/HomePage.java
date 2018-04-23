package com.d11.page;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{
	@FindBy(xpath="//div[text()='My Contests']")
	WebElement myContests;

	@FindBy(xpath="//div[text()='Results']")
	WebElement results;

	@FindBy(xpath="//div[text()='Live']")
	WebElement live;

	@FindBy(xpath="//div[contains(text(), 'RJ6038')]")
	List<WebElement> myTeams;

	@FindBy(xpath="//div[contains(text(), 'RJ6038')]/following-sibling::div/div")
	List<WebElement> myPoints;

	@FindBy(xpath="//div[contains(text(), 'RJ6038')]/ancestor::div[1]/following-sibling::div/div/div[1]")
	List<WebElement> myRank;

	@FindBy(xpath="//div[contains(text(), 'RJ6038')]/ancestor::div[1]/following-sibling::div/div/div[2]")
	List<WebElement> myWins;

	@FindBy(xpath="//div[contains(text(),'Contest Joined') or contains(text(),'Contests Joined')]")
	List<WebElement> contestJoined;

	@FindBy(xpath="//div[contains(text(),'RJ6038')]/ancestor::div[1]/following-sibling::div//span[@class='currency-amount']")
	List<WebElement> amountWon;

	@FindBy(xpath="//a[@class='contest-card__in-progress']")
	List<WebElement> inProgress;

	@FindBy(xpath="//div[@class='leaderboard__players']")
	List<WebElement> leaderBoard;

	@FindBy(xpath="//div[text()='WINNINGS']/following-sibling::div/span/span[2]")
	List<WebElement> winnigs;

	@FindBy(xpath="//div[contains(@class,'fieldPlayerTitle_')]")
	List<WebElement> playerName;

	@FindBy(xpath="//div[contains(@class,'playerPoints_')]")
	List<WebElement> playerPoints;

	@FindBy(xpath="//div[@class='toolbar-title']")
	WebElement teamName;
	
	@FindBy(xpath="//img[@src='https://assets.dream11.com/public/imgs/playerRoleArtwork/Captain_Default.svg']/ancestor::div[2]/following-sibling::div[1]")
	WebElement captain;
	
	@FindBy(xpath="//img[@src='https://assets.dream11.com/public/imgs/playerRoleArtwork/ViceCaptain_Default.svg']/ancestor::div[2]/following-sibling::div[1]")
	WebElement vCaptain;

	@FindBy(xpath="//div[text()='ENTRY']/following-sibling::div/span/span[2]")
	List<WebElement> entry;

	@FindBy(xpath="//div[@class='contest-card__card__cta-rank']")
	List<WebElement> rank;

	@FindBy(xpath="//div[text()='TEAMS']/following-sibling::div")
	List<WebElement> teams;

	@FindBy(xpath="//div[@class='leaderboard__players__user-information']")
	List<WebElement> allTeams;

	@FindBy(xpath="//div[@class='leaderboard__players__user-information__points']/div[1]")
	List<WebElement> teamPoints;

	@FindBy(xpath="//div[contains(@class,'infobarContentLeft_')]")
	WebElement contestName;

	@FindBy(xpath="//i[text()='keyboard_arrow_right']")
	WebElement arrowRight;

	@FindBy(xpath="//i[text()='arrow_back']")
	WebElement arrowBack;

	@FindBy(xpath="//a[text()='Score']")
	WebElement score;

	@FindBy(xpath="//table/tbody/tr")
	List<WebElement> rows;

	@FindBy(xpath="//table/thead/td")
	List<WebElement> headers;

	@FindBy(xpath="//div[text()='More']")
	WebElement more;

	@FindBy(xpath="//i[text()='close']")
	WebElement close;

	@FindBy(xpath="//div[text()='Log Out']")
	WebElement logOut;

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickMyContests() {
		this.click(myContests);
	}

	public void clickClose() {
		this.click(close);
	}

	public void clickResults() {
		this.click(results);
	}

	public void clickLive() {
		this.click(live);
	}

	public void clickArrowRight() {
		this.click(arrowRight);
	}

	public void clickArrowBack() {
		this.click(arrowBack);
	}

	public String getContestName() {
		return this.getText(contestName);
	}

	public void clickContestJoined(int index) {
		this.click(contestJoined.get(index));
	}

	public String getMyTeamName(int index) {
		return myTeams.get(index).getText();
	}
	
	public String getCaptainName() {
		return captain.getText();
	}
	
	public String getViceCaptainName() {
		return vCaptain.getText();
	}

	public int getMyTeamsCount() {
		return myTeams.size();
	}

	public String getMyTeamRank(int index) {
		return myRank.get(index).getText();
	}

	public int getMyTeamWon(int index) {
		return Integer.parseInt(myWins.get(index).getText().isEmpty() ? "0" : myWins.get(index).getText().substring(1));
	}

	public String getMyTeamPoints(int index) {
		return myPoints.get(index).getText();
	}

	public int getContestJoinedCount() {
		return contestJoined.size();
	}

	public int getInProgressCount() {
		return inProgress.size();
	}

	public int getContestJoined() {
		return contestJoined.size();
	}

	public void clickScore() {
		this.click(score);
	}

	public void clickInProgress(int index) {
		this.click(inProgress.get(index));
	}

	public void clickTeam(int index) {
		this.click(allTeams.get(index));
	}

	public int getAllTeamsCount() {
		return allTeams.size();
	}

	public int getLeaderBoardCount() {
		return leaderBoard.size();
	}

	public String getLeaderBoardText(int index) {
		return leaderBoard.get(index).getText();
	}

	public String getTeamName() {
		return teamName.getText();
	}

	public void clickMore() {
		this.click(more);
	}

	public void clickLogout() {
		this.click(logOut);
	}

	public int getWinnings(int index) {
		return Integer.parseInt(winnigs.get(index).getText().replaceAll(",", ""));
	}

	public int getEntry(int index) {
		return Integer.parseInt(entry.get(index).getText());
	}

	public int getRank(int index) {
		//#
		return Integer.parseInt(rank.get(index).getText().substring(1));
	}

	public int getTeams(int index) {
		return Integer.parseInt(teams.get(index).getText().replaceAll(",", ""));
	}

	public String getPlayerName(int index) {
		return playerName.get(index).getText();
	}

	public String getTeamPoints(int index) {
		return teamPoints.get(index).getText();
	}

	public String getPlayerPoints(int index) {
		return playerPoints.get(index).getText();
	}

	public String[][] getPlayersInfo() {
		String[][] tableData = new String[22][15];
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		int players = getRowsSize();
		System.out.println("Reading Players..." + getDateTime());
		int rowInd = 0;
		for(int rowIndex = 0; rowIndex< players; rowIndex++) {
			List<WebElement> playerCols = getDriver().findElements(By.xpath("//table/tbody/tr["+(rowIndex+1)+"]/td"));
			for(int colIndex = 0; colIndex < playerCols.size(); colIndex++) {
				tableData[rowIndex][colIndex] = playerCols.get(colIndex).getText();
			}
		}

		/*for(WebElement rEl : rows) {
			System.out.println("Reading Player "+ (rowInd + 1) + ": " + dateFormat.format(new Date()));
			List<WebElement> cols = rEl.findElements(By.xpath("./td"));
			int colInd = 0;
			for(WebElement cEl : cols) {
				tableData[rowInd][colInd] = cEl.getText();
				colInd++;
			}
			System.out.println("Reading Player "+ (rowInd + 1) + " completed: " + dateFormat.format(new Date()));
			rowInd++;
		}*/
		System.out.println("Reading Players completed..." + getDateTime());
		return tableData;
	}

	public String getDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmm");
		return dateFormat.format(new Date());
	}

	public String[] getHeaders() {
		String[] headers = new String[15];
		for(int hIndex = 0; hIndex < headers.length; hIndex++) {
			headers[hIndex] = this.headers.get(hIndex).getText();
		}
		return headers;
	}

	public int getRowsSize() {
		return this.rows.size();
	}
}