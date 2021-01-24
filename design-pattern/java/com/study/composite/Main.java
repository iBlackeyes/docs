package com.study.composite;

public class Main {
    public static void main(String[] args) {
        Directory root = new Directory("root");
        Directory bin = new Directory("bin");
        Directory tmp = new Directory("tmp");
        Directory usr = new Directory("usr");

        root.add(bin)
                .add(tmp)
                .add(usr);

        bin.add(new File("vi", 10000));
        bin.add(new File("latex", 10000));

        Directory yuki = new Directory("yuki");
        Directory hanako = new Directory("hanako");
        Directory tomura = new Directory("tomura");

        usr.add(yuki)
                .add(hanako)
                .add(tomura);

        yuki.add(new File("diary.html", 10000))
                .add(new File("latex", 20000));

        hanako.add(new File("memo.tex", 10));

        tomura.add(new File("game.doc", 100))
                .add(new File("junk.mail", 200));

        root.pringList("");

    }
}
