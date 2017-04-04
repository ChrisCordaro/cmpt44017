
public class State {
	private State currentState = getCurrentState();
	private String stateName = "";
	private int stateNumber = 0;
	
	public State(){
		
	}
	
	public void setState(State s){
		this.currentState = s;
	}
	
	public void setStateName(String s){
		this.stateName = s;
	}
	
	public void setStateNumber(int i){
		this.stateNumber = i;
	}
	
	public void updateState(String s, int i){
		if(this.getStateNumber() != 0){
			this.setStateName(s);
			this.setStateNumber(i);
		}
	}
	
	public State getCurrentState(){
		return currentState;
	}
	
	public int getStateNumber(){
		return this.getStateNumber();
	}
}
