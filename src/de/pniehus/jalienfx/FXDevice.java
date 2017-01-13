package de.pniehus.jalienfx;

import java.awt.Color;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/*

Copyright (C) 2017 Phil Niehus

The JAlienFX API is free software: you can redistribute it and/or modify
it under the terms of the GNU Lesser General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

The CutterAPI is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.

 */

/**
 * This class holds all information about an AlienFX device and its zones.
 * It can be used to access all zones of the device.
 * @author Phil Niehus
 *
 */
public class FXDevice {
	
	private final AlienFXController controller;
	private final int deviceID;
	private final String deviceDescription;
	private Map<String, FXZone> zones = new HashMap<String, FXZone>();
	
	/**
	 * Constructs a FXDevice with the given deviceID and the given {@see AlienFXController}
	 * @param controller
	 * @param deviceID
	 */
	public FXDevice(AlienFXController controller, int deviceID){
		this.controller = controller;
		this.deviceID = deviceID;
		this.deviceDescription = controller.getDeviceDescription(deviceID);
		
		for(int i = 0; i < controller.getZoneCount(deviceID); i++){
			zones.put(controller.getZoneDescription(deviceID, i), new FXZone(this, i));
		}
		
	}
	
	/**
	 * Returns the AlienFXController that controls this device
	 * @return
	 */
	public AlienFXController getController(){
		return controller;
	}
	
	/**
	 * Returns the ID of this FXDevice
	 * @return
	 */
	public int getDeviceID(){
		return deviceID;
	}
	
	/**
	 * Returns the description of this FXDevice
	 * @return
	 */
	public String getDescription(){
		return deviceDescription;
	}
	
	/**
	 * Returns the zone with the give zoneDescription
	 * @param zoneDescription
	 * @return
	 */
	public FXZone getZone(String zoneDescription){
		return zones.get(zoneDescription);
	}
	
	/**
	 * Returns a Map with all {@see FXZone} of this device with their description as key
	 * @return
	 */
	public Map<String, FXZone> getZoneMap(){
		return zones;
	}
	
	/**
	 * Sets all FXZones of this device to the given color. The alpha channel represents the brightness
	 * @param color
	 */
	public void setDeviceColor(Color color){
		Iterator<Entry<String, FXZone>> it = zones.entrySet().iterator();
		while(it.hasNext()){
			FXZone z = it.next().getValue();
			z.setColor(color);
		}
	}
}
