package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {

    T[] inputArray;
    public ArrayUtility(T[] inputArray) {
        this.inputArray = inputArray;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        Integer count = 0;
        for (T t : inputArray){
            if(t.equals(valueToEvaluate)){
                count++;
            }
        }
        return count;
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        List<T> nL = new ArrayList<>(Arrays.asList(inputArray));
        List<T> nL2 = new ArrayList<>(Arrays.asList(arrayToMerge));
        nL.addAll(nL2);
        T mostCommonT = null;
        Integer mostCommon = 0;
        for (T obj : nL){
            Integer count = getNumberOfOccurrences(obj);
            if (count > mostCommon){
                mostCommonT = obj;
                mostCommon = count;
            }
        }
        return mostCommonT;
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        List<T> nL = new ArrayList<>(Arrays.asList(inputArray));
        List<T> nL2 = new ArrayList<>(Arrays.asList(arrayToMerge));
        nL.addAll(nL2);
        inputArray = (T[]) nL.toArray();
        return getNumberOfOccurrences(valueToEvaluate);
    }

    public T[] removeValue(T valueToRemove) {
        List<T> nL = new ArrayList<>();
        for (T obj : inputArray) {
            if (!obj.equals(valueToRemove)) {
                nL.add(obj);
            }
        }
        return toArray(nL);
    }

    public T[] toArray(List<T> list){
        T[] newArr = (T[]) Array.newInstance(list.get(0).getClass(), list.size());
        for (int i = 0; i < list.size(); i++){
            newArr[i] = list.get(i);
        }
        return newArr;
    }
}
