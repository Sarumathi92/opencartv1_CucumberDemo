package Stepsdefinition;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;

import java.time.Duration;

public class loginmethod
{
    WebDriver driver;
    @Given("the user enter opencart application")
    public void the_user_enter_opencart_application()
    {
        driver=new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[normalize-space()='Log in']")).click();
    }
    @Given("enter the valid credential\\(Username:{string},password:{string})")
    public void enter_the_valid_credential_username_password(String email, String pwd)
    {
     driver.findElement(By.xpath("//input[@class='email']")).sendKeys(email);
     driver.findElement(By.xpath("//input[@class='password']")).sendKeys(pwd);
    }
    @When("user click the login button")
    public void user_click_the_login_button()
    {
           driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
    }
    @Then("it navigate to my account page")
    public void it_navigate_to_my_account_page()
    {
        //Validation
    boolean myaccountlinkstatus=driver.findElement(By.xpath("//a[normalize-space()='My account']")).isDisplayed();
        Assert.assertEquals(myaccountlinkstatus,true);


    }
    @Then("user see the user name in my account page")
    public void user_see_the_user_name_in_my_account_page()
    {
        boolean welcomestatus=driver.findElement(By.xpath("//h2[normalize-space()='Welcome to our store']")).isDisplayed();
        Assert.assertEquals(welcomestatus,true);
        driver.quit();
    }

}
