public class GameOfLife {
    /**
     * @author Harold Sellappan
     * class for lab6
     * sets up game of life
     */
    private boolean[][] board;
    private final int NUMCOL;
    private final int NUMROW;

    public GameOfLife(boolean[][] initialBoard)
    {
        NUMROW =initialBoard.length;
        NUMCOL = initialBoard[0].length;
        board = initialBoard;
    }

    public String toString()
    {
        String boardString = "";
        for(int i = 0; i<NUMROW;i++)
        {
            for(int j = 0; j<NUMCOL;j++)
            {
                if(board[i][j]==false)
                {
                    boardString =  boardString+"+";
                }
                else if(board[i][j]==true)
                {
                    boardString = boardString+"O";
                }
                if(j==NUMCOL-1)
                {
                    boardString = boardString+"\n";
                }
                else{
                    boardString = boardString+" ";
                }
            }
        }
        return boardString;
    }
    public void grow(int generation, int freqPrint)
    {
        boolean[][]newLife = new boolean[NUMROW][NUMCOL];
        int iter = 0;

        while(generation>0) {

            for (int i = 0; i < board.length; i++)
            {
                for (int j = 0; j < board[i].length; j++)
                {
                    boolean isLiving = board[i][j];
                    int numOfNeighbors = checkNeighbor(i, j);
                    if (numOfNeighbors == 3)
                    {
                        newLife[i][j] = true;
                    }
                    else if (numOfNeighbors > 3 || numOfNeighbors==1 || numOfNeighbors==0)
                    {
                        newLife[i][j] = false;
                    }
                    else if (numOfNeighbors==2 && board[i][j]==true)
                    {
                        newLife[i][j] = true;
                    }
                }
            }
            for(int i =0; i< NUMROW-1; i++)
            {
                for(int j = 0; j<NUMCOL -1; j++)
                {
                    board[i][j] = newLife[i][j];
                }
            }

            if(generation%freqPrint == 0)
            {
                System.out.println(this.toString());
                iter++;
            }
            generation--;

        }

    }

    private int checkNeighbor(int x, int y)
    {
        int rowBounds = NUMROW-1;
        int columnBounds = NUMCOL-1;
        int numOfOccupiedSpaces = 0;
        if(x!=0 && y!=0)
        {
            int outsideCount = 0;
            if(board[x-1][y-1]==true)
            {
                numOfOccupiedSpaces++;
            }

        }
         if(x!=0)
        {
            int outsideCount = 0;
            if(board[x-1][y]==true)
            {
                numOfOccupiedSpaces++;
            }


        }
        if(x!=0 && y!=NUMCOL-1)
        {
            int outsideCount = 0;
            if(board[x-1][y+1]==true )
                numOfOccupiedSpaces++;

        }
        if(y!=0)
        {
            int outsideCount = 0;
            if(board[x][y-1]==true)
                numOfOccupiedSpaces++;

        }
        if(y!=NUMCOL-1)
        {
            int newCount = 0;
            if(board[x][y+1]==true)

                numOfOccupiedSpaces++;
        }
        if(x!=NUMROW-1 && y!=0)
        {
            int varCount = 0;
            if(board[x+1][y-1]==true)
                numOfOccupiedSpaces++;

        }
        if(x!=NUMROW-1)
        {
            int lCount = 0;
            if(board[x+1][y]==true)
                numOfOccupiedSpaces++;

        }
        if(x!=NUMROW-1 && y!=NUMCOL-1)
        {
            int VCount = 0;
            if(board[x+1][y+1]== true)
                numOfOccupiedSpaces++;

        }
        return numOfOccupiedSpaces;
    }
}


