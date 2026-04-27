import static java.lang.Math.*;

public class Diagonals
    {
    /**
    * Returns a representation of the diagonal matrix given 
    * The matrix is represented as a 1D array where each element corresponds to a diagonal entry
    * @return a double[] one-dimensional array representing the diagonal entries
    */
    public static double[] exampleMatrix()
    {    
        // the matrix ix 5x5 and has 10,8,5,-10,7 on its diagonal and zero elsewhere
        return new double[] {10, 8, 5, -10, 7};
    }
    
    /**
     * Takes 2 diagonal matrices both one dimensional arrays
     * Returns null if either array is null or length of the arrays don't match
     * If both arrays has length 0 then empty array is returned 
     * Typically returns an array representing the sum of the diagonal matrices
     */
    public static double[] sum(double[] a, double[] b)
    {
         if (a == null || b == null) 
        {
            return null; 
        }
        
        if (a.length != b.length)
        {
            return null;
        }

        double[] result = new double[a.length];
        for (int i = 0; i < a.length; i++)
        {
            result[i] = a[i] + b[i];
        }

        return result;
    }

    /**
     * Takes 2 diagonal matrices both one dimensional arrays
     * Returns null if either array is null or length of the arrays don't match
     * If both arrays has length 0 then empty array is returned 
     * Typically returns an array representing the product of the diagonal matrices
     */
    public static double[] product(double[] a, double[] b)
    {
        if(a == null || b == null) {
            return null;
        }

        double[] result = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = a[i] * b[i]
        }
        
        return null;
    }

    public static double[] inverse(double[] a) // Returns the inverse of a diagonal matrix 
    {
        if (a == null)
        {
            return null;
        }
        double[] result = new double[a.length];
        for (int i = 0; i < a.length; i++)
        {
            result[i] = 1.0 / a[i];
        }
        return result;
    }
}
