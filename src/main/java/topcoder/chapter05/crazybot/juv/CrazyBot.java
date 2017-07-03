package topcoder.chapter05.crazybot.juv;

import com.google.common.base.Stopwatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 14, 25, 25, 25, 25에서 OOM 발생
 * @author Juv
 * @since 2017-06-30
 */
public class CrazyBot {

    private static final String[] DIRECTIONS = new String[]{"E", "W", "S", "N"};

    public double getProbability(int n, int east, int west, int south, int north) {
        if (east + west + south + north != 100) {
            throw new IllegalArgumentException();
        }
        // board의 최대 사이즈 길이
        int boardSize = 2 * n + 1;
        // 방문여부 기록
        double[] probability = new double[4];
        probability[0] = (double) east / 100;
        probability[1] = (double) west / 100;
        probability[2] = (double) south / 100;
        probability[3] = (double) north / 100;

        List<Node> paths = new ArrayList<>();
        Stopwatch stopwatch = Stopwatch.createUnstarted();
        for (int i = 0; i < n; i++) {
            stopwatch.start();
            paths = getPathNodeByDepth(paths, probability, boardSize);
            System.out.println("### " + i + " : " + stopwatch.stop().elapsed(TimeUnit.MILLISECONDS));
            stopwatch.reset();
        }

        return paths.stream().mapToDouble(Node::getProbability).sum();
    }

    List<Node> getPathNodeByDepth(List<Node> pathOfParentDepth, double[] probability, int boardSize) {
        if (pathOfParentDepth == null || pathOfParentDepth.isEmpty()) {
            return getFirstDepthPath(boardSize, probability);
        }

        List<Node> results = new ArrayList<>();
        for (Node parentPath : pathOfParentDepth) {
            for (int directionIndex = 0; directionIndex < DIRECTIONS.length; directionIndex++) {
                if (probability[directionIndex] <= 0) {
                    continue;
                }
                Node node = new Node(parentPath);
                if (node.addpath(DIRECTIONS[directionIndex], probability[directionIndex])) {
                    results.add(node);
                }
            }
        }
        return results;
    }

    private List<Node> getFirstDepthPath(int boardSize, double[] probability) {
        List<Node> results = new ArrayList<>();
        for (int directionIndex = 0; directionIndex < DIRECTIONS.length; directionIndex++) {
            if (probability[directionIndex] <= 0) {
                continue;
            }
            Node node = new Node(boardSize);
            node.addpath(DIRECTIONS[directionIndex], probability[directionIndex]);
            results.add(node);
        }
        return results;
    }
}
