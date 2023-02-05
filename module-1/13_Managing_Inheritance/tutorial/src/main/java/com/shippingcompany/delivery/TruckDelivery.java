package com.shippingcompany.delivery;

public class TruckDelivery extends Delivery {
    /**
     * The top speed of the truck represented in mph
     */
    public static final double TRUCK_TOP_SPEED = 60.0;

    @Override
    public int getDuration() {
        // time = distance / rate
        double decimalHours = (double) super.getDistance() / TRUCK_TOP_SPEED;
        int hours = (int) decimalHours;
        int minutes = (int) Math.round((decimalHours - hours) * 60);
        return hours * 60 + minutes; //duration in minutes
    }
}
