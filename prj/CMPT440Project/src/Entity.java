
import java.awt.Graphics;
import java.lang.String;
import java.util.Random;
import java.util.Set;
import java.util.HashSet;
import java.awt.Rectangle;
import java.util.Random;

/**
 * An entity represents any element that appears in the game. The
 * entity is responsible for resolving collisions and movement
 * based on a set of properties defined either by subclass or externally.
 * 
 * Note that doubles are used for positions. This may seem strange
 * given that pixels locations are integers. However, using double means
 * that an entity can move a partial pixel. It doesn't of course mean that
 * they will be display half way through a pixel but allows us not lose
 * accuracy as we move.
 * 
 * @author Kevin Glass
 */
public abstract class Entity {
	final Random r = new Random();
	final Set<Integer> s = new HashSet<>();
	
	/** The current x location of this entity */ 
	protected double x;
	/** The current y location of this entity */
	protected double y;
	/** The sprite that represents this entity */
	protected Sprite sprite;
	/** The current speed of this entity horizontally (pixels/sec) */
	protected double dx;
	/** The current speed of this entity vertically (pixels/sec) */
	protected double dy;
	/** The rectangle used for this entity during collisions  resolution */
	private Rectangle me = new Rectangle();
	/** The rectangle used for other entities during collision resolution */
	private Rectangle him = new Rectangle();
	
	private long movingInterval = 500;
	private long lastMove = 0;
	/**
	 * Construct a entity based on a sprite image and a location.
	 * 
	 * @param ref The reference to the image to be displayed for this entity
 	 * @param x The initial x location of this entity
	 * @param y The initial y location of this entity
	 */
	public Entity(String ref,int x,int y) {
		this.sprite = SpriteStore.get().getSprite(ref);
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Request that this entity move itself based on a certain ammount
	 * of time passing.
	 * 
	 * @param delta The ammount of time that has passed in milliseconds
	 */
	public void move(long delta) {
		// update the location of the entity based on move speeds
		x += (delta * dx) / 1000 ;
		y += (delta * dy) / 1000;
	}
	
	/**
	 * Set the horizontal speed of this entity
	 * 
	 * @param dx The horizontal speed of this entity (pixels/sec)
	 */
	public void setHorizontalMovement(double dx) {
		this.dx = dx;
	}

	/**
	 * Set the vertical speed of this entity
	 * 
	 * @param dx The vertical speed of this entity (pixels/sec)
	 */
	public void setVerticalMovement(double dy) {
		this.dy = dy;
	}
	
	/**
	 * Get the horizontal speed of this entity
	 * 
	 * @return The horizontal speed of this entity (pixels/sec)
	 */
	public double getHorizontalMovement() {
		return dx;
	}

	/**
	 * Get the vertical speed of this entity
	 * 
	 * @return The vertical speed of this entity (pixels/sec)
	 */
	public double getVerticalMovement() {
		return dy;
	}
	
	/**
	 * Draw this entity to the graphics context provided
	 * 
	 * @param g The graphics context on which to draw
	 */
	public void draw(Graphics g) {
		sprite.draw(g,(int) x,(int) y);
	}
	
	/**
	 * Do the logic associated with this entity. This method
	 * will be called periodically based on game events
	 */
	public void doLogic() {
	}
	
	/**
	 * Get the x location of this entity
	 * 
	 * @return The x location of this entity
	 */
	public int getX() {
		return (int) x;
	}

	/**
	 * Get the y location of this entity
	 * 
	 * @return The y location of this entity
	 */
	public int getY() {
		return (int) y;
	}
	
	/**
	 * Check if this entity collised with another.
	 * 
	 * @param other The other entity to check collision against
	 * @return True if the entities collide with each other
	 */
	public boolean collidesWith(Entity other) {
		me.setBounds((int) x,(int) y,sprite.getWidth(),sprite.getHeight());
		him.setBounds((int) other.x,(int) other.y,other.sprite.getWidth(),other.sprite.getHeight());

		return me.intersects(him);
	}
	
	/**
	 * Notification that this entity collided with another.
	 * 
	 * @param other The entity with which this entity collided.
	 */
	public abstract void collidedWith(Entity other);
	
	/**
	 * Places ALIENS in random spots within the game board
	 * Should check for duplicates
	 */
	public Set<Integer> generateCordinates(int x){
		for(int i = 0; i < 6; i++){
			while(true){
				int num = r.nextInt(6) + 1;
				if(s.contains(num) == false){
					s.add(num);
					break;
				}
			}
		}
		return s;
		
	}
	
	public void aiMove(){
		/*
		 * generates random number between 1 and 4 at a given interva;
		 * move the ship in the given direct, check if about to collide
		 * if about to collide then move in other direction
		 * 
		 */
		setHorizontalMovement(10);
		Random random = new Random();
		int result = random.nextInt(4-1)+1;
		if (System.currentTimeMillis() - lastMove < movingInterval) {
			return;
		}
		
		// if we waited long enough, create the shot entity, and record the time.
		lastMove = System.currentTimeMillis();
		if(result == 1){
			setHorizontalMovement(10);
			System.out.println("GOT ONE");
		}
		if(result == 2){
			System.out.println("GOT TWO");
		}
		if(result == 3){
			System.out.println("GOT THREE");
			
		}
		if(result == 4){
			System.out.println("GOT FOUR");
		}
	
	}
	
	/*public Set<Integer> getS(){
		return s;
	}*/
}