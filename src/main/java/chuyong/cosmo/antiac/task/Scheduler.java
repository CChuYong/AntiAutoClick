package chuyong.cosmo.antiac.task;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Scheduler {
    private ScheduledExecutorService scr;
    public Scheduler(){
        this.scr = Executors.newSingleThreadScheduledExecutor();
    }
    public void init(){
        scr.scheduleAtFixedRate(new RunnableTask(), 1000, 1000, TimeUnit.MILLISECONDS);
    }
    public void onDisable(){
        if(!scr.isShutdown())
           scr.shutdown();
    }
}
