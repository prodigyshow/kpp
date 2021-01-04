package com.company;

import java.time.Instant;

public class Executor {
    public static double[][] matrix;

    public static void Execute(int blockSize)
    {
        matrix = GausMethodRunnable.Calculate(matrix);
    }
    public static void Execute(int blockSize, int threadNumber)
    {

    }

    public static double[][] InsertRandom(int blockSize)
    {
        double min = 1;
        double max = 20;

        double[][] result = new double[blockSize][blockSize + 1];
        for (int i = 0; i < blockSize; ++i)
        {
            for (int j = 0; j <= blockSize; ++j)
            {
                result[i][j] = min + Math.random() * max;
            }
        }

        return result;
    }
}
