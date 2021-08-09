package com.pistachotron.client;
import com.pistachotron.client.render.Render;
import com.pistachotron.debug.Log;
import org.lwjgl.*;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
import org.lwjgl.system.*;

import javax.swing.*;
import java.nio.*;

import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryStack.*;
import static org.lwjgl.system.MemoryUtil.*;
import java.net.*;
import java.io.*;
import java.util.Date;

public class ClientGame{
    //private Render renderer=new Render();
    private Window window=new Window("Pistachotron",600,500,true);
    public boolean running=true;
    private RenderProcess renderProcess;
    private Thread renderThread;
    public ClientGame(){
        renderProcess=new RenderProcess();
        renderThread=new Thread(renderProcess);
    }
    public void run() {
        try {
            init();
            gameLoop();
        } catch (Exception excp) {
            excp.printStackTrace();
        } finally {
            cleanup();
        }
    }

    private void cleanup() {
    }
    private void init(){
        //renderer.run();
        window.init();

        renderProcess.init(window);



    }
    private void gameLoop(){
        //renderer.run();w
        String start= new Date().toString();
        long deltaTimeU=new Date().getTime();
        Log.debug("Starting Pistachotron (Client-Side)");//System.out.println(start+" - )
        renderThread.start();
        while(running){
            long nowTime=new Date().getTime();
            long deltaTime=deltaTimeU-new Date().getTime();
            ///Thread.sleep
            //Now its time for... GAME PHYSICS! (Actually no. This is only client - side)

            deltaTimeU=nowTime;
        }
    }
}