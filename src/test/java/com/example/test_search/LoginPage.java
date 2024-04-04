package com.example.test_search;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * содержит локацию элементов страницы логина и методы для взаимодействия с этими элементами
 */
public class LoginPage {
    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */
    public WebDriver driver;
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }
    @FindBy(xpath = "//input[@class='home__search-control']")
    private WebElement searchfille;
    @FindBy(xpath = "//button[@class='button_secondary home__search-button button']")
    private WebElement searchfillebutton;
    /**
     * метод для ввода данных в поисковую выдачу
     */
    public void inputsearchvacancy(String searchvacancy) {
        searchfille.sendKeys(searchvacancy); }


    /**
     * метод для осуществления нажатия кнопки поиска
     */
    public void clickLoginBtn() {
        searchfillebutton.click(); }
}
