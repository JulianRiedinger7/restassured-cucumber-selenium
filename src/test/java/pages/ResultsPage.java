package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultsPage extends BasePage {

  @FindBy(id = "firstHeading")
  private WebElement resultTitle;

  @FindBy(id = "mw-panel-toc")
  private WebElement sidebar;

  public ResultsPage(WebDriver driver) {
    super(driver);
  }

  public boolean isTitleCorrect(String text) {
    waitElementVisibility(resultTitle);
    return resultTitle.isDisplayed() && resultTitle.getText().equalsIgnoreCase(text);
  }

  public boolean isSidebarDisplayed() {
    waitElementVisibility(sidebar);
    return sidebar.isDisplayed();
  }
  
}
