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
     */
  @Test
  public void givenAVehicle_WhenParked_ShouldReturnTrue() {
    Vehicle vehicle = new Vehicle("AUDI");
    boolean isParked = parkingLotSystem.parkTheVehicle(vehicle);
    Assert.assertTrue(isParked);
  }

  /*
  Test to check the vehicle is unparked
   */
  @Test
  public void givenAVehicle_WhenUnParked_ShouldReturnTrue() {
    Vehicle vehicle = new Vehicle("BMW");
    parkingLotSystem.parkTheVehicle(vehicle);
    boolean isUnParked = parkingLotSystem.unParkTheVehicle(vehicle);
    Assert.assertTrue(isUnParked);
  }
/*
test to check condition of parked one vehicle
asking to unpark different vehicle should return false
 */
  @Test
  public void givenAVehicle_WhenDifferentVehicleUnParked_ShouldReturnfalse() {
    Vehicle vehicle = new Vehicle("BMW");
    Vehicle vehicle1 = new Vehicle("AUDI");
    parkingLotSystem.parkTheVehicle(vehicle);
    boolean isUnParked = parkingLotSystem.unParkTheVehicle(vehicle1);
    Assert.assertFalse(isUnParked);
  }

  /*
test to check condition of parked no vehicle
asking to unpark  vehicle should return false
 */
  @Test
  public void givenAVehicleNotParked_WhenUnParked_ShouldReturnfalse() {
    Vehicle vehicle = new Vehicle("BMW");
    boolean isUnParked = parkingLotSystem.unParkTheVehicle(vehicle);
    Assert.assertFalse(isUnParked);
  }
/*
As a Parking Lot owner I want to know when
the lot is full So that I can put out the full sign
 */
  @Test
  public void givenArrayOfVehicles_WhenFull_ShouldReturnTrue() {
    Vehicle[] vehicles = {new Vehicle("car1"),
                          new Vehicle("car2"),
                          new Vehicle("car3"),
                          new Vehicle("car4"),
                          new Vehicle("car5")};
    boolean isFull = parkingLotSystem.checkParkingLot(vehicles);
    Assert.assertTrue(isFull);
  }

  @Test
  public void givenArrayOfVehicles_WhenNotFull_ShouldReturnFalse() {
    Vehicle[] vehicles = {new Vehicle("car1"),
            new Vehicle("car2"),
            new Vehicle("car3"),
            new Vehicle("car4")};
    boolean isFull = parkingLotSystem.checkParkingLot(vehicles);
    Assert.assertFalse(isFull);
  }

}
