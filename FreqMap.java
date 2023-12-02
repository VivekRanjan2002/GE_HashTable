package org.example;

import java.util.LinkedList;

public class FreqMap<K,V>{
    private LinkedList<MyMapNode<K,V>> list; // linked list of MyMapNode objects
    public FreqMap(){
        list=new LinkedList();
    }
    /*
    @desc: add word,freq pair in list
     */
    public void put(K key,V value){
        boolean found= false;
        for(MyMapNode<K,V> node: list){
            if(node.key.equals(key)){
                node.value=value;
                found=true;
                break;
            }

        }
        if(!found) list.add(new MyMapNode<K,V>(key, value));
    }
    /*
    @desc: return the value of the particular key to be searched in list
     */
    public  V get(K key){
        for(MyMapNode<K,V> node: list){
            if(node.key.equals(key)) return  node.value;
        }
        return  null;
    }
}
