package digital.implementation;

import util.Assert;
import digital.interfaces.DeviceInterface;
import digital.interfaces.InputDeviceInterface;
import digital.interfaces.NetInterface;

/** A factory class for various types of devices and nets.
 * <p>This is not a public class, it is intended to be used
 * by the Network class, which will take care of adding the
 * devices and nets to a network.
 * 
 * @author Theodore Norvell
 *
 */
class DigitalFactory {


	public NetInterface makeNewNet(String name) {
		return new Net( name ) ;
	}

	public InputDeviceInterface makeNewInput(String name) {
		Assert.toBeDone() ; return null ;
	}

	public DeviceInterface makeNewAndGate(String name) {
		Assert.toBeDone() ; return null ;
	}

	public DeviceInterface makeNewNotGate(String name) {
		Assert.toBeDone() ; return null ;
	}

	public DeviceInterface makeNewOrGate(String name) {
		Assert.toBeDone() ; return null ;
	}

	public DeviceInterface makeNewDFlipFlop(String name) {
		Assert.toBeDone() ; return null ;
	}
}