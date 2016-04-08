/* DO NOT EDIT THIS FILE - it is machine generated */
#include "jni.h"
/* Header for class de_pniehus_jalienfx_AlienFXController */

#ifndef _Included_de_pniehus_jalienfx_AlienFXController
#define _Included_de_pniehus_jalienfx_AlienFXController
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     de_pniehus_jalienfx_AlienFXController
 * Method:    getDeviceCount
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_de_pniehus_jalienfx_AlienFXController_getDeviceCount
  (JNIEnv *, jobject);

/*
 * Class:     de_pniehus_jalienfx_AlienFXController
 * Method:    getZCount
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_de_pniehus_jalienfx_AlienFXController_getZCount
  (JNIEnv *, jobject, jint);

/*
 * Class:     de_pniehus_jalienfx_AlienFXController
 * Method:    getDevDescription
 * Signature: (I)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_de_pniehus_jalienfx_AlienFXController_getDevDescription
  (JNIEnv *, jobject, jint);

/*
 * Class:     de_pniehus_jalienfx_AlienFXController
 * Method:    getZDescription
 * Signature: (II)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_de_pniehus_jalienfx_AlienFXController_getZDescription
  (JNIEnv *, jobject, jint, jint);

/*
 * Class:     de_pniehus_jalienfx_AlienFXController
 * Method:    getRGBA
 * Signature: (II)[I
 */
JNIEXPORT jintArray JNICALL Java_de_pniehus_jalienfx_AlienFXController_getRGBA
  (JNIEnv *, jobject, jint, jint);

/*
 * Class:     de_pniehus_jalienfx_AlienFXController
 * Method:    setRGBA
 * Signature: (IIIIII)V
 */
JNIEXPORT void JNICALL Java_de_pniehus_jalienfx_AlienFXController_setRGBA
  (JNIEnv *, jobject, jint, jint, jint, jint, jint, jint);

/*
 * Class:     de_pniehus_jalienfx_AlienFXController
 * Method:    init
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_de_pniehus_jalienfx_AlienFXController_init
  (JNIEnv *, jobject);

/*
 * Class:     de_pniehus_jalienfx_AlienFXController
 * Method:    updateLighting
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_de_pniehus_jalienfx_AlienFXController_updateLighting
  (JNIEnv *, jobject);

/*
 * Class:     de_pniehus_jalienfx_AlienFXController
 * Method:    release
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_de_pniehus_jalienfx_AlienFXController_release
  (JNIEnv *, jobject);

/*
 * Class:     de_pniehus_jalienfx_AlienFXController
 * Method:    resetLighting
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_de_pniehus_jalienfx_AlienFXController_resetLighting
  (JNIEnv *, jobject);

#ifdef __cplusplus
}
#endif
#endif