package com.pistachotron.worldgen;

public class Noise {

    public double getAt(int x, int y,int z){

        int last = (x * 32719 + 3) % 32749;
        int past = (y * 32749 + 3) % 32719;
        int fast = (z * 32719 + 3) % 32719;
        return Math.sin(last % 32749);
    }
}
