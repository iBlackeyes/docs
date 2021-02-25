package com.study.visitor;

import java.util.ArrayList;
import java.util.List;

public abstract class Element {
    String uuid;
    public abstract void accept(Visitor visitor);
}

class DocumentElement extends Element {
    List<Element> elements = new ArrayList<>();

    DocumentElement(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public void accept(Visitor visitor) {
        for (Element element : elements) {
            element.accept(visitor);
        }
    }

    public void add(Element element) {
        elements.add(element);
    }
}

class JSONElement extends Element {

    JSONElement(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitor(this);
    }
}

class XMLElement extends Element {

    XMLElement(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitor(this);
    }
}

