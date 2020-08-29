package sovereignstudios.helhalla.input;

public interface InputSource {
    /**
     * Some inputs are continuous (like movement keys or joystick position),
     * but some are discrete (like attacking).
     * Since one press of the attack key/button should correspond with one attack rather than continuous auto-attacking,
     * the input should only be read as the attack button being pressed a single time.
     * Thus, this method will have the side effect of resetting all discrete input events.
     * For this reason, make sure you only read the input once per frame,
     * or you risk losing inputs like that.
     * 
     * Furthermore, if you've been ignoring the input for a while for whatever reason,
     * make sure you read it once to clear discrete events so that the player
     * doesn't e.g. accidentally attack after coming back from a pause
     * because they accidentally pressed the attack button when they put down the controller two hours ago
     * (or whatever).
     */
    InputState readInput();
}
