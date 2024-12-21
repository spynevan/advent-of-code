package AoC2024.Day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AoC2024Day5b {
    public static void main(String[] args) {
        File file1 = new File("src/AoC2024/Day5/input.txt");
        File file2 = new File("src/AoC2024/Day5/input2.txt");
        Scanner scanner;
        try{
            scanner = new Scanner(file1);

        }
        catch(FileNotFoundException e){
            System.out.println("Error: File not found" + e.getMessage());
            return;
        }
        int[][] pageMatrix = new int[100][100];

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j <= i; j++) {
                pageMatrix[i][j] = 0;
            }
        }

        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] lineArray = line.split("\\|");
            int x = Integer.parseInt(lineArray[0]);
            int y = Integer.parseInt(lineArray[1]);
            if(x < y){
                pageMatrix[y][x] = 1;
            }
            else{
                pageMatrix[x][y] = -1;
            }
        }

        try{
            scanner = new Scanner(file2);
        }
        catch(FileNotFoundException e){
            System.out.println("Error: File not found" + e.getMessage());
            return;
        }

        int answer = 0;
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] lineArray = line.split(",");
            var newArray = new int[lineArray.length];
            for(int i = 0; i < lineArray.length; i++){
                newArray[i] = Integer.parseInt(lineArray[i]);
            }
            if(testLine(newArray, pageMatrix) != 0){
                continue;
            }
            answer += fixLine(newArray, pageMatrix);

        }
        System.out.println(answer);
    }
    static int testLine(int[] line, int[][] pageMatrix){
        int a,b;
        for(int i = 0; i < line.length - 1; i++){
            for(int j = i + 1; j < line.length; j++){
                a = line[i];
                b = line[j];
                if(pageMatrix[a][b] != -1 && a > b ){
                    return 0;
                }
                if(pageMatrix[b][a] != 1 && b > a ){
                    return 0;
                }
            }
        }
        return line[line.length / 2];
    }
    static int fixLine(int[] line, int[][] pageMatrix){
        return fixLine(line, pageMatrix, line.length);

    }
    static int fixLine(int[] line, int[][] pageMatrix, int index){
        if(index == -1) return line[line.length / 2];
        if(findInversion(line, pageMatrix, index) == 0) return fixLine(line, pageMatrix, index - 1);
        int a = line[index];
        int b = line[index + 1];
        line[index] = b;
        line[index + 1] = a;
        return fixLine(line, pageMatrix, index + 1);
    }

    static int findInversion(int[] line, int[][] pageMatrix, int index){
        int a,b;
        for(int i = index; i < line.length; i++){
            for(int j = i + 1; j < line.length; j++){
                if(i == j) continue;
                a = line[i];
                b = line[j];
                if(pageMatrix[a][b] == -1 && a > b ){
                    return 1;
                }
                if(pageMatrix[b][a] == 1 && b > a ){
                    return 1;
                }
            }
        }
        return 0;
    }
}
