package com.kitchen.entity;

/**
 * The order to kitchen
 */
public class Order {

    /**
     * Unique id
     */
    private String id;

    /**
     * Order name
     */
    private String name;

    /**
     * The timestamp when the order ready
     */
    private long readyTime;

    /**
     * The order will take prepTime(second) to prepare
     */
    private int prepTime;

    public Order() {
    }

    public Order(String id, String name, int prepTime) {
        this.id = id;
        this.name = name;
        this.prepTime = prepTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(int prepTime) {
        this.prepTime = prepTime;
    }

    public long getReadyTime() {
        return readyTime;
    }

    public void setReadyTime(long readyTime) {
        this.readyTime = readyTime;
    }
}
