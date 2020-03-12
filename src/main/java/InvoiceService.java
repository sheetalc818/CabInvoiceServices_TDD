public class InvoiceService {
    private static final int MIN_FARE = 5;
    private static double MIN_COST_PER_KELOMETER = 10;
    private static int COST_PER_TIME = 1;
    private RideRepository rideRepository;
    double totalFare = 0.0;

    public InvoiceService() {
       this.rideRepository = new RideRepository();
    }

    public double calculateFare(double distance, int time) {
        totalFare = distance * MIN_COST_PER_KELOMETER + time * COST_PER_TIME;
        if (totalFare < MIN_FARE) {
            return MIN_FARE;
        }
        return totalFare;
    }

    public InvoiceSummary calculateFare(Ride[] rides) {
        for (Ride ride : rides) {
            totalFare += this.calculateFare(ride.distance, ride.time);
        }
        return new InvoiceSummary(rides.length,totalFare);
    }

    public InvoiceSummary getInvoiceSummary(String userId) {
        return this.calculateFare(rideRepository.getRides(userId));
    }

    public void addRides(String userId, Ride[] rides) {
        rideRepository.addRides(userId,rides);
    }
}
