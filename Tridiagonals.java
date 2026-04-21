import static java.lang.Math.*;

class Tridiagonals
{
    public static double[][] exampleMatrix(int n) 
    {
        
        return null;
    }

    public static boolean isValidTridiagonal(double[][] a) 
    {
        if (a.length !=3) return false; // check so row is 3
        if (a == null) return false; // check if everything is null
        for (double[] row : a) { // check if any of the row are null
            if (row == null) return false;

        int n = a[1].length; 
        if (n<1) return false; //safety check bcs matrix size must be at least 1, cant be 0
        
        return false;
    }

    static double[][] sum(double[][] a, double[][] b)
    {
        if (a == null || b == null)
        {
            return null;
        }

        int n = a.length;

        double[][] result = new double[n][n];

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                result[i][j] = a[i][j] + b[i][j];
            }
        }

        return result;
    }

    static double[][] productWithDiagonal(double[][] d, double[] t) 
    {
        return null;
    }

    static double[] linearSolve(double[][] t, double[] v) 
    {
        return null;
    }
}
