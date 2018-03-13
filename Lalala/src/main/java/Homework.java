import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Homework {

    @Test
    public void formular(){
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();

        String URLm= "http://www.seleniumeasy.com/test/input-form-demo.html";

        driver.get(URLm);


        WebElement firstName= driver.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[1]/div/div/input"));

        firstName.click();

        firstName.sendKeys("Diana");


        WebElement lastName= driver.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[2]/div/div/input"));

        lastName.sendKeys("Damian");


        WebElement emailAddress= driver.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[3]/div/div/input"));

        emailAddress.sendKeys("email");


        WebElement phoneNr= driver.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[4]/div/div/input"));

        phoneNr.sendKeys("0000");


        WebElement address= driver.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[5]/div/div/input"));

        address.sendKeys("casa bonita");


        WebElement city= driver.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[6]/div/div/input"));

        city.sendKeys("Bucharest");

        //WebElement state= driver.findElement(By.className("form-control selectpicker"));

        Select oSelect= new Select(driver.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[7]/div/div/select")));

        //List<WebElement> elementCount= oSelect.getOptions();

        //System.out.println(elementCount.size());

        oSelect.selectByVisibleText("Arizona");


        WebElement zipCode= driver.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[8]/div/div/input"));

        zipCode.sendKeys("123456");


        WebElement domain= driver.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[9]/div/div/input"));

        domain.sendKeys("www.google.ro");








    }





}
