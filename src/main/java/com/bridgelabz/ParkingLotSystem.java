package com.bridgelabz;

public class ParkingLotSystem {

  String vehicle = null; // intialising vehicle with null

  /*
  method to park the vehicle
   */
  public boolean parkTheVehicle(String vehicle) {
    if (this.vehicle != null) // checking for empty slot
    return false;
    this.vehicle = vehicle; // parking the vehicle
    return true;
  }
}
