package sport;

import java.util.List;
import java.util.Map;

public interface CompetitionInfo {
	
	
	
	public Map<? extends Challenger, Integer> ranking();
	
	
	public void displayRanking();
	
	
	public List < ? extends Challenger>  getParticipants();
	
	
	

	

}
