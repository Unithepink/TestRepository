import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class First {


    public Boolean isSelected(WebElement element){
        return element.isSelected();
    }

    public void checkChecbox (WebElement element){
        if (!element.isSelected()) element.click();
        else System.out.println("Checkbox is already selected");
    }

    public void uncheckChecbox (WebElement element){
        if (element.isSelected()) element.click();
        else System.out.println("Checkbox is already unchecked");
    }

    public void setCheckbox(WebElement element, String status){
        if (status.equals("checked")) checkChecbox(element);
        else if (status.equals("unchecked")) uncheckChecbox(element);
        else System.out.println("Checkbox param is not correct");
    }

    @Test
    public void CheckBoxTest01() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        driver.findElement(By.id("isAgeSelected")).click();
        Boolean isSelected01 = driver.findElement(By.id("isAgeSelected")).isSelected();
        Assert.assertTrue(isSelected01);

        driver.findElement(By.id("isAgeSelected")).click();
        Boolean isSelected02 = driver.findElement(By.id("isAgeSelected")).isSelected();
        Assert.assertFalse(isSelected02);
    }


    @Test
    public void CheckBoxTest01_Impruv01() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        WebElement checkbox = driver.findElement(By.id("isAgeSelected"));

        driver.get("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        checkbox.click();
        Assert.assertTrue(isSelected(checkbox));

        checkbox.click();
        Assert.assertFalse(isSelected(checkbox));
    }


    @Test
    public void CheckBoxTest01_Impruv02() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        WebElement checkbox = driver.findElement(By.id("isAgeSelected"));

        checkChecbox(checkbox);
        checkChecbox(checkbox);
        Assert.assertTrue(isSelected(checkbox));

        uncheckChecbox(checkbox);
        uncheckChecbox(checkbox);
        Assert.assertFalse(isSelected(checkbox));
    }

    @Test
    public void CheckBoxTest01_Impruv03() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        WebElement checkbox = driver.findElement(By.id("isAgeSelected"));

        setCheckbox(checkbox, "checked");
        Assert.assertTrue(isSelected(checkbox));

        setCheckbox(checkbox, "unchecked");
        Assert.assertFalse(isSelected(checkbox));
    }


    public void checkAllCheckboxes(List<WebElement> listOfElements){
        for (WebElement listOfElement : listOfElements) {
            if (!listOfElement.isSelected()) listOfElement.click();
        }
    }

    public void uncheckAllCheckboxes(List <WebElement> listOfElements){
        for (int i = 0; i < listOfElements.size(); i++){
            if (listOfElements.get(i).isSelected()) listOfElements.get(i).click();
        }
    }

    public void setAllCheckboxesTo(List <WebElement> listOfElements, String state){
        if (state.equals("checked")) checkAllCheckboxes(listOfElements);
        else if (state.equals("unchcked")) uncheckAllCheckboxes(listOfElements);
        else System.out.println("Selected Param for checkbox state selection is not correct");
    }

    public Boolean getAllCheckboxesState(List <WebElement> listOfElements){

        return true;
    }

    @Test
    public void MultipleChecbkx_02(){

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        List<WebElement> oCheckBox = driver.findElements(By.className("cb1-element"));

        int howManyChecboxes = oCheckBox.size();


        //FOR
        for (int i = 0; i < howManyChecboxes; i++){
            if (!oCheckBox.get(i).isSelected()) oCheckBox.get(i).click();

        }

        for (int i = 0; i < howManyChecboxes; i++){
            Assert.assertTrue(oCheckBox.get(i).isSelected());
        }


        //FOREACH
        for (WebElement anOCheckBox1 : oCheckBox) {
            if (anOCheckBox1.isSelected()) anOCheckBox1.click();

        }

        for (WebElement anOCheckBox : oCheckBox) {
            Assert.assertFalse(anOCheckBox.isSelected());
        }
    }

    @Test
    public void MultipleCheckbox_02_Impruv01() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        List <WebElement> oCheckBox = driver.findElements(By.className("cb1-element"));

        setAllCheckboxesTo(oCheckBox, "checked");


        setAllCheckboxesTo(oCheckBox, "unchecked");


    }

}
