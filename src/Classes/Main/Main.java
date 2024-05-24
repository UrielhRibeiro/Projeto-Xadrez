package Classes.Main;

import Classes.Projeto.ClassFinder.ClassFinder;
import Classes.Projeto.Event.Event;
import Classes.Projeto.Xadrez.Pieces.Pawn;
import Classes.Projeto.Xadrez.Player;


import java.net.URL;
import java.net.URLClassLoader;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final ScheduledExecutorService timer = Executors.newScheduledThreadPool(1);
    public static void main(String[] args) throws Exception {
        Event event = new Event();
        event.ProcessEvents();
        Event.triggerEvent("onStart");
        //executa a cada 5 ms;
        timer.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try {
                    Event.triggerEvent("onTick");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }, 0,5, TimeUnit.MILLISECONDS);


    }
}
