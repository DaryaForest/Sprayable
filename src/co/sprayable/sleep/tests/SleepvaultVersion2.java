package co.sprayable.sleep.tests;

import co.sprayable.sleep.actions.Actions;
import co.sprayable.sleep.data.OrderData;
import co.sprayable.sleep.pages.Pages;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import qa.util.Constants;
import qa.util.base.BaseTest;

public class SleepvaultVersion2 extends BaseTest {

    private OrderData orderData = new OrderData();

    @BeforeClass
    private void genTestData() {
        orderData = orderData.generateOrderData();
    }


    @Test
    public void SleepvaultVersion21() {
        Actions.mainActions().clearSession();
        Actions.mainActions().openPage(Constants.SPRAYABLE_DISCOUNT_OFFER_URL);
        Actions.mainActions().wait(Constants.MINIMUM_TIMEOUT_SECONDS);

        Actions.discountOfferAction().middlePageButtonClick();
        Actions.mainActions().wait(Constants.SMALL_TIMEOUT_SECONDS);
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.PRODUCT_ORDER_25), "Expected URL: " +
                Constants.PRODUCT_ORDER_25 + ". Current URL: " + driver().getCurrentUrl() + "\n");
        Actions.productOrder25Action().clickHeaderBuyNow();

        Actions.mainActions().wait(Constants.MINIMUM_TIMEOUT_SECONDS);
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.CHECKOUT_URL), "Expected URL: " +
                Constants.CHECKOUT_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");
        Actions.checkoutAction().checkOutOrder(orderData);

        Actions.mainActions().wait(Constants.SMALL_TIMEOUT_SECONDS);

        Assert.assertTrue(Pages.thankyouPage().isConfirmOrderMessagePressent(), "Thank you page is not opened.");
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.THANK_YOU_URL), "Expected URL: " +
                Constants.THANK_YOU_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");
    }

    @Test
    public void SleepvaultVersion22() {
        Actions.mainActions().clearSession();
        Actions.mainActions().openPage(Constants.SPRAYABLE_DISCOUNT_OFFER_URL);
        Actions.mainActions().wait(Constants.MINIMUM_TIMEOUT_SECONDS);
        Actions.discountOfferAction().footerBuyItNowClick();
        // Actions.mainActions().switchToNewWindow();

        Actions.mainActions().wait(Constants.SMALL_TIMEOUT_SECONDS);
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.PRODUCT_ORDER_25), "Expected URL: " +
                Constants.PRODUCT_ORDER_25 + ". Current URL: " + driver().getCurrentUrl() + "\n");
        Actions.productOrder25Action().clickReadyToBuyNow();
        Actions.mainActions().wait(Constants.SMALL_TIMEOUT_SECONDS);
    }

    @Test
    public void SleepvaultVersion23() {
        Actions.mainActions().clearSession();
        Actions.mainActions().openPage(Constants.SPRAYABLE_DISCOUNT_OFFER_URL);
        Actions.mainActions().wait(Constants.MINIMUM_TIMEOUT_SECONDS);
        Actions.discountOfferAction().footerBuyItNowClick();

        Actions.mainActions().wait(Constants.SMALL_TIMEOUT_SECONDS);
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.PRODUCT_ORDER_25), "Expected URL: " +
                Constants.PRODUCT_ORDER_25 + ". Current URL: " + driver().getCurrentUrl() + "\n");
        Actions.productOrder25Action().clickFooterBuyNow();

        Actions.mainActions().wait(Constants.MINIMUM_TIMEOUT_SECONDS);
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.CHECKOUT_URL), "Expected URL: " +
                Constants.CHECKOUT_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");
        Actions.checkoutAction().checkOutOrder(orderData);

        Actions.mainActions().wait(Constants.SMALL_TIMEOUT_SECONDS);
        Assert.assertTrue(Pages.thankyouPage().isConfirmOrderMessagePressent(), "Thank you page is not opened.");
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.THANK_YOU_URL), "Expected URL: " +
                Constants.THANK_YOU_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");
    }

    @Test
    public void SleepvaultVersion24() {
        Actions.mainActions().clearSession();
        Actions.mainActions().openPage(Constants.SPRAYABLE_DISCOUNT_OFFER_URL);
        Actions.mainActions().wait(Constants.MINIMUM_TIMEOUT_SECONDS);
        Actions.discountOfferAction().footerBuyItNowClick();

        Actions.mainActions().wait(Constants.SMALL_TIMEOUT_SECONDS);
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.PRODUCT_ORDER_25), "Expected URL: " +
                Constants.PRODUCT_ORDER_25 + ". Current URL: " + driver().getCurrentUrl() + "\n");
        Actions.productOrder25Action().clickFooterBuyNow();

        Actions.mainActions().wait(Constants.MINIMUM_TIMEOUT_SECONDS);
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.ORDER_FREE_TRIAL_URL), "Expected URL: " +
                Constants.ORDER_FREE_TRIAL_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");
        Actions.orderFreeTrialSubscriptionActions().clickLinkBuyNow();
        Actions.mainActions().wait(Constants.MINIMUM_TIMEOUT_SECONDS);
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.CHECKOUT_URL), "Expected URL: " +
                Constants.CHECKOUT_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");
        Actions.checkoutAction().checkOutOrder(orderData);

        Actions.mainActions().wait(Constants.SMALL_TIMEOUT_SECONDS);
        Assert.assertTrue(Pages.thankyouPage().isConfirmOrderMessagePressent(), "Thank you page is not opened.");
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.THANK_YOU_URL), "Expected URL: " +
                Constants.THANK_YOU_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");
    }

}