package digital.implementation;

import digital.interfaces.PortInterface;
import digital.interfaces.Value;

/**  
 * Represents an NotGate device that has one output 
 * and 1 or 2 input ports.
 * Updates values of output based on truth table for NotGate.
 * 
 * @author Negib Sherif
 *
 **/

public class NotGate extends Device {
	
	/** 
	 * Placeholder for a port of the device
	 */
	private PortInterface port;
	
	/** 
	 * Constructor for a DFlipFlop, creates an output 
	 * and input device and gives a name to the device.
	 */
	public NotGate(String deviceName) {
		super(deviceName);
		
		port = new Port(true); //isOutputPort
		this.getPorts().add(port); 
		
		port = new Port(false); //isInputPort
		this.getPorts().add(port); 
	}
	
	/** 
	 * Update function updates the output based on the 
	 * truth table of a NOT gate.
	 */
	@Override
	public boolean update() {
		PortInterface inputPort = this.getPorts().get(1);
		PortInterface outputPort = this.getPorts().get(0);
		
		Value inputValue = inputPort.getValue();
		
		if (inputValue != Value.UNKNOWN) {
			if (inputValue == Value.TRUE) {
				outputPort.setValue(Value.FALSE);
			}
			else {
				outputPort.setValue(Value.TRUE);
			}
			return true;
		}
		else {
			outputPort.setValue(Value.UNKNOWN);
			return false;
		}
	}
	
	/** 
	 * Clock message is ignored
	 */
	@Override
	public void clock() {
		//ignores clock message
	};
}
