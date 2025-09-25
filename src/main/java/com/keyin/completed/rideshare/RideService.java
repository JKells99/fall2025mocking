package com.keyin.completed.rideshare;

public class RideService {

    private final NotificationService notificationService;
    private final PaymentGateway paymentGateway;
    private final DriverFinder driverFinder;

    public RideService(NotificationService notificationService, PaymentGateway paymentGateway, DriverFinder driverFinder) {
        this.notificationService = notificationService;
        this.paymentGateway = paymentGateway;
        this.driverFinder = driverFinder;
    }

    public RideConfirmation bookRide(String rider, String location,double fare){
        String driver = driverFinder.findNearestDriver( location);
        if(driver == null){
            return new RideConfirmation(false,"No Drivers Avail",null,rider);
        }
        if (!paymentGateway.processPayment(rider, fare)) {
            return new RideConfirmation(false, "Payment failed", null, rider);
        }

        notificationService.sendNotificationToRider(rider, "Driver " + driver + " is on the way!");
        return new RideConfirmation(true, "Ride booked successfully", driver, rider);
    }
}
