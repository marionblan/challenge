# challenge

_Pre-requisites:_

 * Install Java 1.8, nodejs, android studio
 * Set environment variables: ANDROID_HOME, JAVA_HOME, NODE_HOME. And add paths to android /Sdk, /tools, /tools/bin, /platform-tools, /npm/bin
 * Install Appium server via node (as admin): **npm install -g appium**

_To run locally:_

* clone the project
* start appium in console: **appium**
* Open Android Studio and create an android emulator.
* Start the emulator.
* In the src/test/base.java update the emulator name to the one you just created
* Add the app-debug.apk under src
* Run src/test/tests.java
