import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = new int[10][10];
        System.out.println("The element matrix[0][1] is: " + matrix[0][1]);
        populateArray(matrix);
        System.out.println("matrix is populated with random numbers 0-9:");
        printArray(matrix);
        System.out.print("\nThe total sum of all matrix elements is: " + sumAllElements(matrix));
        System.out.println("\nPrinting the sum each column: ");
        sumElementsByColumn(matrix);
        System.out.println("\nPrinting the result of method that finds the row with max sum: ");
        rowWithLargesSum(matrix);
        System.out.println("\nShuffling the elements ot the matxix: ");
        randomShuffling(matrix);
        printArray(matrix);
        System.out.print("\nThe total sum of all matrix elements after shuffling is : " + sumAllElements(matrix));
    }

    public static void populateArray(int[][] list) {
        for (int row = 0; row < list.length; row++) {
            for (int column = 0; column < list[row].length; column++) {
                list[row][column] = (int) (Math.random() * 10);
            }
        }
    }

    public static void printArray(int[][] list) {
        for (int row = 0; row < list.length; row++) {
            for (int column = 0; column < list[row].length; column++) {
                System.out.print(list[row][column] + " ");
            }
            System.out.println();
        }
    }

    public static int sumAllElements(int[][] list) {
        int total = 0;
        for (int row = 0; row < list.length; row++) {
            for (int column = 0; column < list[row].length; column++) {
                total += list[row][column];
            }
        }
        return total;
    }

    public static void sumElementsByColumn(int[][] list) {
        for (int column = 0; column < list[0].length; column++) {
            int total = 0;
            for (int row = 0; row < list.length; row++)
                total += list[row][column];
            System.out.println("Sum for column " + column + " is: " + total);
        }
    }

    public static void rowWithLargesSum(int[][] list) {
        int maxRow = 0;
        int indexOfMaxRow = 0;

        //finding the sum of the first column
        for (int column = 0; column < list[0].length; column++) {
            maxRow += list[0][column];
        }

        for (int row = 1; row < list.length; row++) {
            int totalOfThisRow = 0;
            for (int column = 1; column < list[row].length; column++)
                totalOfThisRow += list[row][column];

            if (totalOfThisRow > maxRow) {
                maxRow = totalOfThisRow;
                indexOfMaxRow = row;
            }
        }
        System.out.println("The row with index: " + indexOfMaxRow + " has the maximum sum which is: " + maxRow);
    }

    public static void randomShuffling(int[][] list) {
        for (int row = 0; row < list.length; row++) {
            for (int column = 0; column < list[row].length; column++) {
                int i1 = (int) (Math.random() * list.length);
                int j1 = (int) (Math.random() * list[row].length);

                int temp = list[row][column];
                list[row][column] = list[i1][j1];
                list[i1][j1] = temp;
            }
        }
    }
}