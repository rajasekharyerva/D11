package com.d11.page;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{
	@FindBy(xpath="//div[text()='My Contests']")
	WebElement myContests;
	
	@FindBy(xpath="//div[text()='Home']")
	WebElement home;

	@FindBy(xpath="//div[text()='Results'] | (//a[contains(text(),'Results')])[1]")
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
	
	@FindBy(xpath="//i[text()='info']")
	List<WebElement> playerInfo;

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

	@FindBy(xpath="(//a[text()='Most Runs'])[2]")
	WebElement mostRuns;

	@FindBy(xpath="(//a[text()='Most Wickets'])[2]")
	WebElement mostWickets;

	@FindBy(xpath="//a[text()='Score']")
	WebElement score;

	@FindBy(xpath="//table/tbody/tr")
	List<WebElement> rows;

	@FindBy(xpath="//tr[contains(@class,'batsmanInns player-popup-link')]")
	List<WebElement> batsmenRows;
	
	@FindBy(xpath="//tr[@class='player-popup-link']")
	List<WebElement> bowlerRows;
	
	@FindBy(xpath="(//table[@class='batsmen'])[1]/thead/tr/th")
	List<WebElement> batsmenHeaders;
	
	@FindBy(xpath="(//table[@class='bowlers'])[1]/thead/tr/th")
	List<WebElement> bowlerHeaders;

	@FindBy(xpath="//table/thead/td | //table/tbody/tr/th")
	List<WebElement> headers;

	@FindBy(xpath="//div[contains(@class,'js-match match-list__item result')]")
	List<WebElement> matchResults;

	@FindBy(xpath="//div[contains(@class,'result__team result__team--loser')]/p")
	List<WebElement> loser;

	@FindBy(xpath="//div[@class='result__team ']/p")
	List<WebElement> winner;

	@FindBy(xpath="//div[@class='result__links']/a[text()='Match Centre']")
	List<WebElement> matchCentre;

	@FindBy(xpath="//tbody/tr/td//span[contains(@class,'table__logo tLogo')]")
	List<WebElement> logos;
	
	@FindBy(xpath="//a[contains(@href,'/cricket/leagues/Indian T20 League/811/')]")
	List<WebElement> upcomingMatches;
	
	@FindBy(xpath="//div[text()='My Teams']")
	WebElement mTeams;
	
	@FindBy(xpath="//span[text()='EDIT']")
	WebElement edit;
	
	@FindBy(xpath="//div[text()='WK']")
	WebElement wk;
			
	@FindBy(xpath="(//i[text()='keyboard_arrow_down'])[2]")
	WebElement closePlayer;
	
	@FindBy(xpath="//div[contains(@class,'player-profile-stats-header text-upper player-profile-row')]/following-sibling::div//div[contains(@class,'player-profile-row--border player-profile-row')]")
	List<WebElement> playerProfile;
	
	@FindBy(xpath="//div[@class='player-profile-toolBar']")
	WebElement playerProfTB;
	
	@FindBy(xpath="//div[text()='Total Points']/following-sibling::div")
	WebElement playerProfPts;
	
	@FindBy(xpath="//div[text()='Team']/ancestor::div[1]")
	WebElement playerProfTeam;
	
	@FindBy(xpath="//div[text()='Role']/ancestor::div[1]")
	WebElement playerProfRole;
	
	@FindBy(xpath="//div[contains(@class,'create-team__team-selector__player-card__cell create-team__team-selector__player-card__cell__col-player')]")
	List<WebElement> teamSelector;
	
	@FindBy(xpath="//div[text()='BAT']")
	WebElement bat;
	
	@FindBy(xpath="//div[text()='AR']")
	WebElement ar;
	
	@FindBy(xpath="//div[text()='BOWL']")
	WebElement bowl;

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

	public void clickMostRuns() {
		this.click(mostRuns);
	}
	
	public void clickClosePlayer() {
		this.click(closePlayer);
	}

	public void clickMostWickets() {
		this.click(mostWickets);
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
	
	public void clickHome() {
		this.click(home);
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
	
	public int getPlayerProfileCount() {
		return playerProfile.size();
	}
	
	public String getPlayerProfileText(int index) {
		return playerProfile.get(index).getText();
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
	
	public String getPlayerProfileTB() {
		return playerProfTB.getText();
	}
	
	public String getPlayerProfileTeam() {
		return playerProfTeam.getText();
	}
	
	public String getPlayerProfileRole() {
		return playerProfRole.getText();
	}
	
	public String getPlayerProfilePoints() {
		return playerProfPts.getText();
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
		int players = getRowsSize();
		System.out.println("Reading Players..." + getDateTime());
		for(int rowIndex = 0; rowIndex< players; rowIndex++) {
			List<WebElement> playerCols = getDriver().findElements(By.xpath("//table/tbody/tr["+(rowIndex+1)+"]/td"));
			for(int colIndex = 0; colIndex < playerCols.size(); colIndex++) {
				tableData[rowIndex][colIndex] = playerCols.get(colIndex).getText();
			}
		}
		System.out.println("Reading Players completed..." + getDateTime());
		return tableData;
	}

	public String getDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmm");
		return dateFormat.format(new Date());
	}

	public String[] getBatsmenHeaders() {
		String[] headers = new String[this.batsmenHeaders.size()];
		for(int hIndex = 0; hIndex < headers.length; hIndex++) {
			headers[hIndex] = this.batsmenHeaders.get(hIndex).getText() == null ? "" : this.batsmenHeaders.get(hIndex).getText();
		}
		return headers;
	}
	
	public String[] getBowlersHeaders() {
		String[] headers = new String[this.bowlerHeaders.size()];
		for(int hIndex = 0; hIndex < headers.length; hIndex++) {
			headers[hIndex] = this.bowlerHeaders.get(hIndex).getText();
		}
		return headers;
	}
	
	public String[] getHeaders() {
		String[] headers = new String[this.headers.size()];
		for(int hIndex = 0; hIndex < headers.length; hIndex++) {
			headers[hIndex] = this.headers.get(hIndex).getText();
		}
		return headers;
	}

	public int getRowsSize() {
		return this.rows.size();
	}
	
	public int getTeamSelectorSize() {
		return this.teamSelector.size();
	}
	
	public String getTeamSelectorText(int index) {
		return this.teamSelector.get(index).getText();
	}
	
	public int getUpcomingMatchesCount() {
		return this.upcomingMatches.size();
	}
	
	public void clickUpcomingMatch(int index) {
		this.click(upcomingMatches.get(index));
	}
	
	public void clickPlayerInfo(int index) {
		this.click(playerInfo.get(index));
	}
	
	public int getPlayerInfoSize() {
		return this.playerInfo.size();
	}
	
	public void clickMyTeams() {
		this.click(mTeams);
	}
	
	public void clickWK() {
		this.click(wk);
	}
	
	public void clickBAT() {
		this.click(bat);
	}
	
	public void clickAR() {
		this.click(ar);
		windowScrollTop();
	}
	
	public void clickBOWL() {
		this.click(bowl);
		windowScrollTop();
	}
	
	public void clickTeamEdit() {
		this.click(edit);
	}
	
	public int getBatsmenCount() {
		return this.batsmenRows.size();
	}
	
	public int getBowlerCount() {
		return this.bowlerRows.size();
	}

	public int getMatchResultsSize() {
		return this.matchResults.size();
	}

	public String getMatchWinner(int index) {
		return this.winner.get(index).getText();
	}

	public String getMatchLoser(int index) {
		return this.loser.get(index).getText();
	}

	public String[] getRowText(int index) {
		List<WebElement> colEls = this.rows.get(index).findElements(By.xpath(".//td"));
		String[] colElements = new String[colEls.size()];
		index = 0 ;
		for(WebElement el : colEls) {
			colElements[index] = el.getText();
			index++;
		}
		return colElements;
	}

	public String[] getBatsmenDataFromMatchResults(int index) {
		List<WebElement> colEls = null;
		String[] colArr = null;
		boolean retry = true;
		
		while(retry) {
			try {
				colEls = batsmenRows.get(index).findElements(By.xpath(".//td"));
				
				if(colEls.size() != 0 & colEls.size() == 8) {
					colArr = new String[colEls.size() - 1];
					for(int cIndex = 1; cIndex < colEls.size(); cIndex++) {
						colArr[cIndex - 1] = colEls.get(cIndex).getText();
				}
			}
			retry = false;
			}catch(StaleElementReferenceException e) {
				retry = true;
				System.out.println("StaleElementReferenceException occured retrying...");
				getDriver().navigate().refresh();
				waitFor(5);
			}
		}
		return colArr;
	}
	
	public String[] getBowlerDataFromMatchResults(int index) {
		List<WebElement> colEls = null;
		String[] colArr = null;
		boolean retry = true;
		
		while(retry) {
			try {
				colEls = bowlerRows.get(index).findElements(By.xpath(".//td"));
				
				if(colEls.size() != 0 & colEls.size() == 7) {
					colArr = new String[colEls.size() - 1];
					for(int cIndex = 1; cIndex < colEls.size(); cIndex++) {
						colArr[cIndex - 1] = colEls.get(cIndex).getText();
				}
			}
			retry = false;
			}catch(StaleElementReferenceException e) {
				retry = true;
				System.out.println("StaleElementReferenceException occured retrying...");
				getDriver().navigate().refresh();
				waitFor(5);
			}
		}
		return colArr;
	}

	public String getLogoText(int index) {
		return this.logos.get(index).getAttribute("class").split(" ")[2];
	}
}