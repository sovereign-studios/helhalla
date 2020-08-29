package sovereignstudios.helhalla.input;

public class MutableInputState implements InputState {
	private float orientation = 0.0f;
	private float acceleration = 0.0f;
	private boolean attacking = false;

	@Override
	public float getOrientation() {
		return orientation;
	}

	@Override
	public float getAcceleration() {
		return acceleration;
	}

	@Override
	public boolean isAttacking() {
		return attacking;
	}
	
	public MutableInputState() {}
	
	public void setOrientation(final float orientation) {
		this.orientation = orientation;
	}
	
	public void setAcceleration(final float acceleration) {
		this.acceleration = acceleration;
	}
	
	public void setAttacking() {
		this.attacking = true;
	}
}
