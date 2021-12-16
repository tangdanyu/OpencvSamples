##cmake_minimum_required(VERSION 3.6)
##
##set(target detection_based_tracker)
##project(${target} CXX)
##
##set(ANDROID_OPENCV_COMPONENTS "opencv_java" CACHE STRING "")
##message(STATUS "ANDROID_ABI=${ANDROID_ABI}")
##find_package(OpenCV REQUIRED COMPONENTS ${ANDROID_OPENCV_COMPONENTS})
##
##file(GLOB srcs *.cpp *.c)
##file(GLOB hdrs *.hpp *.h)
##
##include_directories("${CMAKE_CURRENT_LIST_DIR}")
##add_library(${target} SHARED ${srcs} ${hdrs})
##target_link_libraries(${target} ${ANDROID_OPENCV_COMPONENTS})
#
cmake_minimum_required(VERSION 3.10.2)
# 设置include文件夹的地址
include_directories(src/main/cpp/include)

add_library(
        detection_based_tracker
        SHARED
        DetectionBasedTracker_jni.cpp
        DetectionBasedTracker_jni.h
)

find_library(
        log-lib
        log)
target_link_libraries(
        detection_based_tracker
        libopencv_java
        ${log-lib})

