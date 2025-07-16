package binaryTrees.hardLevel.models;

import binaryTrees.traversals.creation.Node;

public class PairParent {
    private Node node;
    private Node parent;
    private int distance;

    public PairParent(Node node, Node parent, int distance) {
        this.node = node;
        this.parent = parent;
        this.distance = distance;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
