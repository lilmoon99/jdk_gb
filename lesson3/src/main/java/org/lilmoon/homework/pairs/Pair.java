package org.lilmoon.homework.pairs;

public class Pair<K, V> {
    K first;
    V second;

    public Pair(K first, V second) {
        this.first = first;
        this.second = second;
    }

    public K getFirst() {
        return first;
    }

    public void setFirst(K first) {
        this.first = first;
    }

    public V getSecond() {
        return second;
    }

    public void setSecond(V second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return "First: " + this.first + " Class:" + this.first.getClass().getSimpleName()
                + "\nSecond: " + this.second + " Class:" + this.second.getClass().getSimpleName();
    }
}
