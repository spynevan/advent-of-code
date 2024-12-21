package AoC2024.Day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class AoC2024Day4b {
    public static void main(String[] args) {
        File file = new File("src/AoC2024/Day4/input.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        }
        catch(FileNotFoundException e){
            System.out.println("Error: File not found" + e.getMessage());
            return;
        }

        int answer = 0;
        var wordSearch = new ArrayList<String>();
        while (scanner.hasNext()) {
            wordSearch.add(scanner.nextLine());
        }

        for(int i = 1; i < wordSearch.size()-1; i++){
            for(int j = 1; j < wordSearch.get(i).length()-1; j++){
                answer += testLocation(i, j, wordSearch);
            }
        }

        System.out.println(answer);

    }

    static int testLocation(int x, int y, ArrayList<String> wordSearch){
        if(wordSearch.get(x).charAt(y) != 'A'){
            return 0;
        }

        String s1 = wordSearch.get(x-1).charAt(y-1) + "A" + wordSearch.get(x+1).charAt(y+1);
        String s2 = wordSearch.get(x-1).charAt(y+1) + "A" + wordSearch.get(x+1).charAt(y-1);

        if(!(s1.equals("MAS") || s1.equals("SAM"))){
            return 0;
        }
        if(!(s2.equals("MAS") || s2.equals("SAM"))){
            return 0;
        }

        return 1;
    }
}
