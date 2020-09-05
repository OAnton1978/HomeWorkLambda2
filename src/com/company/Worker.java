package com.company;

public class Worker {
    private OnTaskDoneListener callback;
    private OnTaskErrorListener errorCallback;

    public Worker(OnTaskDoneListener callback) {
        this.callback = callback;
    }

    public Worker(OnTaskErrorListener errorCallback) {
        this.errorCallback = errorCallback;
    }

    public void start() {
        for (int i = 0; i < 33; i++) {
            callback.onDone("Task " + i + " is done");
        }
        for (int i = 34; i < 100; i++) {
            callback.onDone("Task " + i + " is done");
        }
    }

    public void startError() {
        errorCallback.onError("Task 33 is Error");
    }

    @FunctionalInterface
    public interface OnTaskDoneListener {
        void onDone(String result);
    }

    @FunctionalInterface
    public interface OnTaskErrorListener {
        void onError(String result);
    }
}
