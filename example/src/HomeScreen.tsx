import { useNavigation } from '@react-navigation/native';
import React from 'react';
import { StyleSheet, View, Text } from 'react-native';
import { CustomListView } from 'react-native-remotearth';

export default function HomeScreen() {
  const navigation = useNavigation();
  
  return (
    <View style={styles.container}>
      <Text>Hello world</Text>
      <CustomListView
        navigation={navigation}
        data={[
          { id: '1', title: 'Test 1' },
          { id: '2', title: 'Test 2' },
          { id: '3', title: 'Test 3' },
          { id: '4', title: 'Test 4' },
          { id: '5', title: 'Test 5' },
        ]}
      />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  box: {
    width: 60,
    height: 60,
    marginVertical: 20,
  },
});
