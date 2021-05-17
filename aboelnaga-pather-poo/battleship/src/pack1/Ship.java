package pack1;
public class Ship{
  private int length;
  private int life;
  private boolean wasHited;

  public  Ship(int lifepoints,int length){
    this.life=lifepoints;
    this.length=length;
  }
  /**
  *returns the ship health
  *@return int
  */
  public int getLifePoints(){
    return this.life;
  }
  /**
  *decrease the ship health
  */
  public boolean washited(){
    return this.wasHited;
  }
  private void decreaseLifePoints(){
    this.life--;
    this.wasHited=true;
  }
  /**
  *returns the length of the Ship
  *@return int
  */
  public int getLength(){
    return this.length;
  }
  /**
  *returns wether the ship is sunk or another
  *@return boolean
  */
  public boolean hasBeenSunk(){
    return this.life==0;
  }
  /**
  *allow to user to attack this ship
  *@return Answer
  */
  public Answer hit(){
    if (this.hasBeenSunk()){
      return Answer.MISSED;
    }
    this.decreaseLifePoints();
    if(this.hasBeenSunk()){
      return Answer.SUNK;
    }
    return Answer.HIT;
  }
}
