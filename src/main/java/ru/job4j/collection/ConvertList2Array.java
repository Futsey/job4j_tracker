package ru.job4j.collection;

import java.util.List;

public class ConvertList2Array {

    public static int[][] toArray(List<Integer> list, int cells) {
        int groups = (int) Math.ceil((double) list.size() / cells);
        int[][] dimensArray = new int[groups][cells];
        int row = 0, cell = 0;
        for (Integer num : list) {
            if (cell < groups) {
                dimensArray[row][cell] = num;
                cell++;
            } else if (row < groups) {
                row++;
                cell = 0;
                dimensArray[row][cell] = num;
                cell++;
            }
        }
        return dimensArray;
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7);
        int[][] dimensRsl = toArray(list, 3);
        for (int[] row : dimensRsl) {
            for (int cell : row) {
                System.out.println(cell + " ");
            }
            System.out.println();
        }
    }
}
