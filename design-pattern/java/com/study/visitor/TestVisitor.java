package com.study.visitor;

import java.util.UUID;

public class TestVisitor {
    public static void main(String[] args) {
        DocumentElement documentElement = new DocumentElement(UUID.randomUUID().toString());
        documentElement.add(new JSONElement(UUID.randomUUID().toString()));
        documentElement.add(new XMLElement(UUID.randomUUID().toString()));
        documentElement.accept(new DemoVisitor());
    }
}
