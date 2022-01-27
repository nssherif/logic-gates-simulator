package digital.implementation;

import digital.interfaces.PortInterface;

import digital.interfaces.Value;

/**  
 * Represents an AndGate device that has one output 
 * and 1 or 2 input ports.
 * Updates values of output based on truth table for AndGate.
 * 
 * @author Negib Sherif
 *
 **/
public class AndGate extends TwoInputDevice {
	
	/** 
	 * Constructor for a DFlipFlop, inherits
	 * functionality from abstract class. 
	 */
	public AndGate(String deviceName) {
		super(deviceName);
	}
	
	/** 
	 * Update function updates the output based on the 
	 * truth table of a NOT gate.
	 */
	@Override
	public boolean update() {
		PortInterface inputPort2 = this.getPorts().get(2);
		PortInterface inputPort1 = this.getPorts().get(1);
		PortInterface outputPort = this.getPorts().get(0);
		
		Value inputValue1 = inputPort1.getValue();
		Value inputValue2 = inputPort2.getValue();
		
		if (inputValue1 == Value.FALSE || inputValue2 == Value.FALSE) {
			outputPort.setValue(Value.FALSE);
			return outputChanged(inputValue1, inputValue2);
		}
		else {
			if (inputValue1 == Value.UNKNOWN || inputValue2 == Value.UNKNOWN) {
				outputPort.setValue(Value.UNKNOWN);
				return outputChanged(inputValue1, inputValue2);
			}
			else {
				outputPort.setValue(Value.TRUE);
				return outputChanged(inputValue1, inputValue2);
			}
		}
	}
}
