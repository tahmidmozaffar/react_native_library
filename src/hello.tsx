import React from 'react';
import { AppRegistry, View, Text } from 'react-native';

export const HelloPage = () => {
  return (
    <View>
      <Text>Hello world</Text>
    </View>
  );
};

AppRegistry.registerComponent('HelloPage', () => HelloPage);
