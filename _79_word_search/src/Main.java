import java.util.Arrays;
import java.util.Map;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        char[][] cases = getCases();
        String word = getWord();
        System.out.println(exist(cases, word));
    }

    private static String getWord() {
       // return "ABCCED";
        return "SEE";
    }

    private static char[][] getCases() {
        //return new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        return new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
    }

    public static boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                char val = board[i][j];
                if (val == word.charAt(0)){
                    if(search(board, word, i, j, 0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static boolean search(char[][] board, String word, int i, int j, int index) {

        if (index == word.length()) return true;

        if (i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j] != word.charAt(index) ) {
            return false;
        }
        if (board[i][j] == '#') {
            return false;
        }
        char tmp = board[i][j];
        board[i][j] = '#';

        boolean found =
                search(board, word, (i-1), j, (index+1)) || //up
                        search(board, word, (i+1), j, (index+1)) || //down
                        search(board, word, i, (j-1), (index+1)) || //left
                        search(board, word, i, (j+1), (index+1)); //right

        board[i][j] = tmp;
        return found;
    }

}