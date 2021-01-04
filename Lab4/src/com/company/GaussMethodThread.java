package com.company;

public class GaussMethodThread extends Thread{
    public Thread thread;
    public double[][] matrix;

    public GaussMethodThread(double[][] input)
    {
        matrix = input;
    }

    public Thread GetThread(){
        return thread;
    }

    public void PrintMatrix()
    {
        for (int i = 0; i < matrix.length; ++i)
        {
            for (int j = 0; j < matrix[i].length; ++j)
                System.out.print(Math.floor(matrix[i][j] * 10) / 10 + "  ");
            System.out.println();
        }
    }

    public static double[] SubtractRows(double[] first, double[] second, int index)
    {
        double firstElement = second[index];

        for (int i = index; i < first.length; ++i)
        {
            second[i] -= first[i] * firstElement;
        }

        return second;
    }

    public static double[][] Calculate(double[][] input)
    {
        int rows = input.length;
        int cols = input[0].length;
        double[][] output = input;

        for (int k = 0; k < rows; ++k) {
            double firstElementFirstRow = output[k][k];
            for (int i = k; i < cols; ++i) {
                output[k][i] /= firstElementFirstRow;
            }

            for (int i = k + 1; i < rows; ++i) {
                output[i] = SubtractRows(output[k], output[i], k);
            }

        }

        for (int k = rows - 1; k > 0 ; --k)
        {
            for (int i = k - 1; i >= 0; --i)
            {
                output[i] = SubtractRows(output[k], output[i], k);
            }
        }

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return output;
    }


    @Override
    public void run() {
        matrix = Calculate(matrix);
    }

    @Override
    public void start() {
        thread = new Thread(this);
        thread.start();
    }
}
