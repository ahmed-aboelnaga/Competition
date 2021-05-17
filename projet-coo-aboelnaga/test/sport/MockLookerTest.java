package sport;
public class MockLookerTest implements OnLookerC{


	public int x=0;
	public int y=0;
	public int z=0;
	Competition ev=null;
	
	public void middleReact(Event<Competition> ev) {
		this.x++;
	}
	public void startedReact(Event<Competition> ev) {
		this.y++;
	}
	
	public void endedReact(Event<Competition> ev) {
		this.z++;
		
		
	}

	@Override
	public Competition getLastCaller() {
		return this.ev;
	}

}
