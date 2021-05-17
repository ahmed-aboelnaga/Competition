package sport;
/**
 * @author ABOELNAGA Ahmed
 * @author NOURY Louis
 */
public abstract class Match {
	
	protected Competitor c1=null,c2=null;
	protected Competitor winner=null;
	protected Competitor looser=null;
	
	protected int matchWinPoints,matchLoosePoints,matchDrawPoints;
	/**
	 * create a match 
	 */
	public Match(){
		this.matchDrawPoints=0;
		this.matchLoosePoints=0;
		this.matchWinPoints=0;
	}
	/**
	* create a match by system of points 
	* @param n1 match win points
	* @param n2 match loose points
	* @param n3 match draw points
	*/
	public Match(int n1,int n2,int n3){
		this.matchWinPoints=n1;
		this.matchLoosePoints=n2;
		this.matchDrawPoints=n3;
	}
	
	public abstract void startMatch()throws IllegalStateException;

	/**
	 * set players for the match
	 * @param c1 fst Competitor
	 * @param c2 snd Competitor
	 */
	public void setPlayers(Competitor c1,Competitor c2)throws IllegalStateException {
		if (c1.equals(c2)) throw new  IllegalStateException("same Competitor");
		this.setC1(c1);
		this.setC2(c2);
	}
	/**
	 * @return  match's winner null if invoked before startMatch
	 */
	public Competitor getWinner(){
		return this.winner;
	}
	
	public Competitor getLooser() {
		return this.looser;
	}
	
	/**
	 * allows to know more details about the match
	 * @return String match details
	 * @throws IllegalStateException if invoked before initialisation of match two participants 
	 */
	public String matchDetails() throws IllegalStateException{
		if (this.getC1() ==null || this.getC2()==null|| this.getWinner()==null) throw new IllegalStateException("no match played");
		String res="";
		res+=this.getC1().getName() +" vs "+this.getC2().getName()+" : " + this.winner.getName()+" wins!";
		return res;
	}
	/**
	 * @return Competitor  snd participant in the match
	 */
	public Competitor getC2() {
		return this.c2;
	}
	/**
	 * @return Competitor fst participant in the match
	 */
	public Competitor getC1() {
		return this.c1;
	}
	/**
	 * allows to set  match second participant
	 * @param c2  match  second participant
	 */
	public void setC2(Competitor c2) {
		 this.c2=c2;
	}
	/**
	 * allows to set  match first participant
	 * @param c1  match first participant
	 */
	public void setC1(Competitor c1) {
		 this.c1=c1;
	}
	/**
	 * @return match win points
	*/
	public int getMatchWinPoints() {
		
		return this.matchWinPoints;
	}
	/**
	* @return match draw points
	*/
	public int getMatchDrawPoints() {
		
		return this.matchDrawPoints;
	}
	/**
	* @return match loose points
	*/
	public int getMatchLoosePoints() {
		
		return this.matchLoosePoints;
	}
	/**
	 * set match win points
	 *@param n win points
	*/
	public void setMatchWinPoints(int n){
		assert n >= 0 : "win points can't be a negative number" ;
		this.matchWinPoints=n;
	}
	/**
	 * set match draw points
	 *@param n draw points
	*/
	public void setMatchDrawPoints(int n){
		assert n >= 0 : "draw points can't be a negative number" ;
		this.matchDrawPoints=n;
	}
	/**
	 * set match loose points
	 *@param n loose points
	*/
	public void setMatchLoosePoints(int n){
		assert n >= 0 : "loose points can't be a negative number" ;
		this.matchLoosePoints=n;
	}
	/**
	* reset all match fields Except points
	*/
	public void reset(){
		this.c1=this.c2=this.winner=null;
	}
			
	
	
	
	
	
	
}
