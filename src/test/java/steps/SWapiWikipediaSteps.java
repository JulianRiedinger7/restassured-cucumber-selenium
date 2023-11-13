package steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import models.Character;
import pages.HomePage;
import pages.ResultsPage;

public class SWapiWikipediaSteps {
  
  private Character character;
  private WebDriver driver;
  private HomePage home;
  private ResultsPage results;

  @Before
  public void setup() {
    RestAssured.baseURI = "https://swapi.dev/api";
    this.driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://www.wikipedia.org/");
    home = new HomePage(driver);
  }
 
  @Given("the user is in SW API requesting character number {int}")
  public void userRequestingSWApiCharacter(int number) {
    Response response = RestAssured.given().get("/people/" + number);

    character = response.as(Character.class);
  }

  @When("the user searchs the character's name {string} in Wikipedia")
  public void userSearchesCharacterNameInWikipedia(String name) {
    results = home.searchText(name);
  }

  @Then("the user should be able to see the article page with {string} as title")
  public void userAbleToSeeCorrectArticlePage(String expectedName) {
    Assert.assertEquals(expectedName, character.getName());
    Assert.assertTrue(results.isResultsTitleCorrect(expectedName));
    Assert.assertTrue(results.isSidebarDisplayed());
  }

  @After
  public void teardown() {
    driver.quit();
  }
}
