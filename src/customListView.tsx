import { type NavigationProp } from '@react-navigation/native';
import React, { type FC } from 'react';
import { AppRegistry, StyleSheet, NativeModules } from 'react-native';
import { FlatList } from 'react-native';
import { StatusBar } from 'react-native';
import { Text } from 'react-native';
import { TouchableOpacity } from 'react-native';
import { DetailsPageScreenName } from './details';

const { Remotearth } = NativeModules;

export type ItemData = {
  id: string;
  title: string;
};

type ItemProps = {
  item: ItemData;
  onPress: () => void;
  backgroundColor: string;
  textColor: string;
};

export const Item = ({
  item,
  onPress,
  backgroundColor,
  textColor,
}: ItemProps) => (
  <TouchableOpacity
    onPress={onPress}
    style={[styles.item, { backgroundColor }]}
  >
    <Text style={[styles.title, { color: textColor }]}>{item.title}</Text>
  </TouchableOpacity>
);

export type Props = {
  isFromNativeApp: boolean;
  navigation: NavigationProp<ReactNavigation.RootParamList>;
  data: ItemData[] | string;
};

// 3rd party app will add this listview to there app.
export const CustomListView: FC<Props> = ({
  isFromNativeApp,
  navigation,
  data,
}) => {
  // @ts-ignore
  const [selectedId, setSelectedId] = React.useState<string>();
  console.log('data', data);
  console.log(typeof data);
  if (isFromNativeApp) {
    console.log('isFromNativeApp', isFromNativeApp);
    data = JSON.parse(data as string);
  }
  // const

  const renderItem = ({ item }: { item: ItemData }) => {
    const backgroundColor = item.id === selectedId ? '#6e3b6e' : '#f9c2ff';
    const color = item.id === selectedId ? 'white' : 'black';

    return (
      <Item
        item={item}
        onPress={() => {
          if (!isFromNativeApp) {
            // @ts-ignore
            navigation.navigate(DetailsPageScreenName, {
              isFromNativeApp:false,
              item,
            });
          } else {
            //call rn bridge method to navigate to Details page
            Remotearth.openDetailsPage(item);
          }
        }}
        backgroundColor={backgroundColor}
        textColor={color}
      />
    );
  };

  return (
    <FlatList
      data={data}
      renderItem={renderItem}
      keyExtractor={(item) => item.id}
    />
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    marginTop: StatusBar.currentHeight || 0,
  },
  item: {
    padding: 20,
    marginVertical: 8,
    marginHorizontal: 16,
  },
  title: {
    fontSize: 20,
  },
});

AppRegistry.registerComponent('CustomListView', () => CustomListView);
