package digital.implementation;

import digital.interfaces.PortInterface;
import digital.interfaces.Value;


/**  
 * Represents an DFlipFlop device that has one output and one input.
 * In response to the clock edge the device outputs the input.
 *
 * 
 * @author Negib Sherif
 *
 **/

public class DFlipFlop extends Device{
	
	/** 
	 * Variable clock that keeps track of the clock iteration.
	 */
	int clock = 0;
	
	/** 
	 * Placeholder for a port of the device
	 */
	private PortInterface port;
	
	/** 
	 * Constructor for a DFlipFlop, creates an output 
	 * and input port and gives a name to the device.
	 */
	public DFlipFlop(String deviceName) {
		super(deviceName);
		
		port = new Port(true); //isOutputPort
		this.getPorts().add(port); 
		
		port = new Port(false); //isInputPort
		this.getPorts().add(port); 
	}
	
	/** 
	 * Update functions have no effect on DFlipFlops
	 */
	@Override
	public boolean update() {
		return false;
	}
	
	/** 
	 * Updates the output in response to a clock edge
	 */
	@Override
	public void clock() {
		PortInterface outputPort = this.getPort(0);
		Value inputValue = this.getPort(1).getValue();
		outputPort.setValue(inputValue);
	};
}
