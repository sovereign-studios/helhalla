package sovereignstudios.helhalla.input;

public interface InputState {
    /** 
     * The orientation of the player relative to the world, in radians. 
     * 
     * With keyboard input, this will always be up, down, left, right, or a diagonal;
     * with a joystick, this can be any orientation.
     */
    float getOrientation();

    /**
     * What proportion (0.0-1.0) of the player's maximum acceleration are they trying to use.
     * 
     * This essentially corresponds with how hard the player is pressing the 'move' input.
     * In the case of a keyboard, the button is either pressed or not, so this will always be 0.0 or 1.0.
     * With a joystick, this corresponds with how far they are pushing the joystick as a proportion of its maximum range.
     */
    float getAcceleration();

    /**
     * Has the player pressed the 'attack' button.
     */
    boolean isAttacking();
}
