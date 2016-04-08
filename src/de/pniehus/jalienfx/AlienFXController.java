package de.pniehus.jalienfx;

public class AlienFXController {
	private boolean captured = false;
	public AlienFXController() throws Exception{
		if(!System.getProperty("os.name").contains("Windows")) throw new Exception("This is only available for windows!");
		System.loadLibrary("JAlienFX");
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
		if(captured) return;
		captured = true;
		init();
	}
}