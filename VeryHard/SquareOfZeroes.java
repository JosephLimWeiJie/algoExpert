package VeryHard;

import java.util.*;

class Program {

    public static boolean squareOfZeroes(List<List<Integer>> matrix) {

        // Time:  O(n ^ 3)
        // Space: O(n ^ 2)

        Pair[][] auxMatrix = getAuxMatrix2(matrix);
        // printMatrix(auxMatrix);

        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                int squareLength = 2;
                while (squareLength <= matrix.size() - j && squareLength <= matrix.size() - i) {
                    int bottomRow = i + squareLength - 1;
                    int rightCol = j + squareLength - 1;

                    if (isSquareOfZeroes(auxMatrix, i, j, bottomRow, rightCol)) {
                        return true;
                    }

                    squareLength++;
                }
            }
        }

        return false;
    }

    public static boolean isSquareOfZeroes(Pair[][] auxMatrix, int r1, int c1, int r2, int c2) {
        int squareLength = c2 - c1 + 1;

        boolean hasTopBorder = auxMatrix[r1][c1].second >= squareLength;
        boolean hasLeftBorder = auxMatrix[r1][c1].first >= squareLength;
        boolean hasBottomBorder = auxMatrix[r2][c1].second >= squareLength;
        boolean hasRightBorder = auxMatrix[r1][c2].first >= squareLength;

        return hasTopBorder && hasLeftBorder && hasBottomBorder && hasRightBorder;
    }

    public static Pair[][] getAuxMatrix2(List<List<Integer>> matrix) {
        Pair[][] auxMatrix = new Pair[matrix.size()][matrix.size()];

        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.size(); j++) {
                int numZeroes = matrix.get(i).get(j) == 0 ? 1 : 0;
                auxMatrix[i][j] = new Pair(numZeroes, numZeroes);
            }
        }

        for (int i = matrix.size() - 1; i >= 0; i--) {
            for (int j = matrix.size() - 1; j >= 0; j--) {
                if (matrix.get(i).get(j) == 1) {
                    continue;
                }

                if (i < matrix.size() - 1) {
                    int updatedFirst = auxMatrix[i + 1][j].first + auxMatrix[i][j].first;
                    auxMatrix[i][j] = new Pair(updatedFirst, auxMatrix[i][j].second);
                }

                if (j < matrix.size() - 1) {
                    int updatedSecond = auxMatrix[i][j + 1].second + auxMatrix[i][j].second;
                    auxMatrix[i][j] = new Pair(auxMatrix[i][j].first, updatedSecond);
                }

            }
        }

        return auxMatrix;
    }

    public static Pair[][] getAuxMatrix(List<List<Integer>> matrix) {
        Pair[][] auxMatrix = new Pair[matrix.size()][matrix.get(0).size()];

        int lastRowId = matrix.size() - 1;
        int lastColId = matrix.get(matrix.size() - 1).size() - 1;

        if (matrix.get(lastRowId).get(lastColId) == 0) {
            auxMatrix[lastRowId][lastColId] = new Pair(1, 1);
        } else {
            auxMatrix[lastRowId][lastColId] = new Pair(0, 0);
        }

        for (int i = lastRowId; i >= 0; i--) {
            if (matrix.get(i).get(lastColId) == 1) {
                auxMatrix[i][lastColId] = new Pair(0, 0);
            } else {
                Pair prev = auxMatrix[i][lastColId + 1];
                if (matrix.get(i).get(lastColId + 1) == 0) {
                    auxMatrix[i][lastColId] = new Pair(prev.first + 1, 1);
                } else {
                    auxMatrix[i][lastColId] = new Pair(1, 1);
                }
            }
        }

        // In Pair(x, y), x -> num of zeroes accumulated from bottom, y -> num of zeroes accumulated from right
        for (int i = matrix.size() - 1; i >= 0; i--) {
            for (int j = matrix.get(i).size() - 1; j >= 0; j--) {
                if (j == matrix.get(i).size() - 1) {
                    continue;
                }

                if (matrix.get(i).get(j) == 1) {
                    auxMatrix[i][j] = new Pair(0, 0);
                } else {
                    checkRight(matrix, i, j, auxMatrix);
                    if (i == matrix.size() - 1) {
                        continue;
                    } else {
                        checkBottom(matrix, i, j, auxMatrix);
                    }
                }
            }
        }

        return auxMatrix;
    }

    public static void checkRight(List<List<Integer>> matrix, int row, int col, Pair[][] auxMatrix) {
        if (matrix.get(row).get(col + 1) == 1) {
            auxMatrix[row][col] = new Pair(1, 1);
        } else if (matrix.get(row).get(col + 1) == 0) {
            Pair beside = auxMatrix[row][col + 1];
            auxMatrix[row][col] = new Pair(1, beside.second + 1);
        }
    }

    public static void checkBottom(List<List<Integer>> matrix, int row, int col, Pair[][] auxMatrix) {
        Pair curr = auxMatrix[row][col];
        if (matrix.get(row + 1).get(col) == 1) {
            auxMatrix[row][col] = new Pair(1, curr.second);
        } else if (matrix.get(row + 1).get(col) == 0) {
            Pair below = auxMatrix[row + 1][col];
            auxMatrix[row][col] = new Pair(below.first + 1, curr.second);
        }
    }

    public static void printMatrix(Pair[][] matrix) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == null) {
                    sb.append("null, ");
                } else {
                    sb.append(matrix[i][j] + ", ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }


    public static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public String toString() {
            return "(" + this.first + " , " + this.second + ")";
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(Arrays.asList(0, 0));
        matrix.add(Arrays.asList(0, 0));


        System.out.println(squareOfZeroes(matrix));
    }

}
