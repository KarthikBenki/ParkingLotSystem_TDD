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
}
