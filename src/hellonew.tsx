import React from 'react';
import { AppRegistry, View, Text } from 'react-native';

export const HelloPageNew = () => {
  return (
    <View>
      <Text>Hello world new</Text>
    </View>
  );
};

AppRegistry.registerComponent('HelloPageNew', () => HelloPageNew);
