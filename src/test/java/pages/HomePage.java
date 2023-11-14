package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

  @FindBy(css = "#searchform input[name='search']")
  private WebElement searchInput;

  @FindBy(css = "#searchform button")
  private WebElement searchBtn;

  public HomePage(WebDriver driver) {
    super(driver);
  }

  public ResultsPage searchText(String text) {
    writeOn(searchInput, text);
    clickOn(searchBtn);
    return new ResultsPage(driver);
  }
  
}
