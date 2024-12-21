package AoC2024.Day5;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class AoC2024Day5a {
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
            answer += testLine(newArray, pageMatrix);
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
}
