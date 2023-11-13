package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultsPage extends BasePage {

  @FindBy(id = "firstHeading")
  private WebElement resultTitle;

  @FindBy(id = "mw-panel-toc")
  private WebElement sidebar;

  @FindBy(id = "ca-edit")
  private WebElement editBtn;

  public ResultsPage(WebDriver driver) {
    super(driver);
  }

  public boolean isResultsTitleCorrect(String text) {
    return isTitleCorrect(text, resultTitle);
  }

  public boolean isSidebarDisplayed() {
    return isElementDisplayed(sidebar);
  }

  public EditPage editArticle() {
    clickOn(editBtn);
    return new EditPage(driver);
  }
  
}
