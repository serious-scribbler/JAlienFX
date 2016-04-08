package de.pniehus.jalienfx;

public class AlienFXController {
	public AlienFXController() throws Exception{
		if(!System.getProperty("os.name").contains("Windows")) throw new Exception("This is only available for windows!");
		System.loadLibrary("alienfxinterface");
	}
	
	//Returns the number of AlienFX devices connected to the System
	private native int getDeviceCount();
	
	//Returns the number of AlienFX zones for the selected device
	private native int getZCount(int deviceID);
	
	//Returns the description for the selected device
	private native String getDevDescription(int deviceID);
	
	//Returns the description for the selected Zone
	private native String getZDescription(int deviceID, int zoneID);
	
	//Returns the color and brightness of the selected zone as RGBA (alpha corresponds brightness)
	private native int[] getRGBA(int deviceID, int zoneID);
	
	//Sets the color and brightness of the selected zone
	private native void setRGBA(int deviceID, int zoneID, int red, int green, int blue, int brightness);
	
	//Inits AlienFX
	private native void init();
	
	/**
	 * Updates the AlienFX lighting
	 */
	private native void updateLighting();
	
	//Releases the AlienFX API
	public native void release();
	
	/**
	 * Resets lighting
	 */
	public native void resetLighting();
	
}