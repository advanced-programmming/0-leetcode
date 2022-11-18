
/* this was my approach but i tak a lot of time, and it does'nt pass the test.*/
public class Main {
    public static void main(String[] args) {
        int[] vc = getCases();
        System.out.println(computeArea(vc[0], vc[1], vc[2], vc[3], vc[4], vc[5], vc[6], vc[7]));
    }

    public static int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int rec1 = getAreaRectangle(ax1, ay1, ax2, ay2);
        int rec2 = getAreaRectangle(bx1, by1, bx2, by2);
        int inter = validateIntersection(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2);
        return (rec1 + rec2) - inter;
    }

    private static int validateIntersection(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int minInitB = Math.min(ax1, ax2);
        int maxInitB = Math.max(ax1, ax2);
        int maxInitH = Math.max(ay1, ay2);
        int minInitH = Math.min(ay1, ay2);

        int newB = calculateNewRectangle(minInitB, maxInitB, bx1, bx2);
        int newH = calculateNewRectangle(minInitH, maxInitH, by1, by2);

        return newB * newH;
    }

    private static int calculateNewRectangle(int minInit, int maxInit, int m1, int m2) {
        int pointInRectangle = Integer.MIN_VALUE;
        if ((minInit <= m1) && (m1 <= maxInit)) pointInRectangle =  m1;
        else if ((minInit <= m2) && (m2 <= maxInit)) pointInRectangle =  m2;

        if (pointInRectangle != Integer.MIN_VALUE){
            boolean isMinPoint = pointInRectangle == Math.min(m1, m2);
            return isMinPoint ? Math.abs(pointInRectangle - maxInit) : Math.abs(minInit - Math.max(m1, m2));
        } else return 0;
    }

    public static int getAreaRectangle(int ax, int ay, int bx, int by){
        int b = validateValues (ax, bx);
        int h = validateValues(ay, by);
        return b * h;
    }

    public static int validateValues(int a, int b){
        return ((a > 0 && b > 0) || (a < 0 && b < 0)) ?
                Math.abs(Math.abs(a) - Math.abs(b)) : Math.abs(Math.abs(a) + Math.abs(b));
    }

    public static int[] getCases() {
        //return new int[] {-3, 0, 3, 4, 0, -1, 9, 2};
        //return new int[] {-2, -2, 2, 2, -2, -2, 2, 2};
        //return new int[]{-2, -2, 2, 2, 3, 3, 4, 4};
        //return new int[] {-2, -2, 2, 2, -4, 3, -3, 4};
        return new int[] {-2, -2, 2, 2, -1, -1, 1, 1};
    }
}