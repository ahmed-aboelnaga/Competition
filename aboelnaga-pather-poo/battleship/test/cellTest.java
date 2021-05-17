import pack1.*;
import pack1.util.*;
import org.junit.*;
import static org.junit.Assert.*;

import java.beans.Transient;

public class cellTest{
  @Test
  public void checkCellCreation(){
    Cell cell =new Cell();
    assertNotNull(cell);
  }
  @Test
  public void CheckIfCellIsHitedAfterCreationWithoutHitIt(){
    Cell cell =new Cell();
    assertFalse(cell.isHitedBefore());
  }
  @Test
  public void checkIfCellIsHitedWhenPlayerHitItWhenCellIsEmpty(){
    Cell cell =new Cell();
    Answer ans=cell.hit();
    assertSame(ans,Answer.MISSED);
  }
  @Test
  public void checkIfAnswerWillBeMissedIfTheCellWasAttackedBefore(){
    Cell cell =new Cell();
    cell.hit();
    Answer ans2=cell.hit();
    assertSame(ans2,Answer.MISSED);
  }

  @Test
  public void checkIfCellIsHitedWhenPlayerHitItWhenCellNotEmptyAndNotAttackedBefore(){
    Cell cell =new Cell();
    Ship ship =new Ship(3,3);
    cell.setShip(ship);
    Answer ans=cell.hit();
    assertSame(ans,Answer.HIT);
  }
  @Test
  public void checkIfCellIsHitedWhenPlayerHitItWhenCellNotEmptyAndAttackedBefore(){
    Cell cell =new Cell();
    Ship ship =new Ship(3,3);
    cell.setShip(ship);
    cell.hit();
    Answer ans=cell.hit();
    assertSame(ans,Answer.MISSED);
  }
  @Test
  public void checkCellAcceptanceOfAShip(){
    Cell cell =new Cell();
    Ship ship =new Ship(3,3);
    cell.setShip(ship);
    assertSame(ship,cell.getShip());
  }
  public static junit.framework.Test suite() {
    return new junit.framework.JUnit4TestAdapter(cellTest.class);
    }

}
