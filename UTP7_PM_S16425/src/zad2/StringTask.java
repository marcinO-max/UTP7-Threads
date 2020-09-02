package zad2;

import java.io.IOException;

@SuppressWarnings("WeakerAccess")
public class StringTask implements Runnable {

    private String result = "", string;
    private int count;
    Thread t;
    private boolean end = false, done = false;
    private volatile TaskState state;

    public StringTask(String string, int a) {
        this.count = a;
        this.string = string;
        this.state = TaskState.CREATED;
    }

    public StringTask() {
        this.state = TaskState.ABORTED;
    }


    public String getResult() {
        // TODO Auto-generated method stub
        return this.result;
    }

    public TaskState getState() {
        // TODO Auto-generated method stub
        return state;
    }

    public void abort() {
        t.interrupt();
    }

    public boolean isDone() {
        //return this.done;
        if (state == TaskState.READY || state == TaskState.ABORTED)
            return true;
        return false;
    }

    public void start() {
        state = TaskState.RUNNING;
        new Thread(this).start();
    }


    @Override
    public void run() {
    	t = Thread.currentThread();
        state = TaskState.RUNNING;
        int repeatCount = 0;
        
        try {
            while (repeatCount < count && !this.end) {
            	if(t.isInterrupted()) {
                    this.state = TaskState.ABORTED;
                    this.end = true;
                    this.done = true;
                    break;
            	} else {
                    this.result += string;
                    repeatCount++;	
            	}
            }
            if (this.end) {
                this.state = TaskState.ABORTED;
            } else {
                this.state = TaskState.READY;
                this.done = true;
            }
        } catch (Exception e) {
            this.state = TaskState.ABORTED;
            this.done = false;
        }
    }

}
