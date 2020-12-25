package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class LoginPom extends _Parent {
    public LoginPom() {
        PageFactory.initElements(driver, this);
    }

    WebElement myElement;

    @FindBy(xpath = "//div[@class='header_user_info']/a")
    private WebElement signIn;
    @FindBy(css = "input[id='email']")//[id='email']
    private WebElement emailInput;
    @FindBy(css = "input[id='passwd']")
    private WebElement password;
    @FindBy(css = "button[id='SubmitLogin']")
    private WebElement signInBtn;

    @FindBy(xpath = "(//li[@class='item']/a)[5]")
    private WebElement contactUs;

    @FindBy(xpath = "//p[text()='There is 1 error']")
    public WebElement errorMsj;

    @FindBy(css = "p[class='alert alert-success']")
    public WebElement onayMsj;

    @FindBy(css = "select[id='id_contact']")
    public WebElement subjectH;
    @FindBy(css = "[id='message']")
    public WebElement mesaj;
    @FindBy(css = "button[id='submitMessage']")
    private WebElement sendBtn;

    @FindBy(xpath = "(//li[@class='item'])[1]/a")
    private WebElement specials;


    public void findElementAndClickFunction(String ElementName) {
        /**
         * Buraya tıklanacak butonun adı gönderilecek
         * Burada adından hangi eleman olduğu bulunuyor
         * ve sonra tıklanıyor.
         */

        switch (ElementName) {
            case "signInBtn":
                myElement = signInBtn;
                break;


            case "signIn":
                myElement = signIn;
                break;


            case "contactUs":
                myElement = contactUs;
                break;

            case "sendBtn":
                myElement = sendBtn;
                break;

            case "specials":
                myElement = specials;
                break;


        }
        clickFunction(myElement);
    }

    public void findElementAndSendKeysFunction(String elementName, String value) {

        switch (elementName) {
            case "emailInput":
                myElement = emailInput;
                break;
            case "password":
                myElement = password;
                break;

            case "mesaj":
                myElement = mesaj;
                break;


        }
        sendKeysFunction(myElement, value);
    }

    public void mesageKontrol(WebElement gercekmsg, String beklenen) {


        if (beklenen.equalsIgnoreCase("error")) {
            // gercekmsg=errorMsj;
            Assert.assertTrue(gercekmsg.getText().toLowerCase().contains(beklenen.toLowerCase()), "hata mesajı yok");
        } else if (beklenen.equalsIgnoreCase("success")) {
            // gercekmsg=onayMsj;
            Assert.assertTrue(gercekmsg.getText().toLowerCase().contains(beklenen.toLowerCase()), "onay mesajı yok");
        }
    }
}
