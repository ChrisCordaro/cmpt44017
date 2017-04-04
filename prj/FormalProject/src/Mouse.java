
public class Mouse{
	
	private Vector3D myVector = new Vector3D();
	private	Vector3D mousePosition;
	private Vector3D mouseVelocity;
	private State mouseDecider = new State();;
	
	public Mouse(float posX, float posY){
		this.mousePosition = new Vector3D(posX, posY, 0);
		this.mouseVelocity = new Vector3D(-1, -1, 0);
		this.mouseDecider = new State();
		//findLeaf();
	}
	
	public void findCheese(){
		
	}
	
	public void goHome(){
		
	}
	
	public void runAway(){
		
	}
	
	public void update(){
		/*
		 * if (checks regarding position of mouse)
		 * update state accordingly?
		 */
		//mouseDecider.updateState();
	}
	
}
