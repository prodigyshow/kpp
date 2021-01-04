package com.company;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.util.Timer;

public class GausApp {
    JPanel content;
    private JTextArea textArea;
    private JLabel timeLabel;

    private void initComponents(int threadNumber)
    {

    }

    public void updateForm(Thread[] threads)
    {
        String str = "";
        for (int i = 0; i < threads.length; ++i) {
            if(threads[i] != null)
                str += ("Thead " + i + " - " + threads[i].getState() + "\n");

        }

        textArea.setText(str);

        content.revalidate();
        content.repaint();
    }

    public GausApp()
    {

    }


    public static void main(String[] args) throws InterruptedException {

        GausApp app = new GausApp();
        JFrame frame = new JFrame("Gauss App");

        //app.initComponents(threadNumber);
        frame.setContentPane(app.content);
        frame.setSize(300,400);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        Scanner myInput = new Scanner(System.in);
        System.out.println("Enter the way to create threads (1 - Runnable / 2 - Thread)");
        int threadType = (int) myInput.nextInt();
        System.out.println("Enter thread number");
        int threadNumber = (int) myInput.nextInt();
        System.out.println("Enter block size");
        int blockSize = (int) myInput.nextInt();

        Thread[] threads = new Thread[threadNumber];
        GausMethodRunnable[] gaus = new GausMethodRunnable[threadNumber];

        UpdateForm updateForm = new UpdateForm(app, threads);
        Thread updateThread = new Thread(updateForm);
        updateThread.start();
        long timeElapsed = System.currentTimeMillis();

        switch (threadType)
        {
            case 1:
                for (int i = 0; i < threadNumber; ++i)
                {
                    double[][] randomMatrix = Executor.InsertRandom(blockSize);
                    gaus[i] = new GausMethodRunnable(randomMatrix);
                    threads[i] = new Thread(gaus[i]);
                    threads[i].start();
                }

                Thread.sleep(10);

                for (int i = 0; i < threadNumber; ++i)
                {
                    threads[i].join();
                }

                timeElapsed = System.currentTimeMillis() - timeElapsed;
                app.timeLabel.setText("Time taken: " + timeElapsed + " ms");

                for (int i = 0; i < threadNumber; ++i){
                    gaus[i].PrintMatrix();
                }

                break;
            case 2:
                for (int i = 0; i < threadNumber; ++i)
                {
                    double[][] randomMatrix = Executor.InsertRandom(blockSize);
                    threads[i] = new GaussMethodThread(randomMatrix);
                    threads[i].start();
                }

                Thread.sleep(10);

                for (int i = 0; i < threadNumber; ++i)
                {
                    threads[i].join();
                }

                timeElapsed = System.currentTimeMillis() - timeElapsed;
                app.timeLabel.setText("Time taken: " + timeElapsed + " ms");

                for (int i = 0; i < threadNumber; ++i){
                    ((GaussMethodThread)threads[i]).PrintMatrix();
                }

                break;
        }

        //updateThread.stop();


    }
}
