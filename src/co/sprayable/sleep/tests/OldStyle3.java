package co.sprayable.sleep.tests;

import co.sprayable.sleep.actions.Actions;
import co.sprayable.sleep.data.OrderData;
import co.sprayable.sleep.pages.Pages;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import qa.util.Constants;
import qa.util.base.BaseTest;

public class OldStyle3 extends BaseTest {

    private OrderData orderData = new OrderData();

    @BeforeClass
    private void genTestData() {
        orderData = orderData.generateOrderData();
    }

    @Test
    public void OldStyle31() {
        Actions.mainActions().clearSession();
        Actions.mainActions().openPage(Constants.GET_FREE_TRIAL_URL);
        Actions.mainActions().wait(Constants.SMALL_TIMEOUT_SECONDS);

        Actions.getFreeTrialActions().clickReadyToBuyNow();
        Actions.mainActions().wait(Constants.SMALL_TIMEOUT_SECONDS);
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.GET_FREE_TRIAL_URL), "Expected URL: " + Constants.GET_FREE_TRIAL_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");

    }

    @Test
    public void OldStyle32() {
        Actions.mainActions().clearSession();
        Actions.mainActions().openPage(Constants.GET_FREE_TRIAL_URL);
        Actions.mainActions().wait(Constants.SMALL_TIMEOUT_SECONDS);


        Actions.getFreeTrialActions().clickBuyNow();
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.CHECKOUT_URL), "Expected URL: " + Constants.CHECKOUT_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");
        Actions.checkoutAction().checkOutOrder(orderData);
        Actions.mainActions().wait(Constants.SMALL_TIMEOUT_SECONDS);
        //  Assert.assertTrue(driver().getCurrentUrl().contains(Constants.SPECIAL_OFFERS_URL), "Expected URL: " + Constants.SPECIAL_OFFERS_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");
        //  Pages.specialOffersPage().clickAddToMyOrderButton();
        Assert.assertTrue(Pages.thankyouPage().isConfirmOrderMessagePressent(), "Thank you page is not opened.");
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.THANK_YOU_URL), "Expected URL: " + Constants.THANK_YOU_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");
    }


    @Test
    public void OldStyle33() {
        Actions.mainActions().clearSession();
        Actions.mainActions().openPage(Constants.GET_FREE_TRIAL_URL);
        Actions.mainActions().wait(Constants.SMALL_TIMEOUT_SECONDS);

        Actions.getFreeTrialActions().clickFooterBuyNow();
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.CHECKOUT_URL), "Expected URL: " + Constants.CHECKOUT_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");
        Actions.checkoutAction().checkOutOrder(orderData);
        Actions.mainActions().wait(Constants.SMALL_TIMEOUT_SECONDS);

        Assert.assertTrue(Pages.thankyouPage().isConfirmOrderMessagePressent(), "Thank you page is not opened.");
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.THANK_YOU_URL), "Expected URL: " + Constants.THANK_YOU_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");
    }






    /*@Test
    public void testOldStyle3 () {
        Actions.mainActions().clearSession();
        Actions.mainActions().openPage(Constants.GET_FREE_TRIAL_URL);

        Actions.mainActions().wait(Constants.MINIMUM_TIMEOUT_SECONDS);
        
        Actions.getFreeTrialActions().checkPageScrolling();

        Pages.getFreeTrialPage().clickLinkClaimFreeSampleBottom();

        Pages.getFreeTrialPage().waitLinkClaimFreeSampleBottomDisappear();
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.CHECKOUT_URL), "Expected URL: " + Constants.CHECKOUT_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");
        Actions.checkoutAction().checkOutOrder(orderData);
        Actions.mainActions().wait(Constants.SMALL_TIMEOUT_SECONDS);
     // Assert.assertTrue(driver().getCurrentUrl().contains(Constants.SPECIAL_OFFERS_URL), "Expected URL: " + Constants.SPECIAL_OFFERS_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");
     // Pages.specialOffersPage().clickAddToMyOrderButton();
        Assert.assertTrue(Pages.thankyouPage().isConfirmOrderMessagePressent(), "Thank you page is not opened.");
        Assert.assertTrue(driver().getCurrentUrl().contains(Constants.THANK_YOU_URL), "Expected URL: " + Constants.THANK_YOU_URL + ". Current URL: " + driver().getCurrentUrl() + "\n");
    }*/
}