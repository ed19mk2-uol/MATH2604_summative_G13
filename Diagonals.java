import static java.lang.Math.*;

class Diagonals
{
    static double[] exampleMatrix()
    {      
        return null;
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
