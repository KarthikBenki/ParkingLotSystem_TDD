package com.bridgelabz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author -> Karthik M C
 * @since -> 25/04/2022
 */
public class ParkingLotSystem {
  private static final int MAX_SIZE_OF_PARKINGLOT = 2;
  private Map<String, Vehicle> parkingLotMap = new HashMap<>();
  List<IParkingObserver> observers = new ArrayList<>();
  /** This program manages parking spaces for vehicles. */
  Vehicle vehicle = null; // intialising vehicle with null

  Owner owner = new Owner(); // creating owner object
  SecurityPersonal securityPersonal = new SecurityPersonal(); // creating Security personel object

  /**
   * @param vehicle
   * @throws ParkingLotException if parking lot is full
   */
  public void parkTheVehicle(Vehicle vehicle) throws ParkingLotException {
    if (parkingLotMap.size() <= MAX_SIZE_OF_PARKINGLOT) parkingLotMap.put(vehicle.id, vehicle);
    if (parkingLotMap.size() == MAX_SIZE_OF_PARKINGLOT) {
      owner.update("Parking Lot is Full");
      securityPersonal.update("Parking Lot is Full");
      throw new ParkingLotException("Parking Lot is Full");
    }
  }

  /**
   * @param //updating message to owner and security
   */
  private void notifyObservers(String message) {
    for (IParkingObserver list : observers) {
      list.update(message);
    }
  }

  /**
   * @param vehicle
   * @return true if vehicle is parked
   */
  public boolean isVehicleParked(Vehicle vehicle) {
    if (this.parkingLotMap.containsValue(vehicle)) return true;
    return false;
  }

  /**
   * @param vehicle
   * @throws ParkingLotException when parking lot is empty and asking for different vehicle
   */
  public void unParkTheVehicle(Vehicle vehicle) throws ParkingLotException {
    if (this.parkingLotMap.size() == 0) {
      notifyObservers("ParkingLot Is Empty");
      throw new ParkingLotException("ParkingLot Is Empty");
    }
    if (this.parkingLotMap.containsValue(vehicle)) {
      this.parkingLotMap.remove(vehicle.id);
      return;
    }
    throw new ParkingLotException("Asking for Different Vehicle");
  }

  /**
   * @param vehicle
   * @return true if vehicle is unparked
   */
  public boolean isVehicleUnParked(Vehicle vehicle) {
    if (!this.parkingLotMap.containsValue(vehicle)) return true;
    return false;
  }
}
