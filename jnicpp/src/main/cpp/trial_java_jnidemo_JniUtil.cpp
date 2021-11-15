#include <Windows.h>
#include "trial_java_jnidemo_JniUtil.h"

JNIEXPORT jlong JNICALL Java_trial_java_jnidemo_JniUtil_getpid(JNIEnv *, jclass) {
    return GetCurrentProcessId();
}