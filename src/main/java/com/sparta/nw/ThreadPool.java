package com.sparta.nw;

import java.util.ArrayList;

import thread.Action;

public class ThreadPool {

    private static int POOL_SIZE = 150;
    private static ArrayList<Action> threadPool = new ArrayList<>();

    private ThreadPool() {
    }

    public static void create() {
        for (int i = 0; i < POOL_SIZE; i++) {
            threadPool.add(new Action());
        }
    }

    protected static Action getThread(ArrayList a) {
        threadPool.get(0).setSubList(a);
        return threadPool.remove(0);

    }


}