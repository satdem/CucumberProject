package StepDefinitions;

import Pages.LoginPom;
import Utilities.Driver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class LoginSteps {
    WebDriver driver;
    LoginPom loginPom=new LoginPom();

    @Given("^siteye gidildi$")
    public void navigate_to_basqar() {

        driver= Driver.getDriver();
        driver.get("http://automationpractice.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
    }

    @When("^login yapıldı$")
    public void loginYapıldı() {

        loginPom.findElementAndClickFunction("signIn");
        loginPom.findElementAndSendKeysFunction("emailInput","aydogan@gmail.com");
        loginPom.findElementAndSendKeysFunction("password","75780709");
        loginPom.findElementAndClickFunction("signInBtn");


    }

    @When("^Go to the contact us page$")
    public void goToTheContactUsPage() {

        loginPom.findElementAndClickFunction("contactUs");
        Select select=new Select(loginPom.subjectH);
        select.selectByIndex(1);


    }

    @Then("^Send the \"([^\"]*)\" and \"([^\"]*)\"$")
    public void send_the_and(String email, String message)  {
        loginPom.findElementAndSendKeysFunction( "emailInput", email);
        loginPom.findElementAndSendKeysFunction( "mesaj", message);
        loginPom.findElementAndClickFunction("sendBtn");
    }


    @And("^Success message should display$")
    public void successMessageShouldDisplay() {
        //loginPom.mesageKontrol(loginPom.errorMsj,"error");
        loginPom.mesageKontrol(loginPom.onayMsj,"success");
    }

    @When("^specials i tikla$")
    public void specialsITikla() {


    }

    @Then("^bir urun sec, sepete ekle ve sepete git$")
    public void birUrunSecSepeteEkleVeSepeteGit() {


    }

    @And("^speti kontrol et$")
    public void spetiKontrolEt() {


    }
}
