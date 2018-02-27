package test.functional;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class FunctionalTest {

	private WebDriver driver;

    @Before
    public void setUp() throws Exception {
      System.setProperty("webdriver.chrome.driver","/Library/Java/JUNIT/chromedriver");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
  		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    // Test de la Story #1-homepage (https://trello.com/c/WKTneu9o/1-homepage)
	  @Test
    public void testHomepage() throws Exception {
        driver.get("https://www.meetup.com/fr-FR/");
				// assertEquals(selenium.getTitle(), "Partagez vos passions | Meetup");
		// WebElement description = selenium.findElement(By.CssSelector(".gridList"));
				assertThat(
				driver.findElement(
				By.cssSelector("meta[name='description']"))
				.getAttribute("content"),
				is("Partagez vos passions et faites bouger votre ville ! Meetup vous aide à rencontrer des personnes près de chez vous, autour de vos centres d'intérêt."));
				//assertThat(selenium.findElements(By.cssSelector(".text--middotLeft")).get(0).getText(), is("13:00"));
		// Rechercher l'élément h1 dans

				WebElement title = driver.findElement(By.tagName("h1"));
				assertThat(title.getText(), is("Vous avez une passion ?"));
				System.out.println(title.getText());

				assertThat(
				driver.findElement(
				By.cssSelector("p.text--big.text--heavy"))
				.getText(),
				is("Lancez-vous avec Meetup")
				);

				assertThat(
				driver.findElement(
				By.cssSelector("a[href='https://secure.meetup.com/register'].button.button--primary.text--big.j-modal--register"))
				.getText(),
				is("Inscription")
				);
    }


//text--big text--heavy
    // Test de la Story n ...
    // TODO
    // To Be Completed By Coders From Coding Factory

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

}
