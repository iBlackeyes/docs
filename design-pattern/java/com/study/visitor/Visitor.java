package com.study.visitor;

public interface Visitor {
    /** 这里要对应Element的子类 */
    void visitor(JSONElement element);
    void visitor(XMLElement element);
}

class DemoVisitor implements Visitor {

    @Override
    public void visitor(JSONElement element) {
        System.out.println("Visitor JSONElement " + element.uuid + element.getClass());

    }

    @Override
    public void visitor(XMLElement element) {
        System.out.println("Visitor XMLELement " + element.uuid + element.getClass());
    }
}
