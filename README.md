<h1>React Native library example for ReactNative and Native Apps</h1>


This is a demonstration of implementing a react-native library that can be used in both react-native apps and native Andrid and iOS apps. 

At this time, the library is integrated with React native and native Android projects. But it is possible to use it in a native iOS project.


<h2>Project Structure</h2>

- **src** -> This folder contains all react code.

- **android** -> It contains the native android part of the library

- **ios** -> It contains the native iOS part of the library (will be implemented later)

- **MyNativeAndroidApp** -> It is a native Android application that is using the library

- **myreactnativeapp** -> It is a React-Native application that is using the library


<h2>How to see the library in action?</h2>

To test the library, you can run the projects.

First run ```yarn``` or ```npm install``` command at the root folder to download the ```node_modules```

Then run this command to create the index.android.bundle file in android/src/main/assets folder.

```npx react-native bundle --platform android --dev false --entry-file src/index.tsx --bundle-output android/src/main/assets/index.android.bundle --assets-dest android/src/main/res/```

Anytime you change the react code in src folder, you have to run this command to reflect the change in Native Android app.

Now for the MyNativeAndroidApp project, you can just run the app using Android Studio. Open MyNativeAndroidApp folder in Android studio and let the gradle complete the sync. Then run the app in emulator or device.



To run the React-Native project, go the folder ```myreactnativeapp``` and run ```yarn``` or ```npm install``` to download the ```node_modules```

Then run the app using  ```yarn android``` command. 
