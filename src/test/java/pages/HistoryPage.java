package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HistoryPage extends BasePage {

  @FindBy(id = "firstHeading")
  private WebElement historyTitle;

  @FindBy(id = "mw-content-text")
  private WebElement filterContainer;

  public HistoryPage(WebDriver driver) {
    super(driver);
  }

  public boolean isHistoryTitleCorrect(String text) {
    return titleContains(text, historyTitle);
  }

  public boolean isFilterDisplayed() {
    return isElementDisplayed(filterContainer);
  }
  
}
