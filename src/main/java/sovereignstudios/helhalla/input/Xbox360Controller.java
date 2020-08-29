package sovereignstudios.helhalla.input;

public final class Xbox360Controller {
	public static final String XBOX360_WIRELESS_RECEIVER = "Xbox 360 Wireless Receiver";
	
	public static final int BUTTON_A = 0;
	public static final int BUTTON_B = 1;
	public static final int BUTTON_X = 2;
	public static final int BUTTON_Y = 3;
	public static final int BUTTON_LEFT_BUMPER = 4;
	public static final int BUTTON_RIGHT_BUMPER = 5;
	public static final int BUTTON_BACK = 6;
	public static final int BUTTON_START = 7;
	public static final int BUTTON_XBOX = 8;
	/** Triggered when you press down on the joystick, not when it's moved. */
	public static final int BUTTON_LEFT_JOYSTICK = 9;
	public static final int BUTTON_RIGHT_JOYSTICK = 10;
	public static final int BUTTON_DPAD_LEFT = 11;
	public static final int BUTTON_DPAD_RIGHT = 12;
	public static final int BUTTON_DPAD_UP = 13;
	public static final int BUTTON_DPAD_DOWN = 14;
	
	public static final int AXIS_LEFT_JOYSTICK_X = 0;
	public static final int AXIS_LEFT_JOYSTICK_Y = 1;
	public static final int AXIS_LEFT_TRIGGER = 2;
	public static final int AXIS_RIGHT_JOYSTICK_X = 3;
	public static final int AXIS_RIGHT_JOYSTICK_Y = 4;
	public static final int AXIS_RIGHT_TRIGGER = 5;
	
	public static final float AXIS_PRESS_THRESHOLD = 0.2f;
	
	private Xbox360Controller() {}
}
