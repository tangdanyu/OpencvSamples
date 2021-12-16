
cmake_minimum_required(VERSION 3.10.2)

# Declares and names the project.

project("tdylib")

# Creates and names a library, sets it as either STATIC
# or SHARED, and provides the relative paths to its source code.
# You can define multiple libraries, and CMake builds them for you.
# Gradle automatically packages shared libraries with your APK.
# 设置include文件夹的地址
include_directories(src/main/cpp/include)

## 设置opencv的动态库
add_library(libopencv_java SHARED IMPORTED)

set_target_properties(libopencv_java PROPERTIES IMPORTED_LOCATION
        ${CMAKE_SOURCE_DIR}/src/main/jniLibs/${ANDROID_ABI}/libopencv_java4.so)


add_library( # Sets the name of the library.
        tdylib

        SHARED

        # Provides a relative path to your source file(s).

        src/main/cpp/native-lib.cpp)

# Searches for a specified prebuilt library and stores the path as a
# variable. Because CMake includes system libraries in the search path by
# default, you only need to specify the name of the public NDK library
# you want to add. CMake verifies that the library exists before
# completing its build.

find_library( # Sets the name of the path variable.
        log-lib

        log)

# Specifies libraries CMake should link to your target library. You
# can link multiple libraries, such as libraries you define in this
# build script, prebuilt third-party libraries, or system libraries.

target_link_libraries( # Specifies the target library.
        tdylib
        libopencv_java
        # Links the target library to the log library
        # included in the NDK.
        ${log-lib})
#添加其他cmakelist生成多个so
ADD_SUBDIRECTORY(src/main/cpp/jni/FindFeatures/)
ADD_SUBDIRECTORY(src/main/cpp/jni/DetectionBasedTracker)