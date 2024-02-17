import { NativeModules, Platform } from 'react-native';

const LINKING_ERROR =
  `The package 'react-native-test-rn-library' doesn't seem to be linked. Make sure: \n\n` +
  Platform.select({ ios: "- You have run 'pod install'\n", default: '' }) +
  '- You rebuilt the app after installing the package\n' +
  '- You are not using Expo Go\n';

// const TestRnLibrary = NativeModules.TestRnLibrary
//   ? NativeModules.TestRnLibrary
//   : new Proxy(
//       {},
//       {
//         get() {
//           throw new Error(LINKING_ERROR);
//         },
//       }
//     );

// export function showAdNative(a: number, b: number): Promise<number> {
//   return TestRnLibrary.multiply(a, b);
// }

// export function showAd() {}

export * from './customListView';
export * from './details';




