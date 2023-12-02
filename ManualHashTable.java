package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.lang.Object;
import  java.util.HashMap;

public class ManualHashTable<K,V> {
    private LinkedList<MyMapNode<K,V>>[] frequencyContainer;
    private int size=0;

    /*
      @desc: initialise array of linkedlist with given size and at each index
      initialise the linked list
     */
    public  ManualHashTable(int size){
        this.size=size;
        this.frequencyContainer= new LinkedList[size];
        for(int i=0;i<size;i++) frequencyContainer[i]= new LinkedList<MyMapNode<K, V>>();

    }
/*
@desc: compute the hashcode of key given and return modulo size;
 */
    private  int getIndex(K key){
        int hashcode =key.hashCode();
        int index = (key.hashCode() & 0x7fffffff) % size; // to ensure always +ve values
        return index;
    }
/*
@desc: add the MyMapNode object with key and value in linked list of array
       at computed hash index
 */
    public void  put(K key,V values){
        int index= getIndex(key);
         frequencyContainer[index].add(new MyMapNode(key,values));
        return;
    }
 /*
 @desc: return the size of list at computed hash index of key in array
  */
    public int getfreq(K key){
        int index= getIndex(key);

       return frequencyContainer[index].size();
    }
}
