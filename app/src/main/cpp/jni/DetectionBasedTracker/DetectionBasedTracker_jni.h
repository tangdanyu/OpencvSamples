/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class org_opencv_samples_fd_DetectionBasedTracker */

#ifndef _Included_org_opencv_samples_fd_DetectionBasedTracker
#define _Included_org_opencv_samples_fd_DetectionBasedTracker
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     org_opencv_samples_fd_DetectionBasedTracker
 * Method:    nativeCreateObject
 * Signature: (Ljava/lang/String;F)J
 */

#define FD_JNI_METHOD(METHOD_NAME) Java_com_example_opencvsamples_facedetect_DetectionBasedTracker_##METHOD_NAME
extern "C" {
JNIEXPORT jlong JNICALL FD_JNI_METHOD(nativeCreateObject)
        (JNIEnv *, jclass, jstring, jint);

}

/*
 * Class:     org_opencv_samples_fd_DetectionBasedTracker
 * Method:    nativeDestroyObject
 * Signature: (J)V
 */
void FD_JNI_METHOD(nativeDestroyObject)
  (JNIEnv *, jclass, jlong);

/*
 * Class:     org_opencv_samples_fd_DetectionBasedTracker
 * Method:    nativeStart
 * Signature: (J)V
 */
void FD_JNI_METHOD(nativeStart)
  (JNIEnv *, jclass, jlong);

/*
 * Class:     org_opencv_samples_fd_DetectionBasedTracker
 * Method:    nativeStop
 * Signature: (J)V
 */
void FD_JNI_METHOD(nativeStop)
  (JNIEnv *, jclass, jlong);

  /*
   * Class:     org_opencv_samples_fd_DetectionBasedTracker
   * Method:    nativeSetFaceSize
   * Signature: (JI)V
   */
void FD_JNI_METHOD(nativeSetFaceSize)
  (JNIEnv *, jclass, jlong, jint);

/*
 * Class:     org_opencv_samples_fd_DetectionBasedTracker
 * Method:    nativeDetect
 * Signature: (JJJ)V
 */
void FD_JNI_METHOD(nativeDetect)
  (JNIEnv *, jclass, jlong, jlong, jlong);



#ifdef __cplusplus
}
#endif
#endif
