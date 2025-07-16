package binaryTrees.hardLevel.models;

import binaryTrees.traversals.creation.Node;

public class Pair {
    private Node first;
    private int second;
    public Pair(Node first, int second) {
        this.first=first;
        this.second=second;
    }

    public Node getFirst() {
        return this.first;
    }

    public int getSecond() {
        return this.second;
    }
};