package com.pistachotron.client;

import com.pistachotron.client.render.Render;
import com.pistachotron.client.render.Renderable;
import com.pistachotron.debug.Log;

public class RenderProcess implements Runnable{
    private Render renderer;
    private Window window;
    public RenderProcess(){

    }
    @Override
    public void run() {
        renderer.render(window,new Renderable[] {});
    }

    public void init(Window window){
        Log.debug("Initalizing Renderer");
        this.window=window;
        renderer=new Render();

        try {
            renderer.init(this.window);


        }
        catch(Exception e){
            Log.debug(e.toString());//System.err.println
        }
        Log.debug("Initialized Renderer");
    }
}
