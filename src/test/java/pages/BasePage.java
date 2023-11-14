package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

  protected WebDriver driver;
  protected WebDriverWait wait;


  public BasePage(WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    PageFactory.initElements(driver, this);
  }

  public void waitElementClickable(WebElement element) {
    wait.until(ExpectedConditions.elementToBeClickable(element));
  }

  public void waitElementVisibility(WebElement element) {
    wait.until(ExpectedConditions.visibilityOf(element));
  }

  public void clickOn(WebElement element) {
    waitElementClickable(element);
    element.click();
  }

  public void writeOn(WebElement element, String text) {
    waitElementVisibility(element);
    element.sendKeys(text);
  }

  public boolean titleContains(String text, WebElement title) {
    waitElementVisibility(title);
    return title.isDisplayed() && title.getText().toLowerCase().contains(text.toLowerCase());
  }

  public boolean isElementDisplayed(WebElement element) {
    waitElementVisibility(element);
    return element.isDisplayed();
  }
}
