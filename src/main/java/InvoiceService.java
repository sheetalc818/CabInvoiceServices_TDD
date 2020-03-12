public class InvoiceService {
    private static final int MIN_FARE = 5;
    private static double MIN_COST_PER_KELOMETER = 10;
    private static int COST_PER_TIME = 1;
    double totalFare = 0.0;

    public double calculateFare(double distance, int time) {
        totalFare = distance * MIN_COST_PER_KELOMETER + time * COST_PER_TIME;
        if (totalFare < MIN_FARE) {
            return MIN_FARE;
        }
        return totalFare;
    }

    public double calculateFare(Ride[] rides) {
        for (Ride ride : rides) {
            totalFare += this.calculateFare(ride.distance, ride.time);
        }
        return totalFare;
    }
}
