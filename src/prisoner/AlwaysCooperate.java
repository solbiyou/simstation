package prisoner;

public class AlwaysCooperate implements Strategy {

	@Override
	public boolean cooperate() {
		return true;
	} 
	
	public String getStrategyType() {
		return "Always Cooperate";
	}

}
