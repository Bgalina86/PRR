package com.example.test_search;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.concurrent.TimeUnit;

/**
 * описана логика теста
 */
public class LoginTest {
    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static WebDriver driver;
    /**
     * осуществление первоначальной настройки
     */
    @BeforeClass
    public static void setup() {

        //определение пути до драйвера и его настройка
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        //создание экземпляра драйвера
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        //окно разворачивается на полный экран
        driver.manage().window().maximize();
        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //получение ссылки на страницу входа из файла настроек
        driver.get(ConfProperties.getProperty("loginpage")); }

   @AfterClass
    public static void tearDown() {
        //profilePage.entryMenu();
        //profilePage.userLogout();
        driver.quit(); }


    @Test
    public void loginTest() {
        //значение login/password берутся из файла настроек по аналогии с chromedriver
//и loginpage
        //вводим поисковой вопрос
        loginPage.inputsearchvacancy(ConfProperties.getProperty("searchtext"));
        //нажимаем кнопку поиска
        loginPage.clickLoginBtn();
           }

    @Test
    public void loginTestSearchCrumbs() {
        loginPage.breadCrumbs(ConfProperties.getProperty("bread_crumbs"));
    }
    @Test
    public void loginTestSearch() {
        loginPage.searchPrimari(ConfProperties.getProperty("searchtext"));

    }

}
