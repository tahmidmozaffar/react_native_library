import React from 'react';
import { View, Text } from 'react-native';

export const DetailsPageScreenName = 'DetailsPage';
// @ts-ignore
export const DetailsPage = ({ route }) => {
  const { item } = route.params;

  return (
    <View>
      <Text>Selected Item: {item.title}</Text>
    </View>
  );
};
