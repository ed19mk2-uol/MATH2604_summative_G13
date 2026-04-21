import static java.lang.Math.*;

class Diagonals
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

    static double[] product(double[] a, double[] b)
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

    static double[] inverse(double[] a) // Returns the inverse of a diagonal matrix 
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
