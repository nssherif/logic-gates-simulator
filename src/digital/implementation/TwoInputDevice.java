package digital.implementation;

import digital.interfaces.PortInterface;

import digital.interfaces.Value;

/**
 * Represents a two input and a 1 output device.
 * 
 * @author Negib Sherif
 *
 */

public abstract class TwoInputDevice extends Device {
	/** 
	 * Placeholder for a port of the device
	 */
	private PortInterface port;
	
	/** 
	 * Placeholder for a output value of the device
	 */
	private Value outputValue;
	
	/** 
	 * Constructor for a two input device. Creates 1 output port 
	 * and 2 input ports and gives a name to the device.
	 */
	public TwoInputDevice(String deviceName) {
		super(deviceName);
		
		port = new Port(true); //isOutputPort
		this.getPorts().add(port); 
		
		port = new Port(false); //isInputPort
		this.getPorts().add(port); 
		
		port = new Port(false); //isInputPort
		this.getPorts().add(port); 
	}
	
	/** 
	 * Update function updates the output based on the 
	 * truth table of a the two input gate.
	 */
	public abstract boolean update();
	
	/** 
	 * Clock message is ignored
	 */
	@Override
	public void clock() {
		//ignores clock message
	};
	
	/** 
	 * Function that computes if output has changed
	 * 
	 * @param both input values of the device
	 * @return boolean: true if output changed, false if not
	 */
	public boolean outputChanged (Value inputValue1, Value inputValue2) {
		if ((inputValue1 != outputValue || inputValue2 != outputValue) && (outputValue != null)) {
			return true;
		}
		else {
			return false;
		}
	}
}
