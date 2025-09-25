package com.keyin.completed.rideshare;

public class RideConfirmation {
    private final boolean success;
    private final String message;
    private final String driverName;
    private final String riderName;

    public RideConfirmation(boolean success, String message, String driverName, String riderName) {
        this.success = success;
        this.message = message;
        this.driverName = driverName;
        this.riderName = riderName;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public String getDriverName() {
        return driverName;
    }

    public String getRiderName() {
        return riderName;
    }
}
