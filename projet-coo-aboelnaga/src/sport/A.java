package sport;

import java.util.List;

public class A extends Selection {


	@Override
	public  List < ? extends Challenger > selectFrom(List <? extends CompetitionInfo> groups)throws IllegalArgumentException {
		
		return this.iFromAll(groups, 0);
		
	}
	
		
		
		
}
