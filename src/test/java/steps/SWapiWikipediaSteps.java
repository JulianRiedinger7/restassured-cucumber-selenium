package steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
    int random = (int) Math.round(Math.random() * (6 - 1) + 1);

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

  @Then("the user should be able to see the edit page with the correct title")
  public void userAbleToSeeCorrectEditPage() {
    Assert.assertTrue(edit.isEditTitleCorrect("Editing " + UtilMethods.getAlternateTitle(film.getTitle())));
    Assert.assertTrue(edit.isEditorDisplayed());
  }

  @After
  public void teardown() {
    driver.quit();
  }
}
