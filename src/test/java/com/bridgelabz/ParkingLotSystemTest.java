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
    boolean isParked = parkingLotSystem.parkTheVehicle("AUDI");
    Assert.assertTrue(isParked);
  }

  /*
  Test to check the vehicle is unparked
   */
  @Test
  public void givenAVehicle_WhenUnParked_ShouldReturnTrue() {
    parkingLotSystem.parkTheVehicle("BMW");
    boolean isUnParked = parkingLotSystem.unParkTheVehicle("BMW");
    Assert.assertTrue(isUnParked);
  }
/*
test to check condition of parked one vehicle
asking to unpark different vehicle should return false
 */
  @Test
  public void givenAVehicle_WhenDifferentVehicleUnParked_ShouldReturnfalse() {
    parkingLotSystem.parkTheVehicle("BMW");
    boolean isUnParked = parkingLotSystem.unParkTheVehicle("AUDI");
    Assert.assertFalse(isUnParked);
  }

  /*
test to check condition of parked no vehicle
asking to unpark  vehicle should return false
 */
  @Test
  public void givenAVehicleNotParked_WhenUnParked_ShouldReturnfalse() {
    boolean isUnParked = parkingLotSystem.unParkTheVehicle("AUDI");
    Assert.assertFalse(isUnParked);
  }
}
