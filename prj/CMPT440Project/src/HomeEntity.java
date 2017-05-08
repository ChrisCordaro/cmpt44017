
public class HomeEntity extends Entity{
	private Game game;
	
	public HomeEntity(Game game, String ref, int x, int y) {
		super(ref, x, y);
		this.game = game;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void collidedWith(Entity other) {
		// TODO Auto-generated method stub

		
	}

}
