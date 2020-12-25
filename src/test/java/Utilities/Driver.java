package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
    /*Interview sorusu
       Singleton driver nedir?
       -bütün projede aynı ve tek bir driver in kullanılmasıdır
    * */
    private static WebDriver driver;

    public static WebDriver getDriver(){
        if (driver ==null){
            //chrome için
            WebDriverManager.chromedriver().setup();//sisteme cromedriver kullanacağım dedim ve set ettim.
            driver=new ChromeDriver();

            //firefox için
            /* WebDriverManager.firefoxdriver().setup();//sisteme cromedriver kullanacağım dedim ve set ettim.
            driver=new FirefoxDriver();*/

           /* WebDriverManager.firefoxdriver().setup();//sisteme firefox kullanacağım dedim ve set ettim.
            driver=new FirefoxDriver();*/
        }

        return driver;
    }

    public static void quitDriver(){

        if (driver !=null){

            driver.quit();
            driver=null;

        }

    }

}
