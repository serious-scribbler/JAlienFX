#include "LFX2.h"
#include <stdio.h>
#include <conio.h>
#include "de_pniehus_jalienfx_AlienFXController.h"

//Returns the number of AlienFX compatible devices connected to the system
JNIEXPORT jint JNICALL Java_de_pniehus_jalienfx_AlienFXController_getDeviceCount(JNIEnv *, jobject){
  jint result;
  unsigned int lfxDeviceNumber = 0;
	LFX_GetNumDevices(&lfxDeviceNumber);
	result = (int) lfxDeviceNumber;
  return result;
}

JNIEXPORT jint JNICALL Java_de_pniehus_jalienfx_AlienFXController_getZCount(JNIEnv *, jobject, jint){

}

JNIEXPORT jstring JNICALL Java_de_pniehus_jalienfx_AlienFXController_getDevDescription(JNIEnv *, jobject, jint){

}

JNIEXPORT jstring JNICALL Java_de_pniehus_jalienfx_AlienFXController_getZDescription(JNIEnv *, jobject, jint, jint){

}

JNIEXPORT jintArray JNICALL Java_de_pniehus_jalienfx_AlienFXController_getRGBA(JNIEnv *, jobject, jint, jint){

}

JNIEXPORT void JNICALL Java_de_pniehus_jalienfx_AlienFXController_setRGBA(JNIEnv *, jobject, jint, jint, jint, jint, jint, jint){

}
