import static java.lang.Math.*;
/**
 * Offers practical methods for handling tridiagonal matrices.
 * A typical tridiagonal matrix is shown as a 3 x n array, where 
 * row 1 is the upper diagonal, row 2 is the main diagonal and 
 * row 3 is the lower diagonal. 
 */
public class Tridiagonals
{
    /**
     * Computes a n x n tridiagonal matrix.
     * 
     * @param Matrix of size n assumed to be > 0
     * @return 3 x n array that representing the tridiagonal matrix, where 
     * row 0 stores the upper diagonal, row 1 stores the main diagonal, and 
     * row 2 stores the lower diagonal. 
     */
    public static double[][] exampleMatrix(int n) 
    {
       double[][] matrix = new double[3][n]
       for (int i = 0; i < n; i++)
       {
        matrix[0][i] = 1.0;
        matrix[2][i] = i + 2;
       }
       for (int i = 0; i < n; i++)
       {
        matrix[1][i] = - ((i + 1) * (i + 1))
       }
       return matrix;
    }

    /**
     * Checks whether a double [][] array is a valid representation of a tridiagonal matrix
     * Criterion for validity:
     * 1. The array itself is not null
     * 2. Length 3 at the first level, and length n at second level (n>=1)
     * 3. All three rows have the same length n where n>0
     * 
     * @param a double [][] array to validate
     * @return true if valid (is a tridiagonal matrix representation) and false otherwise
    */
    public static boolean isValidTridiagonal(double[][] a) 
    {
        if (a == null) return false; // check if the array is null
        if (a.length !=3) return false; // check that the array has exactly 3 rows (above diagonal, diagonal, below diagonal)
        for (double[] row : a) { // check if any of the row are null
            if (row == null) return false;
        }

        int n = a[1].length; //use the diagonal row as a reference
        if (n<1) return false; //safety check as  matrix size must be at least 1 (n>=1)

        if (a[0].length !=n || a[2].length !=n) return false; // check that all rows are of the same length
        return true; 
    }

    /** Computes the sum of two tridiagonal matrices represented as double[][] arrays
     * The sum of two tridiagonal matrices is also a tridiagonal matrix, where each
     * entry is the sum of the corresponding entries in the input matrices.
     *
     * @param a double[][] - the first tridiagonal matrix
     * @param b double[][] - the second tridiagonal matrix
     * 
     * @return a matrix representing the sum of the two input matrices, 
    *          or null if either input is invalid (not a tridiagonal matrix or null)
    */

    public static double[][] sum(double[][] a, double[][] b)
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
    
    /**
     * Computes the product of a diagonal matrix with a tridiagonal matrix.
     * 
     * @param Diagonal matrix D, as a one dimensional array.
     * @param Tridiagonal matrix T, as a 3 x n array.
     * @return A 3 x n array that is the product of D and T, or null if D is is null 
     * also if the inputs are invalid or the dimensions are incompatible.
     *  
     */
    public static double[][] productWithDiagonal(double[][] d, double[] t) 
    {   
        if (d == null || t == null)
        {
            return null;
        }

        int r = d.length;

        if (t[0].length != r || t[1].length != r || t[2].length != r)
        {
            return null;
        }

        double[][] matrix = new double[3][r]

        for (int i = 0; i < r; i++)
        {
            matrix[1][i] = d[i] * t[1][i];
        }

        for (int i = 0; i < r - 1; i++)
        {
            matrix[0][i] = d[i] * t[0][i]
            matrix[2][i] = d[i + 1] * t[2][i]
        }

        return matrix
    }

    /**
    * Solves the linear equation system Tx=v where T is a tridiagonal matrix (n x n) and v is a vector
    * Implement Thomas Algorithm, where T is assumed invertible
    *
    * @param a double[][], t - the tridiagonal matrix T, represented as a double[3][n] array
    * @param a double[][], v - the right-hand side vector of length n
    * @return a double[],x which is the solution (a double[] of length n), or return null if inputs are invalid
    * example of invalid inputs include: t is not a valid tridiagonal matrix, v is null, or if dimensions of t and v are incompatible
    * @see #isValidTridiagonal(double[][])
    */
    public static double[] linearSolve(double[][] t, double[] v) 
    {
        if (!isValidTridiagonal(t)) return null; //validate if the matrix is tridiagonal
        if (v==null) return null; // validate vector: make sure it is not null

        int n = t[1].length; //get length of matrix T
        if (v.length != n) return null; //Ensure the length of matrix and vector is equal

        // Implementing Thomas Algorithm
        // create copy to avoid accidentally changing the original matrix
        // c1 = modified above diagonal, d1 = modified right hand side vector

        double[] c1 = new double[n];
        double[] d1 = new double[n];

        // Standard Thomas Algorithm:
        // below-diagonal: t[2][i] = b_{i+1} 
        // diagonal: t[1][i] = a_i
        // above diagonal: t[0][i] = c_i

        // Step 1 : Forward sweep - eliminate below-diagonal entries
        // initialising first row
        c1[0] = t[0][0] / t[1][0]; // c1_0 = c_0 / a_0
        d1[0] = v[0] / t[1][0];    // d1_0 = v_0 / a_0

        for (int i=1; i<n; i++) {
            double below = t[2][i-1]; //below diagonal to row i

            // denominator = a_i - b_i * c1_{i-1}
            double denom = t[1][i] - below * c1[i-1]; // b_i

            // update c1
            if (i < n-1) {
                c1[i] = t[0][i] / denom; //update x if i<n-1
            }
            //update d1
            d1[i] = (v[i] - below * d1[i-1]) / denom;
        }

        // Step 2: Back substitution - solve for x starting from the last entry upward
        double[] x = new double[n];
        x[n-1] = d1[n-1]; 

        for (int i = n-2; i>=0; i--){
            x[i]= d1[i] - c1[i] * x[i+1];
        }
            
            
        return x;
    }
}
