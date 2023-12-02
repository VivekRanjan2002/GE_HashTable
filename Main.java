package org.example;

public class Main {
    public static void main(String[] args) {
        String sentence = "To be or not to be";
        String[] words = sentence.split("\\s+");
        FreqMap<String,Integer> map= new FreqMap<>();
        for(String word:words){
            Integer freq= map.get(word);
            if(freq!=null){
                freq=freq+1;
                map.put(word,freq);
            }
            else map.put(word,1 );
        }
        for(String word : words){
            System.out.println(word+" "+ map.get(word));
        }
        /*
        Output:
        To 1
        be 2
        or 1
        not 1
        to 1
        be 2
         */
    }
}
