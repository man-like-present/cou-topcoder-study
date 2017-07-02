package topcoder.chapter05.mazemaker.bart;

import java.util.*;

public class MazeMaker {

    private static final int INVALID_LOCATION = -2;
    private static final int CAN_NOT_REACHED_LOCATION = -1;

    private int[][] shortCountGrid;
    private List<Move> moveList;

    class Move {
        Move(int row, int col) {
            this.row = row;
            this.col = col;
        }

        int row;
        int col;
    }

    class Location {
        Location(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

        int x;
        int y;
        int count;
    }

    private void initShortCountGrid(String[] maze) {
        shortCountGrid = new int[maze.length][maze[0].toCharArray().length];
        for(int i=0; i<maze.length; i++) {
            char[] mazeChar = maze[i].toCharArray();
            for(int j=0; j< mazeChar.length; j++) {
                if(mazeChar[j] == 'X'){
                    shortCountGrid[i][j] = INVALID_LOCATION;
                }
            }
        }
    }

    private void initMove(int[] moveRow, int[] moveCol) {
        moveList = new ArrayList<>();
        for(int i=0; i<moveRow.length; i++){
            moveList.add(new Move(moveRow[i],moveCol[i]));
        }
    }

    public int longestPath(String[] maze, int startRow, int startCol, int[] moveRow, int[] moveCol) {
        initShortCountGrid(maze);
        initMove(moveRow,moveCol);

        return breadthFirstSearch(startRow, startCol);
    }

    private int breadthFirstSearch(int x, int y) {
        ArrayDeque<Location> deque = new ArrayDeque<>();
        deque.push(new Location(x,y, 0));
        List<Location> popList = new ArrayList<>();
        int longestPathLength = 0;

        while (deque.size() != 0) {
            Location location = deque.pop();
            popList.add(location);

            shortCountGrid[location.x][location.y] = calculateShortCount(location);

            longestPathLength = Math.max(longestPathLength, shortCountGrid[location.x][location.y]);

            moveList.forEach(move -> {
                Location next = buildNextLocation(location, move);
                if(hasBeenChecked(popList, next)) {
                    return;
                }

                if(!availableMoving(next)) {
                    return;
                }

                deque.add(next);
            });
        }

        if(hasInvalidLocation(popList)) {
            return CAN_NOT_REACHED_LOCATION;
        }

        return longestPathLength;
    }

    private int calculateShortCount(Location location) {
        return shortCountGrid[location.x][location.y] == 0? location.count : Math.min(shortCountGrid[location.x][location.y], location.count);
    }


    private Location buildNextLocation(Location location, Move move) {
        return new Location(location.x + move.row, location.y + move.col, location.count+1);
    }

    private boolean hasBeenChecked(List<Location> popList, Location location) {
        return popList.stream().filter(loc -> loc.x == location.x && loc.y == location.y).count() > 0;
    }

    private boolean availableMoving(Location location) {
        return location.x  >= 0 && location.x  < shortCountGrid.length
            && location.y  >= 0 && location.y  < shortCountGrid[0].length
            && shortCountGrid[location.x][location.y] >= 0;
    }

    private boolean hasInvalidLocation(List<Location> popList) {
        for(int i=0; i< shortCountGrid.length; i++) {
            for(int j=0; j< shortCountGrid[0].length; j++) {
                if(shortCountGrid[i][j] == 0
                    && !hasBeenChecked(popList, new Location(i,j,0))) {
                    return true;
                }
            }
        }
        return false;
    }
}
