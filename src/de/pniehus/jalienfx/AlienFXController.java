package de.pniehus.jalienfx;

import java.awt.Color;

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
 * This class can be used to control the AlienFX lighting of AlienFX compatible windows devices.
 * It is recommended to access devices and zones with their individual  objects.
 * It therefore requires the JAlienFX.dll
 * @author Phil Niehus
 *
 */
public class AlienFXController {
	
	private boolean captured = false;
	private boolean runOnce = false;
	
	public AlienFXController() throws Exception{
		if(!System.getProperty("os.name").contains("Windows")) throw new Exception("This is only available for windows!");
		System.loadLibrary("JAlienFX");
	}
	
	/**
	 * Returns the number of AlienFX devices connected to the system
	 * @return
	 */
	public native int getDeviceCount();
	
	/**
	 * Returns the number of AlienFX zones the selected device owns
	 * @param deviceID The id of the device that will be adressed
	 * @return
	 */
	public int getZoneCount(int deviceID){
		return getZCount(deviceID);
	}
	private native int getZCount(int deviceID);
	
	/**
	 * Returns the description of the selected device as String
	 * @param deviceID The id of the device that will be adressed
	 * @return
	 */
	public String getDeviceDescription(int deviceID){
		return getDevDescription(deviceID);
	}
	private native String getDevDescription(int deviceID);
	
	/**
	 * Returns the description of the selected AlienFXZone as String
	 * @param deviceID The id of the device that will be adressed
	 * @param zoneID The AlienFX zone of the device that will be adressed
	 * @return
	 */
	public String getZoneDescription(int deviceID, int zoneID){
		return getZDescription(deviceID, zoneID);
	}
	
	private native String getZDescription(int deviceID, int zoneID);
	
	//Returns the color and brightness of the selected zone as RGBA (alpha corresponds brightness)
	private native int[] getRGBA(int deviceID, int zoneID);
	
	/**
	 * Returns the Color of the selected AlienFX zone as RGBA-Color (alpha corresponds brightness)
	 * @param deviceID The id of the device that will be adressed
	 * @param zoneID The AlienFX zone of the device that will be adressed
	 * @return The color of the selected zone
	 */
	public Color getZoneColor(int deviceID, int zoneID){
		int[] rgba = getRGBA(deviceID, zoneID);
		Color c = new Color(rgba[0], rgba[1], rgba[2], rgba[3]);
		return c;
	}
	
	/**
	 * Sets the color of the specified AlienFX zone
	 * @param deviceID The id of the device that will be adressed
	 * @param zoneID The AlienFX zone of the device that will be adressed
	 * @param red Red value (max 255)
	 * @param green Green value (max 255)
	 * @param blue Blue value (max 255)
	 * @param brightness Brightness level (max 255)
	 * @throws Exception When RGB/brighness levels out of bound
	 */
	public void setZoneColor(int deviceID, int zoneID, int red, int green, int blue, int brightness) throws Exception{
		if(!isInBound(red) || !isInBound(green) || !isInBound(blue) || !isInBound(brightness)) throw new Exception("RGB and/or brightness level out of bounds (0-255)");
		setRGBA(deviceID,zoneID, red, green, blue, brightness);
	}
	
	//Check for bound limits of rgba levels
	private boolean isInBound(int i){
		return (i > 255 || i < 0) ? false : true;
	}
	private native void setRGBA(int deviceID, int zoneID, int red, int green, int blue, int brightness);
	
	//Inits AlienFX
	private native void init();
	
	/**
	 * Updates the AlienFX lighting
	 */
	public native void updateLighting();
	
	
	private native void release();
	
	/**
	 * Releases AlienFX (The opposit of init)
	 */
	public void releaseAlienFX(){
		if(!captured) return;
		captured = false;
		release();
	}
	
	/**
	 * Resets lighting
	 */
	public native void resetLighting();
	
	/**
	 * Inits the AlienFX service
	 */
	public void initAlienFX(){
		if(!runOnce){
			runOnce = true;
			Runtime.getRuntime().addShutdownHook(new Thread(new Runnable(){
				@Override
				public void run() {
					releaseAlienFX();
				}
			}));
		}
		if(captured) return;
		captured = true;
		init();
	}
}