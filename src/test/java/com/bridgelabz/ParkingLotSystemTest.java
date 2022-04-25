package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

public class ParkingLotSystemTest {
  /*
  Test to check the vehicle is parked
   */
  @Test
  public void givenAVehicle_WhenParked_ShouldReturnTrue() {
    ParkingLotSystem parkingLotSystem = new ParkingLotSystem();
    boolean isParked = parkingLotSystem.parkTheVehicle("AUDI");
    Assert.assertTrue(isParked);
  }

  /*
  Test to check the vehicle is unparked
   */
  @Test
  public void givenAVehicle_WhenUnParked_ShouldReturnTrue() {
    ParkingLotSystem parkingLotSystem = new ParkingLotSystem();
    parkingLotSystem.parkTheVehicle("BMW");
    boolean isUnParked = parkingLotSystem.unParkTheVehicle("BMW");
    Assert.assertTrue(isUnParked);
  }
}
