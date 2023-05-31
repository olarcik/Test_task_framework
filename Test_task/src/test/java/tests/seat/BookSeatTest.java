package tests.seat;

import org.testng.annotations.Test;
import pages.seat.SeatPage;
import tests.base.BaseTest;

import static common.Config.BOOK_DAY;
import static common.Config.SEAT_LINK;

public class BookSeatTest extends BaseTest {

    @Test
    public void bookSeatCumstomerPlace(){

        basePage.open(SEAT_LINK);

        seatPage
                .clickOpenBookingsBtn()
                .clickOpenZTowerBtn()
                .clickOpenOrangeKitchenBtn()
                .clickToNextWeekBtn()
                .clickToNeccesaryDate("")
                .clickToGetPlaceBtn()
                .clickToBookBtn()
                .clickOpenZTowerBtn()
                .clickOpenOrangeKitchenBtn()
                .clickToNextWeekBtn()
                .clickToNeccesaryDate(BOOK_DAY)
                .assertResultAfterBookingPlace();

    }
}
