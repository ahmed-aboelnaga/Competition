package sport;


public class Reporter implements OnLookerC{

	Competition c=null;
	Displayer <String> dis =new StdDisplayer();
	String name;	
	/**
	 * Reaction in the midlle of Competition 
	 * @param event the source 
	 */
	public void middleReact(Event<Competition> event) {
		
		//this.c = (Competition )event.getSource();
		this.c = event.insTance();
		this.diffuseResults();
	}
	/**
	 * diffuse results of a match in the competition when middleReact is invoked
	 */
	protected void diffuseResults() {
		
		Competitor one =this.c.match.getC1();
		Competitor two =this.c.match.getC2();
		Competitor winner =this.c.match.getWinner();
		this.dis.displaymsg("👨🏻‍💻"+this.name+" says 🗣");
		this.dis.displaymsg("\n"+one.getName()+" played againsed "+two.getName()+" and "+winner.getName()+" win\n");
	}

	public  Reporter(String s) {

		this.name=s;
	}
	/**
	 * Reaction when Competition has started
	 * @param event the source 
	 */
	@Override
	public void startedReact(Event<Competition> event) {
		this.c = event.insTance();
		this.dis.displaymsg("Hello this is "+this.name+" with you and I will keep you up to date with this Competition\n" );
	}
	/**
	 * Reaction when Competition has ended
	 * @param event the source 
	 */
	@Override
	public void endedReact(Event<Competition> event) {
		this.c = event.insTance();
		this.dis.displaymsg("it's "+ this.name+" I'm glad to be with you ,the Competition has ended here is its participants classement: ");
		this.c.displayRanking();
	}

	/**
	 * tests the equality of the Reporter with another
	 * @return true if two Reporters have same name false otherwise
	 */
	public boolean equals(Object obj) {
		if (this == obj)  return true;

        if (obj == null || this.getClass() != obj.getClass()) return false;

        Reporter c = (Reporter) obj;
        return c.name.equals(this.name);
		
        
        
        
        
        
        
        
	}

	@Override
	/**
	 * @return last source who has invoked this instance
	 */
	public Competition getLastCaller() {

		return this.c;
	}


}
