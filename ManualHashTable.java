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
@desc: update the MyMapNode object with new values if present and add
 new MyMapNode object with key value pair if not present earlier in linked list of array
       at computed hash index
 */
    public void  put(K key,V values){
        int index= getIndex(key);
        boolean found=false;
        for(MyMapNode<K,V> node :frequencyContainer[index]){
            if(node.key.equals(key)){
                node.value=values;
                found=true;
                break;
            }
        }

        if(!found) frequencyContainer[index].add(new MyMapNode<K,V>(key,values));
        return;
    }
 /*
 @desc: return the si at computed hash index of key in array
  */
    public V getfreq(K key){
        int index= getIndex(key);
        for(MyMapNode<K,V> node: frequencyContainer[index]) {
            if (node.key.equals(key)) return node.value;
        }
        return null;
    }
}
