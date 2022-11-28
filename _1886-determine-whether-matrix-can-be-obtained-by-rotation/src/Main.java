import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] cases = getCases();
        int[][] target = getTarget();
        System.out.println(findRotation(cases, target));
    }

    public static boolean findRotation(int[][] mat, int[][] target){
        if (mat == target)  return true;


        int[][] res = extract(mat); //clockwise 90
        int[][] res2 = extract(res); //clockwise 180
        int[][] res3 = extract(res2); //clockwise 270

        return Arrays.deepEquals(target, res) ||
                Arrays.deepEquals(target, res2) ||
                Arrays.deepEquals(target, res3) ||
                Arrays.deepEquals(target, mat);
    }

    private static int[][] extract(int[][] origin) {
        int[][] newRes = new int[origin.length][origin.length];
        for (int i = 0; i < origin.length; i++) {
            for (int j = 0; j < origin.length; j++) {
                newRes[i][j] = origin[origin.length - 1 - j][i];
            }
        }

        return newRes;
    }

    public static int[][] getCases(){
        return new int[][]{{0, 0, 0},{0, 1, 0},{1, 1, 1}};
    }

    public static int[][] getTarget(){
        return new int[][]{{1,1,1},{0,1,0},{0,0,0}};
    }
}