public class InvoiceSummary {

    public double avgFare;
    public int numOfRides;
    public double totalFare;

    public InvoiceSummary(int numOfRides, double totalFare) {
        this.numOfRides = numOfRides;
        this.totalFare = totalFare;
        this.avgFare = this.totalFare/this.numOfRides;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceSummary summary = (InvoiceSummary) o;
        return Double.compare(summary.avgFare, avgFare) == 0 &&
                numOfRides == summary.numOfRides &&
                Double.compare(summary.totalFare, totalFare) == 0;
    }
}
