#include "trial_java_jnidemo_JniUtil.h"

JNIEXPORT jlong JNICALL Java_trial_java_jnidemo_JniUtil_getpid(JNIEnv *, jclass)
{
    // linux 下的实现。
    return getpid();
}