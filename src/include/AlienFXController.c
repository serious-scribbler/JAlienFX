#include "de_pniehus_jalienfx_AlienFXController.h"
#include "LFX2.h"
#include <stdio.h>
#include <conio.h>

#define NULL_POINTER_ERROR				7 //NULL POINTER

//Sends an Exception to java
void throwException(int type, JNIEnv *env){
  jclass Exception = (*env)->FindClass(env, "java/lang/Exception");
  switch(type){
    case NULL_POINTER_ERROR:
      (*env)->ThrowNew(env, Exception,"JAlienFX native Exception: NULL Pointer Exception!");
      break;
    case LFX_ERROR_NOINIT:
      (*env)->ThrowNew(env, Exception,"JAlienFX native Exception: AlienFX has not been initialized yet!");
      break;
    case LFX_ERROR_NODEVS:
      (*env)->ThrowNew(env, Exception,"JAlienFX native Exception: This device doesn't exist!");
      break;
    case LFX_ERROR_NOLIGHTS:
      (*env)->ThrowNew(env, Exception, "JAlienFX native Exception: This light doesn't exist!");
      break;
    default:
      (*env)->ThrowNew(env, Exception,"JAlienFX native Exception: Unspecified error!");
      break;
  }
}

//Returns the number of AlienFX compatible devices connected to the system
JNIEXPORT jint JNICALL Java_de_pniehus_jalienfx_AlienFXController_getDeviceCount(JNIEnv *env, jobject obj){
  jint result;
  unsigned int lfxDeviceNumber = 0;
	int success = LFX_GetNumDevices(&lfxDeviceNumber);
  if(success != LFX_SUCCESS) throwException(success, env);
	result = (int) lfxDeviceNumber;
  return result;
}

//Returns the number of AlienFX zones for the selected device
JNIEXPORT jint JNICALL Java_de_pniehus_jalienfx_AlienFXController_getZCount(JNIEnv *env, jobject obj, jint deviceID){
  jint result;
  if(deviceID == NULL) throwException(NULL_POINTER_ERROR, env);
  unsigned int numberOfZones = 0;
	int success = LFX_GetNumLights(deviceID, &numberOfZones);
  if(success != LFX_SUCCESS) throwException(success, env);
  result = (int) numberOfZones;
  return result;
}



JNIEXPORT jstring JNICALL Java_de_pniehus_jalienfx_AlienFXController_getDevDescription(JNIEnv *env, jobject obj, jint deviceID){
  
}

JNIEXPORT jstring JNICALL Java_de_pniehus_jalienfx_AlienFXController_getZDescription(JNIEnv *env, jobject obj, jint deviceID, jint zone){
  unsigned int descriptionLength = 120;
	char *result = malloc(descriptionLength*sizeof(char));
	int success = LFX_GetLightDescription(deviceID, zone, result, descriptionLength);
  if(success != LFX_SUCCESS) throwException(success, env);
  jstring out = (*env)->NewStringUTF(env, result);
  free(result);//--------------------------------------------------------------Could lead to problems
  return (*env)->NewStringUTF(env, result);
}

JNIEXPORT jintArray JNICALL Java_de_pniehus_jalienfx_AlienFXController_getRGBA(JNIEnv *env, jobject obj, jint deviceID, jint zone){
  jint rgba[] = {0, 0, 0, 0};
  LFX_COLOR *color = malloc(sizeof(LFX_COLOR));
	int success = LFX_GetLightColor(deviceID, zone, color);
  if(success != LFX_SUCCESS) throwException(success, env);
  rgba[0] = (int) color->red;
  rgba[1] = (int) color->green;
  rgba[2] = (int) color->blue;
  rgba[3] = (int)color->brightness;
  free(color);
  jintArray output = (*env)->NewIntArray(env, 4);
  if (output == NULL) return NULL;
  (*env)->SetIntArrayRegion(env, output, 0 , 4, rgba);
  return output;
}

JNIEXPORT void JNICALL Java_de_pniehus_jalienfx_AlienFXController_init(JNIEnv *env, jobject obj){
  LFX_Initialize();
}

JNIEXPORT void JNICALL Java_de_pniehus_jalienfx_AlienFXController_updateLighting(JNIEnv *env, jobject obj){
  int success = LFX_Update();
  if(success != LFX_SUCCESS) throwException(success, env);
}

JNIEXPORT void JNICALL Java_de_pniehus_jalienfx_AlienFXController_release(JNIEnv *env, jobject obj){
  int success =LFX_Release();
  if(success != LFX_SUCCESS) throwException(success, env);
}

JNIEXPORT void JNICALL Java_de_pniehus_jalienfx_AlienFXController_resetLighting(JNIEnv *env, jobject obj){
  int success = LFX_Reset();
  if(success != LFX_SUCCESS) throwException(success, env);
}

JNIEXPORT void JNICALL Java_de_pniehus_jalienfx_AlienFXController_setRGBA(JNIEnv *env, jobject obj, jint deviceID, jint zone, jint red, jint green, jint blue, jint brightness){
  LFX_COLOR *color = malloc(sizeof(LFX_COLOR));
  color->red = (unsigned char) red;
  color->green = (unsigned char) green;
  color->blue = (unsigned char) blue;
  color->brightness = (unsigned char) brightness;
  int success = LFX_SetLightColor(deviceID, zone, color);
  free(color);
}
