package digital.implementation;


import digital.interfaces.InputDeviceInterface;
import digital.interfaces.PortInterface;
import digital.interfaces.Value;

/**  
 * Represents an input device that has one output and no inputs.
 * In response to the first clock edge the device outputs the 
 * first response, and in response to the second edge, 
 * outputs the second and so on.
 * 
 * @author Negib Sherif
 *
 **/

public class InputDevice extends Device implements InputDeviceInterface{
	
	/** 
	 * Placeholder for a port of the device
	 */
	private PortInterface port;
	
	/** 
	 * Hold the values given by the user when they call setInputSequence method
	 */
	private Value[] values;
	
	/** 
	 * Variable clock that keeps track of the clock iteration.
	 */
	int clock = 0;
	
	/** 
	 * Constructor for a Input String, creates 1 output 
	 * port and gives a name to the device.
	 */
	InputDevice(String deviceName) {
		super(deviceName);
		port = new Port(true);
		this.getPorts().add(port);
	}
	
	/** 
	 * Updates the output in response to a clock edge
	 */
	@Override
	public void clock() {
		PortInterface port = this.getPort(0);
		if (clock < values.length) {
			port.setValue(values[clock]);
			clock+=1;
		}
		else {
			port.setValue(Value.UNKNOWN);
		}
	};
	
	/** Update the output in response to asynchronous changes to
	 * its inputs.
	 * 
	 * @return True if the call results in a change to the value of any output port.
	 * Otherwise, if no output ports change value, false. 
	 */
	@Override
	public boolean update() {
		boolean changed = true;
		for (int i=1; i<values.length; ++i) {
			if (values[i] != values[i-1]) {
				changed = false;
			}
		}
		return changed ;
	};
	
	/** 
	 * Gets input sequence from parameter and stores it in a local variable
	 * 
	 * @param Values
	 */
	@Override
	public void setInputSequence( Value[] values ) {
		this.values = values;
	} ;

}
