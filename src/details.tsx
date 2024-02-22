import React from 'react';
import { AppRegistry, View, Text } from 'react-native';
import type { ItemData } from './customListView';

export const DetailsPageScreenName = 'DetailsPage';

type Props = {
  route?: { params: { item: ItemData }; isFromNativeApp: boolean };
};

export const DetailsPage = ({ route }: Props) => {
  if (typeof route === 'string') {
    route = JSON.parse(route);
  }

  // @ts-ignore
  const { item } = route?.params;

  return (
    <View>
      <Text>Selected Item: {item?.title}</Text>
    </View>
  );
};

AppRegistry.registerComponent('DetailsPage', () => DetailsPage);
