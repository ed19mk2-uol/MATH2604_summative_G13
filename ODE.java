import static java.lang.Math.*;

class ODE
{
    public static double solve(double a, int n) 
    {
        if (n <= 0)
        {
            return 0.0;
        }

        double h = 1.0 / (n + 1);

        double[][] M = new double[3][n];

        for (int i = 0; i < n; i++)
        {
            double xi = (i + 1) * h;

            M[1][i] = 2.0 + h * h * cos(xi); // Main diagonal

            if (i < n - 1) // Upper diagonal
            {
                M[0][i] = -1.0;
            }

            if (i > 0)
            {
                M[2][i - 1] = -1.0; // Lower diagonal
            }
        }

        double[] v = new double[n]; // Right-hand side vector
        {
            double xi = (i + 1) * h;
            v[i] = a * xi * xi; // Right-hand side vector
        }

        double[] rhs = new double[n]; // Right-hand side for the linear system
        for (int i = 0; i < n; i++)
        {
            rhs[i] = -h * h * v[i]; // Adjusting for the right-hand side
        }

        double[] w = Tridiagonals.linearSolve(M, rhs); // Solving the linear system

        if (w == null)
        {
            return 0.0;
        }

        double target = 0.5;
        int nearestIndex = -1; // Index of the nearest grid point to 0.5
        double minDiff = Double.MAX_VALUE;

        for (int i = 0; i < n; i++) // Finding the nearest grid point to 0.5
        {
            double xi = (i + 1) * h;
            double diff = abs(xi - target);

            if (diff < minDiff)
            {
                minDiff = diff;
                nearestIndex = i;
            }
        }

        double xi = (nearestIndex + 1) * h; // Grid point corresponding to the nearest index

        if (abs(xi - target) < 1e-12)
        {
            return w[nearestIndex];
        }

        if (xi < target && nearestIndex < n - 1) // If the nearest grid point is less than 0.5, average with the next point
        {
            return 0.5 * (w[nearestIndex] + w[nearestIndex + 1]);
        }
        else if (xi > target && nearestIndex > 0) // If the nearest grid point is greater than 0.5, average with the previous point
        {
            return 0.5 * (w[nearestIndex] + w[nearestIndex - 1]);
        }

        return w[nearestIndex];
    }
}t