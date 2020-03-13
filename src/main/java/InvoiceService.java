import java.util.ArrayList;

public class InvoiceService {
    private static final int NORMAL_MIN_FARE = 5;
    private static double NORMAL_MIN_COST_PER_KELOMETER = 10;
    private static int NORMAL_COST_PER_TIME = 1;


    private RideRepository rideRepository;
    double totalFare = 0.0;
    private double PREMIUM_MIN_COST_PER_KELOMETER = 15;
    private int PREMIUM_COST_PER_TIME = 2;
    private int PREMIUM_MIN_FARE = 20;

    public InvoiceService() {
        this.rideRepository = new RideRepository();
    }

    public static String getUserID() {
        ArrayList userIdList = new ArrayList();
        String userId = null;
        userIdList.add("ab@c.com");
        userIdList.add("test@abc");
        userIdList.add("test");

        for (int i = 0; i < userIdList.size(); i++) {
            userId = (String) userIdList.get(i);
        }
        return userId;
    }

    public double calculateFare(RideCategories categories, double distance, int time) {
        if (categories.equals(RideCategories.NORMAL_RIDE)) {
            totalFare = distance * NORMAL_MIN_COST_PER_KELOMETER + time * NORMAL_COST_PER_TIME;
            if (totalFare < NORMAL_MIN_FARE) {
                return NORMAL_MIN_FARE;
            }
            return totalFare;
        } else {
            totalFare = distance * PREMIUM_MIN_COST_PER_KELOMETER + time * PREMIUM_COST_PER_TIME;
            if (totalFare < PREMIUM_MIN_FARE) {
                return PREMIUM_MIN_FARE;
            }
            return totalFare;
        }
    }

    public InvoiceSummary calculateFare(Ride[] rides) {
        for (Ride ride : rides) {
            totalFare += this.calculateFare(RideCategories.NORMAL_RIDE, ride.distance, ride.time);
        }
        return new InvoiceSummary(rides.length, totalFare);
    }

    public InvoiceSummary getInvoiceSummary(String userId) {
        return this.calculateFare(rideRepository.getRides(userId));
    }

    public void addRides(String userId, Ride[] rides) {
        rideRepository.addRides(userId, rides);
    }
}
