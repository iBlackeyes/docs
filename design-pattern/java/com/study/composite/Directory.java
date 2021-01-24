package com.study.composite;

import java.util.ArrayList;
import java.util.Iterator;

public class Directory extends Entry {
    private String name;
    ArrayList directory = new ArrayList<Entry>();

    Directory(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        int size = 0;
        Iterator iterator = directory.iterator();
        while(iterator.hasNext()) {
            size += ((Entry) iterator.next()).getSize();
        }
        return size;
    }

    @Override
    public Entry add(Entry entry) {
        directory.add(entry);
        return this;
    }

    @Override
    protected void pringList(String prefix) {
        System.out.println(prefix + "/" + this);
        Iterator iterator = directory.iterator();
        while (iterator.hasNext()) {
            Entry next = (Entry) iterator.next();
            next.pringList(prefix + "/" + name);
        }
    }
}
