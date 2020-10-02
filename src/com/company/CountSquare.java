package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountSquare {
    private final int[][] oneSquare = {
            {1, 1},
            {1, 3},
            {3, 1},
            {3, 3},
    };

    private final int[][] doubleSquare = {
            {1, 1},
            {1, 3},
            {1, 5},
            {3, 1},
            {3, 3},
            {3, 5},
            {5, 1},
            {5, 3},
            {5, 5},
    };

    private final int[][] tripleSquare = {
            {1, 1},
            {1, 3},
            {1, 5},
            {1, 7},
            {3, 1},
            {3, 3},
            {3, 5},
            {3, 7},
            {5, 1},
            {5, 3},
            {5, 5},
            {5, 7},
            {7, 1},
            {7, 3},
            {7, 5},
            {7, 7},
    };

    private final int[][] fourSquares = {
            {1, 1},
            {1, 3},
            {1, 5},
            {1, 7},
            {1, 9},

            {3, 1},
            {3, 3},
            {3, 5},
            {3, 7},
            {3, 9},

            {5, 1},
            {5, 3},
            {5, 5},
            {5, 7},
            {5, 9},

            {7, 1},
            {7, 3},
            {7, 5},
            {7, 7},
            {7, 9},

            {9, 1},
            {9, 3},
            {9, 5},
            {9, 7},
            {9, 9}
    };

    private final int[][] complexSquareInSquare = {
            {1, 1},
            {1, 3},
            {1, 5},
            {1, 7},
            {1, 9},
            {2, 4},
            {2, 5},
            {2, 6},
            {3, 1},
            {3, 3},
            {3, 4},
            {3, 5},
            {3, 6},
            {3, 7},
            {3, 9},
            {4, 4},
            {4, 5},
            {4, 6},
            {5, 1},
            {5, 3},
            {5, 5},
            {5, 7},
            {5, 9},
            {6, 4},
            {6, 5},
            {6, 6},
            {7, 1},
            {7, 3},
            {7, 4},
            {7, 5},
            {7, 6},
            {7, 7},
            {7, 9},
            {8, 4},
            {8, 5},
            {8, 6},
            {9, 1},
            {9, 3},
            {9, 5},
            {9, 7},
            {9, 9}
    };

    private final int[][] absurdlyBigSquare = {
            {1, 1},
            {1, 3},
            {1, 5},
            {1, 7},
            {1, 9},
            {1, 11},

            {3, 1},
            {3, 3},
            {3, 5},
            {3, 7},
            {3, 9},
            {3, 11},

            {5, 1},
            {5, 3},
            {5, 5},
            {5, 7},
            {5, 9},
            {5, 11},

            {7, 1},
            {7, 3},
            {7, 5},
            {7, 7},
            {7, 9},
            {7, 11},

            {9, 1},
            {9, 3},
            {9, 5},
            {9, 7},
            {9, 9},
            {9, 11},

            {11, 1},
            {11, 3},
            {11, 5},
            {11, 7},
            {11, 9},
            {11, 11}
    };

    public int[][] getOneSquare() {
        return oneSquare;
    }

    public int[][] getDoubleSquare() {
        return doubleSquare;
    }

    public int[][] getTripleSquare() {
        return tripleSquare;
    }

    public int[][] getFourSquares() {
        return fourSquares;
    }

    public int[][] getComplexSquareInSquare() {
        return complexSquareInSquare;
    }

    public int[][] getAbsurdlyBigSquare() {
        return absurdlyBigSquare;
    }

    int countNumberOfSquares(int[][] coordinates) {
        Map<String, String> coordinatesInMap = new HashMap<>();

        for (int[] coordinate : coordinates) {
            coordinatesInMap.put((coordinate[0] + " " + coordinate[1]), null);
        }

        int count = 0;
        int[] startCoordinate = findSmallestCoordinates(coordinates);
        int[] endCoordinate = findBiggestCoordinates(coordinates);
        int endLoop = Math.max(endCoordinate[0] - startCoordinate[0] + 1, endCoordinate[1] - startCoordinate[1] + 1);

        for (int[] coordinate : coordinates) {
            // search for number of square starting from a coordinate
            for (int j = 1; j < endLoop; j++) {
                if (coordinatesInMap.containsKey((coordinate[0] + j) + " " + coordinate[1])
                        && coordinatesInMap.containsKey(coordinate[0] + " " + (coordinate[1] + j))
                        && coordinatesInMap.containsKey((coordinate[0] + j) + " " + (coordinate[1] + j))) {
                    count++;
                }
            }
        }

        return count;
    }

    int[] findSmallestCoordinates(int[][] coordinates) {
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        for (int[] coordinate : coordinates) {
            if (coordinate[0] < minX) {
                minX = coordinate[0];
            }

            if (coordinate[1] < minY) {
                minY = coordinate[1];
            }
        }

        return new int[]{minX, minY};
    }

    int[] findBiggestCoordinates(int[][] coordinates) {
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        for (int[] coordinate : coordinates) {
            if (coordinate[0] > maxX) {
                maxX = coordinate[0];
            }

            if (coordinate[1] > maxY) {
                maxY = coordinate[1];
            }
        }

        return new int[]{maxX, maxY};
    }
}
