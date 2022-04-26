package com.bridgelabz;

import java.util.HashMap;
import java.util.Map;

/**
 * @author -> Karthik M C
 * @since -> 25/04/2022
 */
public class ParkingLotSystem {
  private static final int MAX_SIZE_OF_PARKINGLOT = 2;
  private Map<String, Vehicle> parkingLotMap = new HashMap<>();
  /** This program manages parking spaces for vehicles. */
  Vehicle vehicle = null; // intialising vehicle with null

  /**
   * @param vehicle
   * @throws ParkingLotException if parking lot is full
   */
  public void parkTheVehicle(Vehicle vehicle) throws ParkingLotException {
    if (parkingLotMap.size() <= MAX_SIZE_OF_PARKINGLOT)
      parkingLotMap.put(vehicle.id, vehicle);
//    if (this.vehicle != null) // checking for empty slot
    if(parkingLotMap.size()==MAX_SIZE_OF_PARKINGLOT)
    throw new ParkingLotException("Parking Lot is Full");
//    this.vehicle = vehicle; // parking the vehicle
  }

  /**
   * @param vehicle
   * @return true if vehicle is parked
   */
  public boolean isVehicleParked(Vehicle vehicle) {
//    if (this.vehicle.equals(vehicle)) return true;
    if(this.parkingLotMap.containsValue(vehicle)) return true;
    return false;
  }

  /**
   * @param vehicle
   * @throws ParkingLotException when parking lot is empty and asking for different vehicle
   */
  public void unParkTheVehicle(Vehicle vehicle) throws ParkingLotException {
    if (this.vehicle == null) throw new ParkingLotException("ParkingLot Is Empty");
    if (this.vehicle.equals(vehicle)) {
      this.vehicle = null;
      return;
    }
    throw new ParkingLotException("Asking for Different Vehicle");
  }

  /**
   * @param vehicle
   * @return true if vehicle is unparked
   */
  public boolean isVehicleUnParked(Vehicle vehicle) {
    if (this.vehicle == null) return true;
    return false;
  }

  public boolean checkParkingLot(Vehicle[] vehicles) {
    return vehicles.length == MAX_SIZE_OF_PARKINGLOT;
  }
}
