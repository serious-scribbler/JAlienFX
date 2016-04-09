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

##How to compile the c code into the `JAlienFX.dll`?
###Preparation
1. Install MinGW 32/64bit and add its bin directory to your environment variables
2. Copy `jni.h` and `jni_md.h` from  `<Path to your JDK>\includes\` and `<Path to your JDK>\includes\win32` directory into your `src\includes` directory
3. Copy `LFX2.h`, `LFXConfigurator.h`and `LFXDecl.h` from `<Pogram directory>\Alienware\Command Center\AlienFX SDK\Unmanaged\includes` into your `src\includes` directory
4. Copy `LightFX.dll` and `LightFXConfigurator32.dll` / `LightFXConfigurator64.dll` into `src\includes` directory. These files can be found add `<Pogram directory>\Alienware\Command Center\AlienFX SDK\Unmanaged\dll` + `\x64` or `\x86` depending on what you want to compile the shared library for

###Compile:

####For 64bit:
1. Navigate into yout `src\includes` directory open a terminal and type `x86_64-w64-mingw32-gcc AlienFXController.c -shared -L<PATH TO YOUR INCLUDE FOLDER> -lLightFX -lLightFXConfigurator64 -std=c99 -mwindows -o JAlienFX.dll`
2. You should now end up with a couple of warnings, no errors and a compiled JAlienFX.dll

####For 32bit:
1. Navigate into yout `src\includes` directory open a terminal and type `
gcc AlienFXController.c -shared -L<PATH TO YOUR INCLUDE FOLDER> -lLightFX -lLightFXConfigurator32 -std=c99 -mwindows -o JAlienFX.dll'
2. You should now endup without warnings or errors and a compiled JAlienFX.dll
