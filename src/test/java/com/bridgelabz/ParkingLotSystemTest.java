package com.bridgelabz;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParkingLotSystemTest {
  private ParkingLotSystem parkingLotSystem;

  @Before
  public void setUp() throws Exception {
    parkingLotSystem = new ParkingLotSystem();
  }

  /*
  Test to check the vehicle is parked
  after calling park method
   */
  @Test
  public void givenAVehicle_WhenParked_ShouldReturnTrue() {
    try {
      Vehicle vehicle = new Vehicle("1","AUDI");
      parkingLotSystem.parkTheVehicle(vehicle);
      boolean isParked = parkingLotSystem.isVehicleParked(vehicle);
      Assert.assertTrue(isParked);
    } catch (ParkingLotException e) {
      Assert.assertEquals("Parking Lot is Full", e.getMessage());
      e.printStackTrace();
    }
  }
  /*
  Test to check if we try to park vehicle in the slot where
  already parked should throw exception
   */
  @Test
  public void givenAVehicle_WhenAlreadyParked_WhenTryToPark_ShouldThrowException() {
    try {
      Vehicle vehicle = new Vehicle("1","AUDI");
      Vehicle vehicle1 = new Vehicle("2","BMW");
      parkingLotSystem.parkTheVehicle(vehicle);
      parkingLotSystem.parkTheVehicle(vehicle1);
    } catch (ParkingLotException e) {
      Assert.assertEquals("Parking Lot is Full", e.getMessage());
      e.printStackTrace();
    }
  }

  /*
  Test to check the vehicle is unparked
  after calling unpark method
   */
  @Test
  public void givenAVehicle_WhenUnParked_ShouldReturnTrue() {
    try {
      Vehicle vehicle = new Vehicle("1","AUDI");
      parkingLotSystem.parkTheVehicle(vehicle);
      parkingLotSystem.unParkTheVehicle(vehicle);
      boolean isUnParked = parkingLotSystem.isVehicleUnParked(vehicle);
      Assert.assertTrue(isUnParked);
    } catch (ParkingLotException e) {
      Assert.assertEquals("ParkingLot Is Empty", e.getMessage());
      e.printStackTrace();
    }
  }

  /*
  test to check condition of parked one vehicle
  asking to unpark different vehicle should throw exception
   */
  @Test
  public void givenAVehicle_WhenDifferentVehicleUnParked_ShouldThrowException() {

    try {
      Vehicle vehicle = new Vehicle("1","AUDI");
      Vehicle vehicle1 = new Vehicle("2","BMW");
      parkingLotSystem.parkTheVehicle(vehicle);
      parkingLotSystem.unParkTheVehicle(vehicle1);
    } catch (ParkingLotException e) {
      Assert.assertEquals("Asking for Different Vehicle", e.getMessage());
      e.printStackTrace();
    }
  }

  /*
  test to check condition of parked no vehicle
  asking to unpark  vehicle should throw exception
   */
  @Test
  public void givenAVehicleNotParked_WhenUnParked_ShouldThrowAnException() {
    try {
      Vehicle vehicle = new Vehicle("1","bmw");
      parkingLotSystem.unParkTheVehicle(vehicle);
    } catch (ParkingLotException e) {
      Assert.assertEquals("ParkingLot Is Empty", e.getMessage());
      e.printStackTrace();
    }
  }






}
