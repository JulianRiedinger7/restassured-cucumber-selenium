package steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.beust.ah.A;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import models.Character;
import models.Film;
import pages.EditPage;
import pages.HistoryPage;
import pages.HomePage;
import pages.ResultsPage;
import utils.UtilMethods;

public class SWapiWikipediaSteps {
  
  private Character character;
  private Film film;
  private WebDriver driver;
  private HomePage home;
  private ResultsPage results;
  private EditPage edit;
  private HistoryPage history;
  private static final int TOTAL_MOVIES = 6;

  @Before
  public void setup() {
    RestAssured.baseURI = "https://swapi.dev/api/";
    this.driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://en.wikipedia.org/wiki/Main_Page");
    home = new HomePage(driver);
  }
 
  @Given("the user is in SW API requesting character number {int}")
  public void userRequestingSWApiCharacter(int number) {
    Response response = RestAssured.given().get("people/" + number);

    character = response.as(Character.class);
  }

  @When("the user searchs the character's name {string} in Wikipedia")
  public void userSearchesCharacterNameInWikipedia(String name) {
    results = home.searchText(name);
  }

  @Then("the user should be able to see the article page with {string} as title")
  public void userAbleToSeeCorrectArticlePage(String expectedName) {
    Assert.assertEquals(expectedName, character.getName());
    Assert.assertTrue(results.isResultsTitleCorrect(UtilMethods.getAlternateTitle(expectedName)));
    Assert.assertTrue(results.isSidebarDisplayed());
  }

  @Given("the user is in SW API requesting a random movie")
  public void userRequestingRandomSWApiMovie() {
    int random = UtilMethods.generateRandom(TOTAL_MOVIES, 1);

    Response response = RestAssured.given().get("films/" + random);

    film = response.as(Film.class);
  } 

  @When("the user searches the movie in Wikipedia")
  public void userSearchsMovieInWikipedia() {
    results = home.searchText(film.getTitle());
  }

  @And("the user clicks on edit article")
  public void userClicksOnEditArticle() {
    edit = results.editArticle();
  }

  @And("the user clicks on view history of the article")
  public void userClicksOnViewArticleHistory() {
    history = results.viewArticleHistory();
  }

  @Then("the user should be able to see the edit page with the correct title")
  public void userAbleToSeeCorrectEditPage() {
    Assert.assertTrue(edit.isEditTitleCorrect("Editing"));
    Assert.assertTrue(edit.isEditTitleCorrect(UtilMethods.getAlternateTitle(film.getTitle())));
    Assert.assertTrue(edit.isEditorDisplayed());
  }

  @Then("the user should be able to see the history page with the correct title")
  public void userAbleToSeeCorrectHistoryPage() {
    Assert.assertTrue(history.isHistoryTitleCorrect(film.getTitle() + ": Revision history"));
    Assert.assertTrue(history.isFilterDisplayed());
  }

  @After
  public void teardown() {
    driver.quit();
  }
}
