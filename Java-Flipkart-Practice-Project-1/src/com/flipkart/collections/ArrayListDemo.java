package com.flipkart.collections;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo {

    public static void main(String[] args) {
        List<String> list=new ArrayList<String>();
        System.out.println("Size of Collection: "+ list.size());

        // adding element in the list
        list.add("item1");
        list.add("item2");
        list.add("123");
        list.add("item3");

        list.remove("item1");
        list.remove(2);

        System.out.println();

        for(String value: list) {

            System.out.println("Element:--" +value);
        }

    }
}