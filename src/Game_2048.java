import java.util.Scanner;

public class Game_2048 {
    public static short[][] up(short[][] table){ //위로 올릴경우
        short num;
        byte count;
        byte n = (byte)table.length;
        short[][] new_table  = new short[n][n];

        for(byte j=0; j<n; j++) { //열(j)
            num = 0;
            count = 0;
            for(byte i=0; i<n; i++) { //행(i)
                if(table[i][j] != 0) {
                    if(num==0) {
                        num=table[i][j];
                    }
                    else if(num==table[i][j]) {
                        new_table[count][j]=(short)(num*2);
                        num=0;
                        count++;
                    }
                    else {
                        new_table[count][j]=num;
                        num=table[i][j];
                        count++;
                    }
                }
            }
            if(num!=0) {
                new_table[count][j]=num;
            }
        }
        return new_table;
    }

    public static short[][] down(short[][] table){ //아래로 내릴경우
        short num;
        byte count;
        byte n = (byte) table.length;
        short[][] new_table  = new short[n][n];

        for(byte j=0; j<n; j++) { //열(j)
            num = 0;
            count = (byte)(n-1);
            for(byte i=(byte)(n-1); i>=0; i--) { //행(i)
                if(table[i][j] != 0) {
                    if(num==0) {
                        num=table[i][j];
                    }
                    else if(num==table[i][j]) {
                        new_table[count][j]=(short)(num*2);
                        num=0;
                        count--;
                    }
                    else {
                        new_table[count][j]=num;
                        num=table[i][j];
                        count--;
                    }
                }
            }
            if(num!=0) {
                new_table[count][j]=num;
            }
        }
        return new_table;
    }

    public static short[][] left(short[][] table){ //왼쪽으로 이동할경우
        short num;
        byte count;
        byte n = (byte)table.length;
        short[][] new_table  = new short[n][n];

        for(byte i=0; i<n; i++) { //행(i)
            num = 0;
            count = 0;
            for(byte j=0; j<n; j++) { //열(j)
                if(table[i][j] != 0) {
                    if(num==0) {
                        num=table[i][j];
                    }
                    else if(num==table[i][j]) {
                        new_table[i][count]=(short)(num*2);
                        num=0;
                        count++;
                    }
                    else {
                        new_table[i][count]=num;
                        num=table[i][j];
                        count++;
                    }
                }
            }
            if(num!=0) {
                new_table[i][count]=num;
            }
        }
        return new_table;
    }

    public static short[][] right(short[][] table){ //오른쪽으로 이동할경우
        short num;
        byte count;
        byte n = (byte)table.length;
        short[][] new_table  = new short[n][n];

        for(byte i=0; i<n; i++) { //행(i)
            num = 0;
            count = (byte)(n-1);
            for(byte j=(byte)(n-1); j>=0; j--) { //열(j)
                if(table[i][j] != 0) {
                    if(num==0) {
                        num=table[i][j];
                    }
                    else if(num==table[i][j]) {
                        new_table[i][count]=(short)(num*2);
                        num=0;
                        count--;
                    }
                    else {
                        new_table[i][count]=num;
                        num=table[i][j];
                        count--;
                    }
                }
            }
            if(num!=0) {
                new_table[i][count]=num;
            }
        }
        return new_table;
    }

    public static short[][] way(short[][] table,String way){ //방향을 선택하여 실행하는 메소드
        switch (way) {
            case "up" -> table = up(table);
            case "down" -> table = down(table);
            case "left" -> table = left(table);
            case "right" -> table = right(table);
            default -> {
            }
        }
        return table;
    }

    public static void main(String[] args) {
        // Your Program Goes Here
        Scanner sc = new Scanner(System.in);
        byte num = sc.nextByte(); //개수 n 입력
        short max = 0;
        short[][] table = new short[num][num];
        short[][] table_2;
        String[] list = {"up","down","left","right"};

        for(byte i=0; i<num; i++) { //값 입력
            for(byte j=0; j<num; j++) {
                table[i][j] = sc.nextShort();
            }
        }
        //모든 경우의수 구하는 알고리즘
        for(String way_1 : list) {
            for(String way_2 : list) {
                for(String way_3 : list) {
                    for(String way_4 : list) {
                        for(String way_5 : list) {
                            table_2 = way(way(way(way(way(table,way_1),way_2),way_3),way_4),way_5); //5번 이동한 table
                            for (byte i = 0; i < num; i++) {
                                for (byte j = 0; j < num; j++) {
                                    max=(short)Math.max(max, table_2[i][j]); //값을 비교해서 최대값 고르기
                                }
                            }

                        }
                    }
                }
            }
        }
        System.out.println(max); //최대값 출력
    }
}