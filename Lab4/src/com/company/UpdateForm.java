package com.company;

public class UpdateForm implements Runnable {

    GausApp app;
    Thread[] threads;

    public UpdateForm(GausApp gApp, Thread[] thr)
    {
        app = gApp;
        threads = thr;
    }

    @Override
    public void run() {
        do {
            app.updateForm(threads);
            long start = System.currentTimeMillis();
            while(System.currentTimeMillis() - start < 20);
        }while (true);
    }
}
