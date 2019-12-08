package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        HashMap<String, String[]> dictionary = new HashMap<>();
        dictionary.put("большой", new String[]{"гигантский", "огромный", "громадный", "великий", "крупный"});
        dictionary.put("человек", new String[]{"личность", "персона", "гомосапиенс", "индивидуум"});
        dictionary.put("красивый", new String[]{"прекрасный", "милый", "симпатичный", "спортивный"});
        dictionary.put("дом", new String[]{"хата", "жилище", "квартира", "особняк", "дворец", "вилла"});

        HashMap<String, String[]> bigDictionary = new HashMap<>(dictionary);
        Set<String> stringSet = dictionary.keySet();
        Iterator<String> iter = stringSet.iterator();

        System.out.println("В большом словаре есть следующие слова:");

        while (iter.hasNext()){
            try {
                String key = iter.next();
                String[] arr = bigDictionary.get(key);
                bigDictionary.put(key, arr);

                for (String str : arr){
                    ArrayList<String> arrayList = new ArrayList<>(arr.length);
                    arrayList.addAll(Arrays.asList(arr));
                    arrayList.add(key);
                    arrayList.remove(str);
                    String[] arr2 = new String[arrayList.size()];
                    arr2 = arrayList.toArray(arr2);
                    bigDictionary.put(str, arr2);
                    System.out.println(str + " - " + Arrays.toString(arr2));
                }
            }
            catch (Exception ex)
            {}
        }
        System.out.println("Введите предложение из словаря, например большой дом: ");
        Scanner scanner = new Scanner(System.in);
        String sentences = scanner.nextLine().toLowerCase();
        String[] words = sentences.split(" ");
        for (int i = 0; i < words.length; i++){
            if (bigDictionary.get(words[i]) == null){
                System.out.println("Слово не найдено");
            }
            else {
                String[] synonims = bigDictionary.get(words[i]);
                Random random = new Random();
                int randomIndex = random.nextInt(synonims.length);
                System.out.println(synonims[randomIndex] + " ");
            }
        }
    }
}
