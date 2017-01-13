package de.pniehus.jalienfx;
import java.awt.Color;
import java.util.regex.PatternSyntaxException;

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
 * This class hold all information for an AlienFX light zone.
 * @author Phil Niehus
 *
 */
public class FXZone {
	
	private final FXDevice parentDevice;
	private final int zoneID;
	private final String zoneDescription;
	
	/**
	 * Constructs a FXZone with the give parent device and zoneID
	 * @param parentDevice
	 * @param zoneID
	 */
	public FXZone(FXDevice parentDevice, int zoneID){
		this.parentDevice = parentDevice;
		this.zoneID = zoneID;
		this.zoneDescription = parentDevice.getController().getZoneDescription(parentDevice.getDeviceID(), zoneID);
	}
	
	/**
	 * Sets the zones color to the given one. The alpha channel represents the brightness
	 * @param color
	 */
	public void setColor(Color color){
		try {
			parentDevice.getController().setZoneColor(parentDevice.getDeviceID(), zoneID, color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
		} catch (Exception e) {
			// Impossible to happen
			e.printStackTrace();
		}
	}
	
	/**
	 * Returns the parent device of this zone
	 * @return
	 */
	public FXDevice getParentDevice() {
		return parentDevice;
	}
	
	/**
	 * Returns the id of this zone
	 * @return
	 */
	public int getZoneID() {
		return zoneID;
	}
	
	/**
	 * Returns the description of this zone
	 * @return
	 */
	public String getZoneDescription() {
		return zoneDescription;
	}
}
