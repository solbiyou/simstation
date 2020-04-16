package prisoner;

public class AlwaysCheat implements Strategy {
	
	@Override
	public boolean cooperate() {
		return false;
	} 
	
	public String getStrategyType() {
		return "Always Cheat";
	}
	
}
