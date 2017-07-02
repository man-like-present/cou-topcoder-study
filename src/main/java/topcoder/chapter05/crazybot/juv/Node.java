package topcoder.chapter05.crazybot.juv;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Juv
 * @since 2017-07-02
 */
public class Node {

    private Map<String, Boolean> isVisited;

    private int x;

    private int y;

    private double probability = 1D;

    public Node(int boardSize) {
        this.isVisited = new HashMap<>();
        this.x = boardSize / 2;
        this.y = boardSize / 2;
        this.isVisited.put(makeKey(x, y), true);
    }

    public Node(Node node) {
        this.isVisited = new HashMap<>();
        this.isVisited.putAll(node.isVisited);
        this.x = node.x;
        this.y = node.y;
        this.probability = node.probability;
    }

    public boolean addpath(String direction, double probability) {
        this.probability *= probability;
        if ("E".equals(direction)) {
            ++this.x;
        } else if ("W".equals(direction)) {
            --this.x;
        } else if ("S".equals(direction)) {
            ++this.y;
        } else if ("N".equals(direction)) {
            --this.y;
        }

        return isValidPath();
    }

    private boolean isValidPath() {
        String key = makeKey(x, y);
        if (this.isVisited.get(key) != null && this.isVisited.get(key)) {
            return false;
        }
        this.isVisited.put(key, true);
        return true;
    }

    public double getProbability() {
        return probability;
    }

    @Override
    public String toString() {
        return "Node{" +
                ", x=" + x +
                ", y=" + y +
                ", probability=" + probability +
                "}\n" + this.isVisited;

    }

    private String makeKey(int x, int y) {
        return x + "_" + y;
    }
}
