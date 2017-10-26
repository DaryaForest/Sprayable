package co.sprayable.sleep.pages;

import co.sprayable.sleep.actions.Actions;
import org.openqa.selenium.WebElement;
import qa.util.Constants;
import qa.util.base.BasePage;
import qa.util.base.Locator;
import qa.util.base.LocatorTypes;
import qa.util.reporting.Reporter;

import java.awt.*;

import static qa.util.Constants.Y_SHIFT;

public class SpecialAffordableOfferPage extends BasePage {

    private final String PAUSE_CSS_CLASS = "paused-mode";
    private final String PLAYING_CSS_CLASS = "playing-mode";
    private final String UNSTARTED_CSS_CLASS = "unstarted-mode";

    private Locator body = new Locator(LocatorTypes.XPATH, "//body");
    private Locator iframeVideo = new Locator(LocatorTypes.XPATH, "//section[@class='video-cta']//iframe");
    private Locator buttonLargePlay = new Locator(LocatorTypes.XPATH, "//div[@id='player']//button[contains(@class, 'ytp-large-play-button')]");
    private Locator buttonPause = new Locator(LocatorTypes.XPATH, "//div[@class='ytp-left-controls']//button[contains(@class, 'ytp-play-button')]");
    private Locator divVideoContainer = new Locator(LocatorTypes.XPATH, "//div[@id='player']/div");
    private Locator linkGetMyDiscount = new Locator(LocatorTypes.XPATH, "//div[@class='modal-right']/a[contains(@class, 'btn')]");
    private Locator linkBuyItNow = new Locator(LocatorTypes.XPATH, "//div[contains(@class, 'info')]/a[contains(@class, 'btn')]");
    private Locator linkIWantToTryItNow = new Locator(LocatorTypes.XPATH, "//div[@class='bottom-button']/a[contains(@class, 'btn')]");
    private Locator linkLearnMore = new Locator(LocatorTypes.XPATH, "//div[@class='not-convinced']/a[contains(@class, 'btn')]");

    private Locator middleButtonClickHereToBuySprayable = new Locator(LocatorTypes.XPATH, "//a[contains(@class,'font-scale-8 line-height-scale-1')]");
    private Locator footerButtonClickHereToBuySprayable = new Locator(LocatorTypes.XPATH, "//a[contains(@class,'font-scale-9 line-height-scale-3')]");
    private Locator middleOfThePage = new Locator(LocatorTypes.XPATH, "//div[contains(@data-widget-id,'e9d44')]");
    private Locator footerOfThePage = new Locator(LocatorTypes.XPATH, "//div[contains(@data-widget-id,'91691')]");

    public void clickLargePlay() {
        driver().switchTo().frame(driver().findElement(iframeVideo.getLocator()));

        waitToBeClickable("waiting for large 'Play' button become clickable", buttonLargePlay);

        try {
            WebElement buttonPlay = driver().findElement(buttonLargePlay.getLocator());
            buttonPlay.click();

            Reporter.logAction("click large 'Play' button");
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            WebElement buttonPlay = driver().findElement(buttonLargePlay.getLocator());
            buttonPlay.click();

            Reporter.logAction("click large 'Play' button");
        }
    }

    public void clickPause() {
        driver().switchTo().frame(driver().findElement(iframeVideo.getLocator()));

        waitForPresence("waiting for 'Pause' button become present", buttonPause);

        try {
            WebElement buttonPlay = driver().findElement(buttonPause.getLocator());
            buttonPlay.click();

            Reporter.logAction("click 'Pause' button");
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            WebElement buttonPlay = driver().findElement(buttonPause.getLocator());
            buttonPlay.click();

            Reporter.logAction("click 'Pause' button");
        }
    }

    public void clickLinkGetMyDiscount() {
        waitToBeClickable("wait for 'Get My 25% Sprayable Sleep Discount' button become clickable", linkGetMyDiscount);
        click("click 'Get My 25% Sprayable Sleep Discount' button", linkGetMyDiscount);
    }

    public void clickLinkBuyItNow() {
        waitToBeClickable("wait for button 'Buy It Now' become clickable", linkBuyItNow);
        click("click button 'Buy It Now'", linkBuyItNow);
    }

    public void clickLinkIWantToTryItNow() {
        waitToBeClickable("wait for button 'I Want To Try It Now' become clickable", linkIWantToTryItNow);
        click("click button 'I Want To Try It Now'", linkIWantToTryItNow);
    }

    public void clickLinkLearnMore() {
        waitToBeClickable("wait for 'Learn More' button become clickable", linkLearnMore);
        click("click 'Learn More' button", linkLearnMore);
    }

    public void waitLinkBuyItNowDisappear() {
        waitForInvisibility("wait for button 'Buy It Now' become invisible", linkBuyItNow);
    }

    public void waitLinkGetMyDiscountDissapear() {
        waitForInvisibility("wait for 'Get My 25% Sprayable Sleep Discount' button become invisible", linkGetMyDiscount);
    }

    public void waitBody() {
        waitForPresence("waiting for 'body' presents", body);
        Actions.mainActions().wait(Constants.MICRO_TIMEOUT_SECONDS);
    }

    public void moveToAddressLine() {
        Reporter.logAction("Moving cursor to address line");

        WebElement elemBody = driver().findElement(body.getLocator());

        int x = elemBody.getSize().getWidth() / Constants.BODY_WITH_DIVIDER;

        try {
            new Robot().mouseMove(x, 0);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public void moveToPage() {
        Reporter.logAction("Moving cursor to page");

        WebElement elemBody = driver().findElement(body.getLocator());

        int xShift = elemBody.getSize().getWidth() / Constants.BODY_WITH_DIVIDER;

        try {
            new Robot().mouseMove(driver().manage().window().getPosition().getX() + xShift, driver().manage().window().getPosition().getY() + Y_SHIFT);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public boolean isVideoPlaying() {
        driver().switchTo().frame(driver().findElement(iframeVideo.getLocator()));
        return getAttributeValue("Check player is playing", "class", divVideoContainer).contains(PLAYING_CSS_CLASS);
    }

    public boolean isVideoNotPlaying() {
        driver().switchTo().frame(driver().findElement(iframeVideo.getLocator()));
        return getAttributeValue("Check player is stopped", "class", divVideoContainer).contains(PAUSE_CSS_CLASS)
                || getAttributeValue("Check player is stopped", "class", divVideoContainer).contains(UNSTARTED_CSS_CLASS);
    }

    public void clickMiddleButtonBuySprayable() {
        scrollToElement("scroll to middle of the page", middleOfThePage);
        waitForVisibility("waiting for 'Click Here to Buy Sprayable Today (25% OFF for few hours)' link become visible", middleButtonClickHereToBuySprayable);
        click("click 'Click Here to Buy Sprayable Today (25% OFF for few hours)' button", middleButtonClickHereToBuySprayable);
    }

    public void clickFooterButtonBuySprayable() {
        scrollToElement("scroll to footer of the page", footerOfThePage);
        waitForVisibility("waiting for  'Buy It Now To Get Sprayable 25% OFF' link become visible", footerButtonClickHereToBuySprayable);
        click("click 'Buy It Now To Get Sprayable 25% OFF' button", footerButtonClickHereToBuySprayable);


    }
}