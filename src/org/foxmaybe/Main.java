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
        Integer Pos, PosX = 0, PosO = 0;
        Boolean WhoseMove = Boolean.TRUE;
        Scanner Scan = new Scanner(System.in);

        PrintFrame(PlayingField);

        for(int i=0; i<9; i-=-1){

            System.out.print("\nEnter your placement (1-9):");
            Pos = Scan.nextInt();
            Integer Cord = Move(Pos);

            if(PlayingField[Cord / 10][Cord % 10] == ' ') {
                PlayingField[Cord / 10][Cord % 10] = XOrO(WhoseMove);
                if(WhoseMove) PosX += Cord;
                else PosO += Cord;
                WhoseMove = !WhoseMove;
            }
            else{
                System.out.println("\nOccupied cell, select another one");
                i--;
            }
            if(PrintWin(PosX, PosO))
                break;
            if(i>=9){
                System.out.println("Beaten by no one!");
            }
            PrintFrame(PlayingField);
        }



    }

    public static char XOrO(Boolean WhoseMove){ // X or O
        if(WhoseMove)
            return 'x';
        else
            return 'o';
    }
    public static Boolean PrintWin(Integer PosX, Integer PosO){
        if(WhoseWin(PosX)) {
            System.out.println("X win is game!");
            return Boolean.TRUE;
        }
        if(WhoseWin(PosO)){
            System.out.println("X win is game!");
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public static Boolean WhoseWin(Integer Pos){
        Integer[] WinPos = {6,66,126,60,72};
        for(Integer pos : WinPos){
            if(Pos == pos)
                return Boolean.TRUE;
        }
        return Boolean.FALSE;
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
