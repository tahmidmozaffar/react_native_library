import React from 'react';
import { AppRegistry, View, Text } from 'react-native';
import type { ItemData } from './customListView';

export const DetailsPageScreenName = 'DetailsPage';

type Props = {
  isFromNativeApp: boolean;
  route: { params: { item: ItemData } };
};

export const DetailsPage = ({ isFromNativeApp, route }: Props) => {
  if (isFromNativeApp) {
    console.log("isFromNativeApp", isFromNativeApp);
    route = JSON.parse(route as unknown as string);
  }

  const { item } = route.params;

  return (
    <View>
      <Text>Selected Item: {item.title}</Text>
    </View>
  );
};

AppRegistry.registerComponent('DetailsPage', () => DetailsPage);
