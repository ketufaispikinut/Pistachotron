package com.pistachotron.client.render;

import org.joml.Vector3f;
import com.pistachotron.client.render.util.Mesh;
public interface Renderable {
    public Vector3f getRotation();//{
     //  // return new Vector3f(0,0,0);
    //}
    public Vector3f getPosition();
    public float getScale();
    public Mesh getMesh();
}
