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
}
