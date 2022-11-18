public class RealSolution {
    public static void main(String[] args) {
        int[] vc = getCases();
        System.out.println(computeArea(vc[0], vc[1], vc[2], vc[3], vc[4], vc[5], vc[6], vc[7]));
    }

    // I never think that the corner always would be the same :p
    private static int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int areaOfA = (ay2 - ay1) * (ax2 - ax1);
        int areaOfB = (by2 - by1) * (bx2 - bx1);

        // calculate x overlap
        int left = Math.max(ax1, bx1);
        int right = Math.min(ax2, bx2);
        int xOverlap = right - left;

        // calculate y overlap
        int top = Math.min(ay2, by2);
        int bottom = Math.max(ay1, by1);
        int yOverlap = top - bottom;

        // if the rectangles overlap each other, then calculate
        // the area of the overlap
        int areaOfOverlap = (xOverlap > 0 && yOverlap > 0) ? xOverlap * yOverlap : 0;

        return areaOfA + areaOfB - areaOfOverlap;
    }

    public static int[] getCases() {
        //return new int[] {-3, 0, 3, 4, 0, -1, 9, 2};
        //return new int[] {-2, -2, 2, 2, -2, -2, 2, 2};
        //return new int[]{-2, -2, 2, 2, 3, 3, 4, 4};
        //return new int[] {-2, -2, 2, 2, -4, 3, -3, 4};
        return new int[] {-2, -2, 2, 2, -1, -1, 1, 1};
    }
}
