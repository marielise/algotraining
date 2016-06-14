package com.main;

public class ABoardGame {

    private final static String ALICE = "Alice";
    private final static String DRAW = "Draw";
    private final static String BOB = "Bob";


    public String whoWins(String[] board) {

        int n = board.length/2;
        int []scoreA = new int[n];
        int []scoreB = new int[n];

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                int r = getRegion(i,j,n);
                char ch = board[i].charAt(j);
                if (ch == 'A'){
                    scoreA[r]++;
                } else if (ch == 'B'){
                    scoreB[r]++;
                }
            }
        }

        //compute score
        for(int i = n-1; i > -1; i--){
            if(scoreA[i] > scoreB[i]){
                return ALICE;
            } else if (scoreA[i] < scoreB[i]) {
                return BOB;
            }
        }

        return DRAW;
    }

    private int getRegion(int r, int c, int n){
        int row = r - n;
        int col = c - n;
        if(row >= 0){
            row++;
        }
        if(col >=0){
            col++;
        }

        return Math.abs(col*row) % n;
    }

    public void testGetRegion(){

        assert getRegion(0,0,2) == 0;

        assert getRegion(0,1,2) == 0;

        assert getRegion(1,1,2) == 1;

        assert getRegion(1,1,3) == 1;

        assert getRegion(2,3,3) == 2;

        assert getRegion(4,4,3) == 1;

    }


    public static void main(String[] args) {
        ABoardGame a = new ABoardGame();
        a.testGetRegion();

        String []a1={".....A",
                "......",
                "..A...",
                "...B..",
                "......",
                "......"};
        assert a.whoWins(a1).equals(ALICE);

        String []b1 = {"AAAA",
                "A.BA",
                "A..A",
                "AAAA"};

        assert a.whoWins(b1).equals(BOB);

        String []d = {"..",
                ".."};

        assert a.whoWins(d).equals(DRAW);

        String []a2 = {"BBB..BAB...B.B",
                ".AAAAAAAAAAAA.",
                "AA.AA.AB..A.AB",
                "..........B.AB",
                ".A..BBAB.A.BAB",
                ".AB.B.......A.",
                ".A..A.AB.A..AB",
                ".ABAA.BA...BA.",
                "BAAAB.....ABA.",
                ".A....B..A..B.",
                "B...B....B..A.",
                "BA.B..A.ABA.A.",
                "BAAAA.AAAAA.A.",
                "B.B.B.BB.B...."};

        assert a.whoWins(a2).equals(ALICE);

        String []b2 = {"..A..AAA..AA",
                "ABABB..AAAAA",
                "ABBBBBBBBBA.",
                "AABBBABABBAA",
                "...BABABABBA",
                "B.BA..A.BBA.",
                "AA.A..B.AB.B",
                "..BA.B.AABAA",
                "..ABABBBABA.",
                ".ABB.BBBBBAA",
                "ABAAA.AA.A.A",
                "A..AAA.AAA.A"};

        assert a.whoWins(b2).equals(BOB);

        String []d1 = {"B..ABAABBB",
                "B.........",
                "A..A.AA..B",
                "A.BBBAA..A",
                "B.AAAAB...",
                "A..BBBBB.A",
                "B..ABAABBA",
                "A......B.B",
                "B......A.A",
                "BA.AABBB.A"};

        assert a.whoWins(d1).equals(DRAW);

    }
}
