package org.example;

import java.util.Hashtable;

public class Main {
    public static void main(String[] args) {
        String sentence = "Paranoids are not paranoid because they are paranoid but because they keep putting themselves deliberately into paranoid avoidable situations";
        String[] words = sentence.split("\\s+");
        int size=100;
        ManualHashTable<String,Integer> map= new ManualHashTable(100);
        for(String word:words){
            Integer freq= map.getfreq(word);
            if(freq!=null){
                freq=freq+1;
                map.put(word,freq);
            }
            else map.put(word,1 );
        }
        for(String word : words){
            System.out.println(word+" "+ map.getfreq(word));
        }
        /*
        Output:
Paranoids 1
are 2
not 1
paranoid 3
because 2
they 2
are 2
paranoid 3
but 1
because 2
they 2
keep 1
putting 1
themselves 1
deliberately 1
into 1
paranoid 3
avoidable 1
situations 1
         */
    }
}
