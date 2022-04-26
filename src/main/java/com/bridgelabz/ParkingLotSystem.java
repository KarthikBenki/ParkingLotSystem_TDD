package com.bridgelabz;
/**
 * @author -> Karthik M C
 * @since -> 25/04/2022
 */
public class ParkingLotSystem {
  private static final int MAX_SIZE_OF_PARKINGLOT = 5;
  /** This program manages parking spaces for vehicles. */
  Vehicle vehicle = null; // intialising vehicle with null

  /**
   * @param vehicle -> Required to park the given vehicle.
   * @return -> Returns boolean by checking if the given vehicle is already parked.
   */
  public void parkTheVehicle(Vehicle vehicle) throws ParkingLotException {
    if (this.vehicle != null) // checking for empty slot
    throw new ParkingLotException("Parking Lot is Full");
    this.vehicle = vehicle; // parking the vehicle
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

  public boolean checkParkingLot(Vehicle[] vehicles) {
    return vehicles.length == MAX_SIZE_OF_PARKINGLOT;
  }

  public boolean isVehicleParked(Vehicle vehicle) {
    if(this.vehicle.equals(vehicle)) return true;
    return false;
  }
}
