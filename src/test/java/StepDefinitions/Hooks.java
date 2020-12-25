package StepDefinitions;

import Utilities.Driver;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {//yani bütün senaryolara kanca atar gibi öncesinde ve sonrasında çalışıyor

    @Before//her senaryodan önce çalışır
    public void before(Scenario scenario){
        System.out.println("senaryo başladı");
        System.out.println("senaryonun ID si: "+scenario.getId());
        System.out.println("senaryonun adı: "+scenario.getName());

    }

    @After//her senaryodan sonra çalışır
    public void after(Scenario scenario){

        System.out.println("senaryo bitti");
        System.out.println("senaryonun sonucu : "+scenario.getStatus());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Driver.quitDriver();

    }
}
