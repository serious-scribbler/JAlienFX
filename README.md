# JAlienFX
##What can JAlienFX do?
* Get current AlienFX color for every single zone (separatly)
* Set the AlienFX color for every sing zone (separatly)
* Get the number of AlienFX zones and AlienFX devices
* Get the description for every lighting zone
* Get the description for every device
* Reset lighting

##Requirements
* Java JDK 8
* An AlienFX compatible device
* Windows
* The AlienFX driver

##How to set up JAlienFX?
###On Windows 64bit
1. Go to Windows/System32 and copy `LightFX.dll` to `LightFX64.dll`
2. Copy `JAlienFX.dll` to your user directory (%HOMEPATH%)
3. Add `JAlienFX.jar` to your buildpath
4. Add `-Djava.library.path=%HOMEPATH%` to your VM arguments
###On Windows 32bit (Not tested yet)
* Just leave step 1 out, everything else shoud be equal to 64bit Windows

##How to properly start my application when i compiled it to a .jar?
1. Create a .bat-file and insert `java -jar yourprogram.jar -Djava.library.path=%HOMEPATH%`
2. Run the .bat-file

##Common mistakes:
###An Exception with a text like `link error - can not find depending libraries` gets thrown:
Make sure you have LightFX.dll renamed on a 64bit Windows
###An Exception like `link error: JAlienFX.dll could not be found` gets thrown
* Make sure your JAlienFX.jar is in the right place
* Make sure you added `-Djava.library.path=%HOMEPATH%` to your VM arguments

