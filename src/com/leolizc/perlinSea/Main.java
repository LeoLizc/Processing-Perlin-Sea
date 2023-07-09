package com.leolizc.perlinSea;

import processing.core.PApplet;

public class Main extends PApplet {
    PerlinSea perlinSea;

    public static void main(String[] args) {
        PApplet.main("com.leolizc.perlinSea.Main");
    }

    public void settings() {
        size(600, 600, P3D);
    }

    @Override
    public void setup() {
        float cameraZ = ((height / 2f) / PApplet.tan(PI * 60f / 360f));
        float farthestLength = cameraZ * 15f;
        perspective(PI / 3f, width * 1f / height, cameraZ / 10f, farthestLength);
        camera(0, 0, cameraZ, 0, 0, 0, 0, 1, 0);

        perlinSea = new PerlinSea(this);
    }

    @Override
    public void draw() {
        background(240f);

        perlinSea.render();
    }
}