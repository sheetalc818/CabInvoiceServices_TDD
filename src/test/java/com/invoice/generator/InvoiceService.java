package com.invoice.generator;

public class InvoiceService {
    private static final int MIN_FARE = 5;
    private static double MIN_COST_PER_KELOMETER = 10;
    private static int COST_PER_TIME = 1;

    public double calculateFare(double distance, int time) {
        double totalFare = distance * MIN_COST_PER_KELOMETER + time * COST_PER_TIME;
        if (totalFare < MIN_FARE){
            return MIN_FARE;
        }
        return totalFare;
    }
}
