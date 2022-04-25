package com.bridgelabz;
/**
 * @author -> Karthik M C
 * @since -> 25/04/2022
 */
public class ParkingLotSystem {
  /** This program manages parking spaces for vehicles. */
  Vehicle vehicle = null; // intialising vehicle with null

  /**
   * @param vehicle -> Required to park the given vehicle.
   * @return -> Returns boolean by checking if the given vehicle is already parked.
   */
  public boolean parkTheVehicle(Vehicle vehicle) {
    if (this.vehicle != null) // checking for empty slot
    return false;
    this.vehicle = vehicle; // parking the vehicle
    return true;
  }

  /**
   * @param vehicle -> Required to un-park the given vehicle.
   * @return -> Returns boolean by checking if the given vehicle exists.
   */
  public boolean unParkTheVehicle(Vehicle vehicle) {
    if (this.vehicle == null) return false;
    if (this.vehicle.equals(vehicle)) {
      vehicle = null;
      return true;
    }
    return false;
  }
}
