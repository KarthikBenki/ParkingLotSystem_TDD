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
      Vehicle vehicle = new Vehicle("AUDI");
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
      Vehicle vehicle = new Vehicle("AUDI");
      parkingLotSystem.parkTheVehicle(vehicle);
      parkingLotSystem.parkTheVehicle(new Vehicle("BMW"));
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
      Vehicle vehicle = new Vehicle("BMW");
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
      Vehicle vehicle = new Vehicle("BMW");
      Vehicle vehicle1 = new Vehicle("AUDI");
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
      Vehicle vehicle = new Vehicle("BMW");
      parkingLotSystem.unParkTheVehicle(vehicle);
    } catch (ParkingLotException e) {
      Assert.assertEquals("ParkingLot Is Empty", e.getMessage());
      e.printStackTrace();
    }
  }

  /*
  As a Parking Lot owner I want to know when
  the lot is full So that I can put out the full sign
   */
  @Test
  public void givenArrayOfVehicles_WhenFull_ShouldReturnTrue() {
    Vehicle[] vehicles = {
      new Vehicle("car1"),
      new Vehicle("car2"),
      new Vehicle("car3"),
      new Vehicle("car4"),
      new Vehicle("car5")
    };
    boolean isFull = parkingLotSystem.checkParkingLot(vehicles);
    Assert.assertTrue(isFull);
  }

  /*
  Test case to check if the parking lot is empty
   */
  @Test
  public void givenArrayOfVehicles_WhenNotFull_ShouldReturnFalse() {
    Vehicle[] vehicles = {
      new Vehicle("car1"), new Vehicle("car2"), new Vehicle("car3"), new Vehicle("car4")
    };
    boolean isFull = parkingLotSystem.checkParkingLot(vehicles);
    Assert.assertFalse(isFull);
  }
}
