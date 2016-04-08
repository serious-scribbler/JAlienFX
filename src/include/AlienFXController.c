#include "de_pniehus_jalienfx_AlienFXController.h"
#include "LFX2.h"
#include <stdio.h>
#include <conio.h>

#define NULL_POINTER_ERROR				7 //NULL POINTER
//Returns the number of AlienFX compatible devices connected to the system
JNIEXPORT jint JNICALL Java_de_pniehus_jalienfx_AlienFXController_getDeviceCount(JNIEnv *env, jobject obj){
  jint result;
  unsigned int lfxDeviceNumber = 0;
	int success = LFX_GetNumDevices(&lfxDeviceNumber);
  throwException(success, env);
	result = (int) lfxDeviceNumber;
  return result;
}

//Returns the number of AlienFX zones for the selected device
JNIEXPORT jint JNICALL Java_de_pniehus_jalienfx_AlienFXController_getZCount(JNIEnv *env, jobject obj, jint deviceID){
  jint result;
  if(deviceID == NULL) throwException(NULL_POINTER_ERROR, env);
  unsigned int numberOfZones = 0;
	int success = LFX_GetNumLights(deviceID, &numberOfZones);
  if(success != LFX_SUCCESS) throwException(sucess, env);
  result = (int) numberOfZones;
  return result;
}

//Sends an Exception to java
void throwException(int type, JNIEnv *env){
  jclass Exception = env->FindClass("java/lang/Exception");
  switch(type){
    case NULL_POINTER_ERROR:
      env->ThrowNew(Exception,"JAlienFX native Exception: NULL Pointer Exception!");
      break;
    case LFX_ERROR_NOINIT:
      env->ThrowNew(Exception,"JAlienFX native Exception: AlienFX has not been initialized yet!");
      break;
    case LFX_ERROR_NODEVS:
      env->ThrowNew(Exception,"JAlienFX native Exception: This device doesn't exist!");
      break;
    case LFX_ERROR_NOLIGHTS:
      env->ThrowNew(Exception, "JAlienFX native Exception: This light doesn't exist!");
      break;
    default:
      env->ThrowNew(Exception,"JAlienFX native Exception: Unspecified error!");
      break;
  }
}

JNIEXPORT jstring JNICALL Java_de_pniehus_jalienfx_AlienFXController_getDevDescription(JNIEnv *env, jobject obj, jint deviceID){

}

JNIEXPORT jstring JNICALL Java_de_pniehus_jalienfx_AlienFXController_getZDescription(JNIEnv *env, jobject obj, jint deviceID, jint zone){

}

JNIEXPORT jintArray JNICALL Java_de_pniehus_jalienfx_AlienFXController_getRGBA(JNIEnv *env, jobject obj, jint deviceID, jint zone){

}

JNIEXPORT void JNICALL Java_de_pniehus_jalienfx_AlienFXController_setRGBA(JNIEnv *env, jobject obj, jint deviceID, jint zone, jint red, jint green, jint blue, jint brightness){

}
