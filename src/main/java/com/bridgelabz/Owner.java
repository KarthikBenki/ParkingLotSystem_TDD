package com.bridgelabz;

public class Owner implements IParkingObserver {
    private static String status;

    @Override
    public void update(String message) {
        this.status = message;
    }

    public String getStatus() {
        return status;
    }
}
