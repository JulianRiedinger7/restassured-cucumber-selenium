package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditPage extends BasePage {

  @FindBy(id = "firstHeading")
  private WebElement editTitle;

  @FindBy(className = "wikiEditor-ui")
  private WebElement editorContainer;

  public EditPage(WebDriver driver) {
    super(driver);
  }

  public boolean isEditTitleCorrect(String text) {
    return titleContains(text, editTitle);
  }

  public boolean isEditorDisplayed() {
    return isElementDisplayed(editorContainer);
  }
  

}
