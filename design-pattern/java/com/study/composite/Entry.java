package com.study.composite;

public abstract class Entry {
    public abstract String getName();
    public abstract int getSize();
    public Entry add(Entry entry) {
        throw new EntryAddException();
    }

    protected abstract void pringList(String prefix);

    public String toString() {
        return getName() + " (" + getSize() + ")";
    }
}

class EntryAddException extends RuntimeException {
    EntryAddException() {
    }

    EntryAddException(String msg) {
        super(msg);
    }
}