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

	@FindBy(xpath="//div[text()='Contest Joined' or contains(text(),'Contests Joined')]")
	List<WebElement> contestJoined;
	
	@FindBy(xpath="//a[@class='contest-card__in-progress']")
	List<WebElement> inProgress;
	
	@FindBy(xpath="//div[text()='WINNINGS']/following-sibling::div/span/span[2]")
	List<WebElement> winnigs;
	
	@FindBy(xpath="//div[contains(@class,'fieldPlayerTitle_')]")
	List<WebElement> playerName;
	
	@FindBy(xpath="//div[contains(@class,'playerPoints_')]")
	List<WebElement> playerPoints;
	
	@FindBy(xpath="//div[@class='toolbar-title']")
	WebElement teamName;
	
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
		return Integer.parseInt(winnigs.get(index).getText());
	}
	
	public int getEntry(int index) {
		return Integer.parseInt(entry.get(index).getText());
	}
	
	public int getRank(int index) {
		//#
		return Integer.parseInt(rank.get(index).getText().substring(1));
	}
	
	public int getTeams(int index) {
		return Integer.parseInt(teams.get(index).getText());
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
		System.out.println("Reading Players..." + dateFormat.format(new Date()));
		int rowInd = 0;
		for(WebElement rEl : rows) {
			System.out.println("Reading Player "+ (rowInd + 1) + ": " + dateFormat.format(new Date()));
			List<WebElement> cols = rEl.findElements(By.xpath("./td"));
			int colInd = 0;
			for(WebElement cEl : cols) {
				tableData[rowInd][colInd] = cEl.getText();
				colInd++;
			}
			System.out.println("Reading Player "+ (rowInd + 1) + " completed: " + dateFormat.format(new Date()));
			rowInd++;
		}
		System.out.println("Reading Players completed..." + dateFormat.format(new Date()));
		return tableData;
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