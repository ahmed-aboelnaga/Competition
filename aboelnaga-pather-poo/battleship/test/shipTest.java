import pack1.*;
import pack1.util.*;
import static org.junit.Assert.*;
import org.junit.*;



public class shipTest{
  @Test
  public void checkShipCreation(){
    Ship ship =new Ship(3,3);
    assertNotNull(ship);
  }
  @Test
  public void checkDecreasingOfHealthWhenHited(){
    Ship ship =new Ship(3,3);
    ship.hit();
    assertEquals(2,ship.getLifePoints());
    ship.hit();
    assertEquals(1,ship.getLifePoints());
  }
  @Test
  public void checkAnswerIsSunkWhenHealthIS0(){
    Ship ship =new Ship(1,3);
    Answer ans=ship.hit();
    assertEquals(ans,Answer.SUNK);
    assertEquals(true,ship.hasBeenSunk());
  }
  @Test
  public void checkAnswerIsHitWhenShipIsAttacked(){
    Ship ship =new Ship(3,3);
    Answer ans=ship.hit();
    assertEquals(ans,Answer.HIT);
  }
  @Test
  public void checkAnswerIsMissedWhenShipWasSunk(){
    Ship ship =new Ship(1,3);
    ship.hit();
    Answer ans2=ship.hit();
    assertEquals(ans2,Answer.MISSED);
  }
  public static junit.framework.Test suite() {
    return new junit.framework.JUnit4TestAdapter(shipTest.class);
    }
}
