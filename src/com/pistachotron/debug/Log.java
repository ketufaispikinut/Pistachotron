package com.pistachotron.debug;

import java.util.Date;

public class Log {
    private static Log INSTANCE = new Log();
    public boolean activated=true;

    public static void debug(String debug){
        INSTANCE.write(new Date().toString()+" - "+debug);
    }
    public static void setActive(boolean cur){
        INSTANCE.activated=cur;
    }
    private void write(String text){
        if(activated){
            System.out.println(text);
        }
    }
}
