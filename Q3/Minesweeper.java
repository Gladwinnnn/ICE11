import java.util.Random; 

public class Minesweeper{
    public char[][] board;

    public Minesweeper(int numRows, int numColumns, int numBombs){
        board = new char[numRows][numColumns];
        placeBombs(numBombs);
        countBombs();
    }

    private void countBombs(){
        for (int i = 0; i < 4; i ++){
            for (int j = 0; j < 5; j ++){
                if (board[i][j] != 'B'){
                    board[i][j] = '0';
                }
            }
        }

        for (int i = 0; i < 4; i ++){
            for (int j = 0; j < 5; j ++){
                if (board[i][j] == 'B'){
                    if (i < 3 && board[i+1][j] != 'B'){
                        board[i+1][j] += 1;
                    }
                    if (i < 3 && j < 4 && board[i+1][j+1] != 'B'){
                        board[i+1][j+1] += 1;
                    }
                    if (i > 0 && board[i-1][j] != 'B'){
                        board[i-1][j] += 1;
                    }
                    if (i > 0 && j > 0 && board[i-1][j-1] != 'B'){
                        board[i-1][j-1] += 1;
                    }
                    if (j < 4 && board[i][j+1] != 'B'){
                        board[i][j+1] += 1;
                    }
                    if (j > 0 && board[i][j-1] != 'B'){
                        board[i][j-1] += 1;
                    }
                    if (i > 0 && j < 4 && board[i-1][j+1] != 'B'){
                        board[i-1][j+1] += 1;
                    }
                    if (i < 3 && j > 0 && board[i+1][j-1] != 'B'){
                        board[i+1][j-1] += 1;
                    }
                }
            }
        }
    }

    private void placeBombs(int numBombs){
        Random random = new Random(); 
        while (numBombs > 0){
            int randomRows = random.nextInt(4); 
            int randomColumns = random.nextInt(5); 
            if (board[randomRows][randomColumns] == '\u0000'){
                board[randomRows][randomColumns] = 'B';
                numBombs--;
            }
        }
    }

    public String toString(){
        String result = "";
        for (int i = 0; i < 4; i ++){
            for (int j = 0; j < 5; j ++){
                if (board[i][j] == 'B'){
                    result += board[i][j] + "|";
                } else if (board[i][j] == '0'){
                    result += "-|"; 
                } else{
                    result += board[i][j] + "|";
                }
            }
            result += "\n";
        }
        return result;
    }
}