package com.keyin.completed.rideshare;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RideServiceTest {

    @Mock
    NotificationService mockNotificationService;
    @Mock
    PaymentGateway mockPaymentGateway;
    @Mock
    DriverFinder mockDriverFinder;

    RideService rideService;

    @BeforeEach
    void setUp() {
        rideService = new RideService(mockNotificationService,mockPaymentGateway,mockDriverFinder);


    }

    @Test
    void testSuccessfulBooking(){
        when(mockDriverFinder.findNearestDriver("Downtown")).thenReturn("Alice");
        when(mockPaymentGateway.processPayment("Bob", 100)).thenReturn(true);

        RideConfirmation confirmation = rideService.bookRide("Bob", "Downtown",100);

        Assertions.assertTrue(confirmation.isSuccess());
        Assertions.assertEquals("Alice", confirmation.getDriverName());
        Assertions.assertEquals("Bob", confirmation.getRiderName());
        Assertions.assertEquals("Ride booked successfully", confirmation.getMessage());
        verify(mockNotificationService).sendNotificationToRider("Bob", "Driver Alice is on the way!");

    }
}
