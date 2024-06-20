package ch.hslu.ad.sw04.performance;

import ch.hslu.ad.sw02.stack.MyStack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class PerformanceTest {

    public static Integer[] generateTestDataArray(int size) {
        Integer[] testData = new Integer[size];
        for (int i = 0; i < size; i++) {
            testData[i] = i;
        }
        return testData;
    }

    public static Stack<Integer> generateTestDataStack(int size) {
        Stack<Integer> testData = new Stack();
        testData.ensureCapacity(size);
        for (int i = 0; i < size; i++) {
            testData.push(i);
        }
        return testData;
    }

    public static MyStack generateTestDataMyStack(int size) {
        MyStack testData = new MyStack(size);
        for (int i = 0; i < size; i++) {
            testData.push(i);
        }
        return testData;
    }

    public static Deque generateTestDataDeque(int size) {
        Deque<Integer> testData = new ArrayDeque(size);
        for (Integer value : testData) {
            testData.addLast(value);
        }
        return testData;
    }

    public static void main(String[] args) {
        int size = 100000;
        long startTime;
        long endTime;
        long duration;

        startTime = System.nanoTime();
        generateTestDataArray(size);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Array: Time for creation of " + size + " elements: " + duration + " ns");

        startTime = System.nanoTime();
        generateTestDataStack(size);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Stack: Time for creation of " + size + " elements: " + duration + " ns");

        startTime = System.nanoTime();
        generateTestDataMyStack(size);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("My Stack: Time for creation of " + size + " elements: " + duration + " ns");

        startTime = System.nanoTime();
        generateTestDataDeque(size);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Deque: Time for creation of " + size + " elements: " + duration + " ns");
    }

}
