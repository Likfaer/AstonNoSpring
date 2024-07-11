package com.example.context;

import com.example.components.SomeClass1;

public class Main {
    public static void main(String[] args) {
        IntensiveContext context = new IntensiveContext("com.example.components");
        SomeClass1 class1 = context.getObject(SomeClass1.class);
        class1.run();
    }
}
