package com.pistachotron.world.chunk;

import com.pistachotron.client.render.Renderable;
import org.joml.Vector3f;
import com.pistachotron.client.render.util.Mesh;
public class Chunk implements Renderable {
    private int[][][] blocks;

    private Mesh CachedMesh;
    @Override
    public Vector3f getRotation() {
        return null;
    }

    @Override
    public Vector3f getPosition() {
        return null;
    }

    @Override
    public float getScale() {
        return 0;
    }

    @Override
    public Mesh getMesh() {
        return null;
    }
}
