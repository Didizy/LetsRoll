package com.example.letroll;

public class DiceItem {
    private String name;
    private int count;

    public DiceItem(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
