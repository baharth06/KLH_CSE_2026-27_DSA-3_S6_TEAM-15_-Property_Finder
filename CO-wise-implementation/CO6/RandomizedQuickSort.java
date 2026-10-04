package CO6;

import java.util.Random;

public class RandomizedQuickSort {

    static class Property {
        String name;
        int price;

        public Property(String name, int price) {
            this.name = name;
            this.price = price;
        }

        @Override
        public String toString() {
            return name + " (₹" + price + ")";
        }
    }

    public static void main(String[] args) {
        System.out.println("--- CO6: Randomized Algorithms (Randomized Quicksort) ---");
        System.out.println("Sorting properties by price using a random pivot.\n");

        Property[] properties = {
            new Property("Villa in Gachibowli", 6000000),
            new Property("3BHK in Madhapur", 5000000),
            new Property("1BHK in Warangal", 1500000),
            new Property("Penthouse in Jubilee Hills", 8000000),
            new Property("2BHK in Kondapur", 4500000)
        };

        System.out.println("Before Sorting:");
        for (Property p : properties) {
            System.out.println(p);
        }

        randomizedQuickSort(properties, 0, properties.length - 1);

        System.out.println("\nAfter Sorting (Ascending Price):");
        for (Property p : properties) {
            System.out.println(p);
        }
    }

    static void randomizedQuickSort(Property[] arr, int low, int high) {
        if (low < high) {
            int pi = randomizedPartition(arr, low, high);
            randomizedQuickSort(arr, low, pi - 1);
            randomizedQuickSort(arr, pi + 1, high);
        }
    }

    static int randomizedPartition(Property[] arr, int low, int high) {
        Random rand = new Random();
        int pivotIndex = rand.nextInt(high - low) + low;
        
        // Swap arr[pivotIndex] with arr[high]
        Property temp = arr[pivotIndex];
        arr[pivotIndex] = arr[high];
        arr[high] = temp;
        
        return partition(arr, low, high);
    }

    static int partition(Property[] arr, int low, int high) {
        int pivot = arr[high].price;
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j].price <= pivot) {
                i++;
                // Swap arr[i] and arr[j]
                Property temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // Swap arr[i+1] and arr[high]
        Property temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        
        return i + 1;
    }
}
