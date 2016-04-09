# JAlienFX
**JAlienFX is licensed under [GNU LGPL v3](https://www.gnu.org/licenses/lgpl.txt)!**<br>
![GNU GPL logo]( https://www.gnu.org/graphics/lgplv3-147x51.png "The JAlienFX API is licensed under GNU LGPL v3")

####JAlienFX has been successfully tested on the following devices:
* Alienware13
* Roccat IskuFX

##What can JAlienFX do?

> AlienFX allows you to call the Dell AlienFX API from Java

###Current features:
* Get current color of every single AlienFX zone (separatly)
* Set the color for every single AlienFX zone (separatly)
* Get the number of AlienFX zones and AlienFX devices
* Get the description for every single lighting zone
* Get the description for every single device
* Reset lighting

##Requirements
* Java JDK 8
* An AlienFX compatible device
* Windows
* The AlienFX driver

##How to set up JAlienFX?
###On Windows 64bit
1. Go to Windows/System32 and copy `LightFX.dll` to `LightFX64.dll`
2. Copy `JAlienFX.dll` `Windows\System32\`
3. Reboot your computer
4. Add `JAlienFX.jar` to your buildpath

###On Windows 32bit (Not tested yet)
* Just leave step 1 out, everything else shoud be equal to 64bit Windows

##Common mistakes:
###An Exception with a text like `link error - can not find depending libraries` gets thrown:
Make sure you have LightFX.dll renamed on a 64bit Windows
###An Exception like `link error: JAlienFX.dll could not be found` gets thrown
* Make sure your JAlienFX.dll is in System32 directory
* Make sure you restarted your computer after copying JAlienFX.dll to your System32 directory

##How to compile the c code into the `JAlienFX.dll`?
###Preparation
1. Install MinGW 32/64bit and add its bin directory to your environment variables
2. Copy `jni.h` and `jni_md.h` from  `<Path to your JDK>\includes\` and `<Path to your JDK>\includes\win32` directory into your `src\includes` directory
3. Copy `LFX2.h`, `LFXConfigurator.h`and `LFXDecl.h` from `<Pogram directory>\Alienware\Command Center\AlienFX SDK\Unmanaged\includes` into your `src\includes` directory
4. Copy `LightFX.dll` and `LightFXConfigurator32.dll` or `LightFXConfigurator64.dll` into `src\includes` directory. These files can be found add `<Pogram directory>\Alienware\Command Center\AlienFX SDK\Unmanaged\dll` + `\x64` or `\x86` depending on what you want to compile the shared library for

###Compile:

####For 64bit:
1. Navigate into your `src\includes` directory open a terminal and type `x86_64-w64-mingw32-gcc AlienFXController.c -shared -L<PATH TO YOUR INCLUDE FOLDER> -lLightFX -lLightFXConfigurator64 -std=c99 -mwindows -o JAlienFX.dll`
2. You should now end up without any warnings or errors and a compiled JAlienFX.dll

####For 32bit:
1. Navigate into your `src\includes` directory open a terminal and type `gcc AlienFXController.c -shared -L<PATH TO YOUR INCLUDE FOLDER> -lLightFX -lLightFXConfigurator32 -std=c99 -mwindows -o JAlienFX.dll`
2. You should now end up without any warnings or errors and a compiled JAlienFX.dll

##Where can i find the API docs for JAlienFX?
**You can find them at [jafx.pniehus.de](http://jafx.pniehus.de/)**
