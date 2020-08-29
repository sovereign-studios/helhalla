package sovereignstudios.helhalla.input;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;

public final class KeyboardInputSource extends InputAdapter implements InputSource {
    /** Left and down are negative, right and up are positive. */
    private int x = 0, y = 0;
    private boolean attacking = false;

    @Override
    public boolean keyDown(final int keycode) {
        switch (keycode) {
            case Keys.W:
            case Keys.UP:
                if (y < 0) {
                    y = 0;
                } else if (y == 0) {
                    y = 1;
                }
                break;

            case Keys.S:
            case Keys.DOWN:
                if (y > 0) {
                    y = 0;
                } else if (y == 0) {
                    y = -1;
                }
                break;

            case Keys.A:
            case Keys.LEFT:
                if (x > 0) {
                    x = 0;
                } else if (x == 0) {
                    x = -1;
                }
                break;

            case Keys.D:
            case Keys.RIGHT:
                if (x < 0) {
                    x = 0;
                } else if (x == 0) {
                    x = 1;
                }
                break;

            case Keys.SPACE:
                this.attacking = true;
        }

        return false;
    }

    @Override
    public boolean keyUp(final int keycode) {
        switch (keycode) {
            case Keys.W:
            case Keys.UP:
                if (y > 0) {
                    y = 0;
                } else if (y == 0) {
                    y = -1;
                }
                break;

            case Keys.S:
            case Keys.DOWN:
                if (y < 0) {
                    y = 0;
                } else if (y == 0) {
                    y = 1;
                }
                break;

            case Keys.A:
            case Keys.LEFT:
                if (x < 0) {
                    x = 0;
                } else if (x == 0) {
                    x = 1;
                }
                break;

            case Keys.D:
            case Keys.RIGHT:
                if (x > 0) {
                    x = 0;
                } else if (x == 0) {
                    x = -1;
                }
                break;
        }

        return false;
    }

    @Override
    public InputState readInput() {
        // Either the button is pressed, or it isn't, so the magnitude is always either 1 or 0.
        final float magnitude = Math.max(Math.abs(x), Math.abs(y));
        final float orientation = (float) Math.atan2(y, x);
        final boolean attacking = this.attacking;

        // 1 press = 1 attack. We don't do auto-attacking. Button mashing for the win.
        this.attacking = false;

        return new InputState() {
            @Override
            public float getOrientation() {
                return orientation;
            }

            @Override
            public float getAcceleration() {
                return magnitude;
            }

            @Override
            public boolean isAttacking() {
                return attacking;
            }
        };
    }
}
