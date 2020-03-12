import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CabInvoiceTest {

    InvoiceService invoiceService = null;
    Ride rides[];

    @Before
    public void setUp() {
        invoiceService = new InvoiceService();
        rides = new Ride[]{new Ride(2.0, 5),
                new Ride(0.1, 1),
        };
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        double distance = 2.0;
        int time = 5;
        double fare = invoiceService.calculateFare(distance, time);
        Assert.assertEquals(25, fare, 0.0);
    }

    @Test
    public void givenLessDistanceAndTime_ShouldReturnMinFare() {
        double distance = 0.1;
        int time = 1;
        double fare = invoiceService.calculateFare(distance, time);
        Assert.assertEquals(5, fare, 0.0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
        InvoiceSummary summary = invoiceService.calculateFare(rides);
        InvoiceSummary expectedSummary = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(expectedSummary, summary);
    }

    @Test
    public void givenUserIdAndRides_ShouldReturnInvoiceSummary() {
        String userId = "abc@b.com";
        invoiceService.addRides(userId, rides);
        InvoiceSummary summary = invoiceService.getInvoiceSummary(userId);
        InvoiceSummary expectedSummary = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(expectedSummary, summary);
    }
}
