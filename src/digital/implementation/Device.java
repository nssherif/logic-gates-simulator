package digital.implementation;

import java.util.ArrayList;
import java.util.List;

import digital.interfaces.DeviceInterface;
import digital.interfaces.PortInterface;
import digital.interfaces.Value;
import util.Assert;

/**
 * Represents a device. A device could be of 5 different types outline in assignment documentation.
 * A device can be (InputDevice, NotGate, OrGate, AndGate, or a DFlipFlip)
 * 
 * @author Negib Sherif
 */
public abstract class Device implements DeviceInterface{	
	
	/** 
	 * Variable clock that keeps track of the clock iteration.
	 */
	int clock = 0;
	
	/** 
	 * The name of this device
	 */
	private String deviceName;
	
	/** Every device is connected to a set of ports.
	 * At most one of these can be an output port.
	 * 
	 * Credits to Theodore Norvell for this code.
	 */
	private List<PortInterface> ports = new ArrayList<PortInterface>() ;
	
	/** 
	 * Device constructor that creates a device with a name.
	 */
	Device(String deviceName) {
		this.deviceName = deviceName;
	}

	/** Gets the name of this device 
	 * 
	 * return device name
	 * */
	@Override
	public String getName() {
		return deviceName;
	};
	
	/** 
	 * Returns how many ports this device has
	 * 
	 * return number of ports
	 * */
	@Override
	public int numberOfPorts() {
		return ports.size(); 
		
	};
	
	/** Get the given port.
	 * <p>Precondition: 0 <= portNumber < numberOfPorts() 
	 * @param portNumber
	 * @return The port
	 */
	@Override
	public PortInterface getPort( int portNumber ) {
		Assert.check(portNumber>=0 && portNumber < ports.size(), "Precondition not met: Port Number is not greater than or equal 0 or less than number of ports ");
		return ports.get(portNumber);
	};
	

	/** 
	 * Gets the ports list.
	 * @return ports list
	 */
	public List<PortInterface> getPorts(){
		return this.ports;
	}
		
}
