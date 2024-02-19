import React from 'react';
import { AppRegistry, View, Text } from 'react-native';
import { format } from 'date-fns';

// @ts-ignore
export const HelloPage = ({ name }) => {
  return (
    <View>
      <Text>Hello {name}</Text>
      <Text>{format(new Date(), "'Today is a' eeee")}</Text>
    </View>
  );
};

AppRegistry.registerComponent('HelloPage', () => HelloPage);
