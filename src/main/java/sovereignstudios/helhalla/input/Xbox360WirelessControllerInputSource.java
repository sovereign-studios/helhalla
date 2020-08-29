package sovereignstudios.helhalla.input;

import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.ControllerAdapter;
import static sovereignstudios.helhalla.input.Xbox360Controller.*;

public final class Xbox360WirelessControllerInputSource extends ControllerAdapter implements InputSource {
	/**
	 * Joysticks are a bit sticky, so when the joystick is released it doesn't return to exactly 0.0f.
	 * This is the minimum magnitude the joystick must be pushed to consider it being pushed at all.
	 * This applies to the total magnitude of the joystick, not the magnitude of either individual axis.
	 * 
	 * This value is based on my own controller. The highest number I managed to get it to stick at was ~0.2,
	 * but it is important that the player *never* gets stuck moving after the joystick is released,
	 * so I made it a bit higher than that.
	 * There are certainly controllers both better and worse than mine,
	 * so this value probably ought to be configurable.
	 */
	private static final float JOYSTICK_PUSH_THRESHOLD = 0.25f;
	
	private final Controller controller;
	private MutableInputState inputState = new MutableInputState();
	
	public Xbox360WirelessControllerInputSource(final Controller controller) {
		if (!controller.getName().equals(XBOX360_WIRELESS_RECEIVER)) {
			throw new IllegalArgumentException("Controller was not a valid known Xbox360 controller.");
		}
		
		this.controller = controller;
	}
	
	@Override
	public boolean buttonDown(final Controller controller, final int buttonCode) {
		System.out.println("Button: " + buttonCode);
		switch (buttonCode) {
		case BUTTON_A:
			inputState.setAttacking();
			break;
		}
		return false;
	}
	
	@Override
	public final InputState readInput() {
		final MutableInputState state = inputState;
		
		// For joysticks, up and left are negative. For us, down and left are negative.
		// The y input must be inverted.
		final float x = controller.getAxis(AXIS_LEFT_JOYSTICK_X);
		final float y = -controller.getAxis(AXIS_LEFT_JOYSTICK_Y);
		final float magnitude = Math.min(1.0f, Math.abs(x) + Math.abs(y));
		final float orientation = (float) Math.atan2(y, x);

		if (magnitude > JOYSTICK_PUSH_THRESHOLD) {
			state.setAcceleration(magnitude);
		}
		state.setOrientation(orientation);
		
		inputState = new MutableInputState();
		return state;
	}
}
