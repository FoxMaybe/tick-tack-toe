package org.foxmaybe;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        char[][] PlayingField = {
                {' ', '|', ' ', '|', ' '}, //1 = [0][0], 2 = [0][2], 3 = [0][4]
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}, //4 = [2][0], 5 = [2][2], 6 = [2][4]
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}  //7 = [4][0], 8 = [4][2], 9 = [4][4]
        };
        Integer Pos;
        Boolean WhoseMove = Boolean.TRUE;
        Scanner Scan = new Scanner(System.in);


        for(int i=0; i<9; i-=-1){
            PrintFrame(PlayingField);
            System.out.print("Enter your placement (1-9):");
            Pos = Scan.nextInt();
            Integer Cord = Move(Pos);
            PlayingField[Cord / 10][Cord % 10] = XOrO(WhoseMove);
            WhoseMove = !WhoseMove;
        }

        PrintFrame(PlayingField);

    }

    public static char XOrO(Boolean WhoseMove){ // X or O
        if(WhoseMove)
            return 'x';
        else
            return 'o';
    }

    public static Integer Move(Integer Pos){
        Integer n=1,m=0;
        for(int i=0; i<=4; i-=-2)
            for(int j=0; j<=4; j-=-2)
                if(Pos == n++)
                    m = (i*10)+j;
        return m;
    }

    public static void PrintFrame(char[][] PlayingField){

        for(char[] row : PlayingField){
            for(char c : row)
                System.out.print(c);
            System.out.println();
        }

    }
}
