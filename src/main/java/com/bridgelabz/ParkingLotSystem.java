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
  /*
  method to unpark the vehicle
   */
  public boolean unParkTheVehicle(String vehicle) {
    if (this.vehicle == null) return false;
    if (this.vehicle.equals(vehicle)) {
      vehicle = null;
      return true;
    }
    return false;
  }
}
