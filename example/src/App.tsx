import * as React from 'react';
import {
  DetailsPage,
  DetailsPageScreenName,
} from 'react-native-remotearth';
import { createStackNavigator } from '@react-navigation/stack';
import HomeScreen from './HomeScreen';
import { NavigationContainer } from '@react-navigation/native';

const Stack = createStackNavigator();
const navigationContainerRef = React.createRef();

export default function App() {
  return (
    // @ts-ignore
    <NavigationContainer ref={navigationContainerRef}>
      <Stack.Navigator>
        <Stack.Screen name="Home" component={HomeScreen} />
        <Stack.Screen name={DetailsPageScreenName} component={DetailsPage} />
      </Stack.Navigator>
    </NavigationContainer>
  );
}
