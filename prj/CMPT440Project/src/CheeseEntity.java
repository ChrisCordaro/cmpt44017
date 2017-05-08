
public class CheeseEntity extends Entity {
	
	private Game game;

	public CheeseEntity(Game game, String ref, int x, int y) {
		super(ref, x, y);
		this.game = game;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void collidedWith(Entity other) {
		// TODO Auto-generated method stub
		if (other instanceof ShipEntity) {
			game.notifyCheeseGrab();
		}
	}

}
