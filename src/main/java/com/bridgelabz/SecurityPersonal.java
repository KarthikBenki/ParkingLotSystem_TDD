package com.bridgelabz;

public class SecurityPersonal implements IParkingObserver{
    private String status;

    @Override
    public void update(String message) {
        this.status = message;
    }
}
