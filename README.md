# store

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class CustomSortApp {

    public static void customSort(List<Integer> arr) {
        Map<Integer, Data> dataSet = new HashMap<>();
        for (int i = 0; i < arr.size(); i++) {
            int key = arr.get(i);
            Data data = dataSet.get(key);
            if (data == null) {
                dataSet.put(key, new Data(key, 1));
            } else {
                data.sum();
            }
        }
        List<Data> values = new ArrayList<>(dataSet.values());
        Collections.sort(values, Data::compareTo);
        
        values.stream().forEach((Data t) -> {
            for (int i = 0; i < t.weight; i++) {
                System.out.println(t.key);
            }
        });
    }

    private static class Data implements Comparable<Data>{

        public int key;
        public int weight;

        public Data(int key, int value) {
            this.key = key;
            this.weight = value;
        }

        public void sum() {
            weight++;
        }

        @Override
        public int compareTo(Data data) {
            if (this.weight == data.weight) {
                int result = ((Integer) data.key).compareTo(this.key);
                if (result > 0) {
                    return -1;
                } else if (result < 0) {
                    return 1;
                }
                return result;
            }
            int result = ((Integer) data.weight).compareTo(this.weight);
            if (result > 0) {
                return -1;
            } else if (result < 0) {
                return 1;
            }
            return result;
        }        
    }

    public static void main(String[] args) {
        customSort(Arrays.asList(3,1,2,2,4));
    }

}
