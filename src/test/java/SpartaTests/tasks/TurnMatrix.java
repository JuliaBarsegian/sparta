package SpartaTests.tasks;

public class TurnMatrix {
    public static void main(String[] args) {
        int[][] massA = createMatrix();
        int[][] massB=turn(massA);

        printMatrix(massA);
        System.out.println("___________" + "\n");
        printMatrix(massB);
    }

    public static int[][] createMatrix() {
        int[][] massA=new int[6][6];
        for (int i = 0; i <massA.length ; i++) {
            for (int j = 0; j <massA.length ; j++) {
                massA[i][j]=j+1;
            }
        }
        return massA;
    }

    public static void printMatrix(int[][] mass) {
        for (int i = 0; i < mass.length; i++) {
            for (int x: mass[i]
            )
            {
                System.out.print(x+" ");
            }
            System.out.println();
        }
    }

    public static int[][] turn(int[][] massA) {
        int[][] result=new int[massA.length][massA.length];
        for (int i = 0; i <massA.length ; i++) {
            for (int j = 0; j <massA.length ; j++) {
                result[i][j]=massA[massA.length-1-j][i];
            }
        }
        return result;
    }
}