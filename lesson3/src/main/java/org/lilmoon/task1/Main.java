package org.lilmoon.task1;


import java.io.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        try (DataInputStream inputStream = new DataInputStream(System.in);){
            Box <String, DataInputStream,Integer> box = new Box<String, DataInputStream, Integer>("Hello",inputStream,2);
                    box.printClassName();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        MyCollection<Integer> collection = new MyCollection<>();
        collection.add(1);
        collection.add(2);
        collection.add(3);
        collection.deleteElement(2);
        System.out.println(collection);
        MyCollectionIterator<Object> iterator = new MyCollectionIterator<>(collection.getCollection());
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

}