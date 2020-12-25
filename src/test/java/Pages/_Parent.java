package Pages;

import Utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class _Parent {
    /**
     * Bu dosya diğer bütün page ler için ortak click ve sendkeys
     * için nekleme, scroll ve clear gibi bütün işleleri tek yereden
     * yapabilmek için eklendi.Bu class diğer pageler tarafından exten edilerek
     * kullanılacak.Böylece tüm pagelerdeki elemanların click ve sendkeys özelliği
     * hem bekleme hem scroll hem de clear çözelliği kazanmış olacak.
     */
    WebDriver driver;
    WebDriverWait wait;

    public _Parent() {//burası constructor
        driver= Driver.getDriver();
        wait=new WebDriverWait(driver,20);

    }

    public void clickFunction(WebElement element){
        waitUntilClickable(element);//eleman clickable olana kadar bekle
        scrollToElement(element);//eleman clickable olana kadar scroll yap
        element.click();//click yap


    }

    public void sendKeysFunction(WebElement element,String value){
       waitUntilVisible(element); //eleman görünür olana kadar bekle
       scrollToElement(element); //eleman clickable olana kadar scroll yap
        element.clear();//eleman clear yap
        element.sendKeys(value);//value yi ata


    }

    public void waitUntilClickable(WebElement element){

        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitUntilVisible(WebElement element){

        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waiting(int ms)
    {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }//gerekli olduğında kullanmak için tanımladık beklemek için
    public List<WebElement> waitVisibleListAllElement(List<WebElement> elementList){
        wait.until(ExpectedConditions.visibilityOfAllElements(elementList));
        return elementList;//bu listin bütün elemanları gözükene kadar bekle demek
    }

    public  void scrollToElement(WebElement element){
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView()",element);


    }
    public void verifyElementContainsText(WebElement element,String text){
        // waitUntilVisible(element);
        wait.until(ExpectedConditions.textToBePresentInElement(element,text));
        System.out.println(element.getText());
        Assert.assertTrue(element.getText().toLowerCase().contains(text.toLowerCase()));
    }

}


