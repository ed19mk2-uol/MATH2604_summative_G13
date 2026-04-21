import static java.lang.Math.*;

class Tridiagonals
{
    public static double[][] exampleMatrix(int n) 
    {
        return null;
    }

    static boolean isValidTridiagonal(double[][] a) 
    {
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
