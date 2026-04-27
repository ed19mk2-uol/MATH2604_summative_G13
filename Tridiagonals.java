import static java.lang.Math.*;

public class Tridiagonals
{
    public static double[][] exampleMatrix(int n) 
    {
        
        return null;
    }

    /**
     * Checks whether a double [][] array is a tridiagonal matrix
     * Criterion for validity:
     * 1. Length 3 at the first level, and length n at second level (n>=1)
     * 2. All three rows have the same length n
     * @param a double [][] array 
     * @return true if valid (is a tridiagonal matrix representation) and false otherwise
    */
    public static boolean isValidTridiagonal(double[][] a) 
    {
        if (a.length !=3) return false; // check that row is 3 (above diagonal, diagonal, below diagonal)
        if (a == null) return false; // check if the array is null
        for (double[] row : a) { // check if any of the row are null, each row must not be null
            if (row == null) return false;

        int n = a[1].length; //use the diagonal row as a reference
        if (n<1) return false; //safety check bcs matrix size must be at least 1, cant be 0 (n>=1)

        return true;
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

    /**
    *
    */
        
    public static double[] linearSolve(double[][] t, double[] v) 
    {
        if (!isValidTridiagonal(t)) return null; //check if the matrix is tridiagonal
        if (v==null) return null; // validate vector and make sure vector is not null

        int n = t[1].length; //get length of matrix T
        if (v.length != n) return null; //Ensure the length of matrix and vector is equal

        // Implementing Thomas Algorithm
        // create copy to avoid accidentally changing the original matrix
        // c1 = modified above diagonal, d1 = modified right hand side

        double[] c1 = new double[n];
        double[] d1 = new double[n];

        // Standard Thomas Algorithm:
        // below-diagona: t[2][i] = b_{i+1} 
        // diagonal: t[1][i] = a_i
        // above diagonal: t[0][i] = c_i

        // 1st Step : Forward sweep - eliminate below-diagonal entries
        //initialising first row
        c1[0] = t[0][0] / t[1][0]; // c1_0 = c_0 / a_0
        d1[0] = v[0] / t[1][0];    // d1_0 = v_0 / a_0

        for (int i=1; i<n; i++) {
            double below = t[2][i-1]; //below diagonal to row i

            // denominator = a_i - b_i * c1_{i-1}
            double denom = t[1][i] - below * c1[i-1]; // b_i

            // update c1
            if (i,n-1) {
                c1[i] = t[0][i] / denom; //update x if i<n-1
            }
            //update d1
            d1[i] = (v[i] - below * d1[i-1]) / denom;
        }

        // Step 2: Back substitution - solve for x starting from the last entry
        double[] x = new double[n];
        x[n-1] = d1[n-1]; 

        for (int i = n-2; i>=0; i--){
            x[i]= d1[i] - c1[i] * x[i+1];
            
            
        return x;
    }

    public class TestLinearSolve {
    public static void main(String[] args) {

        double[][] T = new double[3][3];
        T[0] = new double[]{-1, -1, 0};
        T[1] = new double[]{2, 2, 2};
        T[2] = new double[]{-1, -1, 0};

        double[] v = new double[]{1, 0, 1};

        double[] x = Tridiagonals.linearSolve(T, v);

        System.out.println("Solution:");
        for (double xi : x) {
            System.out.println(xi);
        }
    }
}
}
