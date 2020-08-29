package sovereignstudios.helhalla.input;

import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.ControllerAdapter;
import static sovereignstudios.helhalla.input.Xbox360Controller.XBOX360_WIRELESS_RECEIVER;

import java.util.ArrayList;
import java.util.List;

public final class ControllerListener extends ControllerAdapter {
	private final List<Controller> controllers = new ArrayList<>();
	
	@Override
	public void connected(final Controller controller) {
		System.err.println("Controller connected: " + controller.getName());
		
		// Only add controllers that we know how to handle.
		if (controller.getName().equals(XBOX360_WIRELESS_RECEIVER)) {
			controllers.add(controller);
		} else {
			System.err.println("Unknown controller type.");
		}
	}
	
	@Override
	public void disconnected(final Controller controller) {
		System.err.println("Controller disconnected: " + controller.getName());
		
		controllers.remove(controller);
	}
	
	public List<Controller> getControllers() {
		return controllers;
	}
}
