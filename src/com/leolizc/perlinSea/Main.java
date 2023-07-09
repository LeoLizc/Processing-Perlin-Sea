package com.leolizc.perlinSea;

import processing.core.PApplet;

public class Main extends PApplet {
    public void settings(){
        size(600,600, P3D);
    }

    @Override
    public void setup() {
        float cameraZ = ((height/2f) / PApplet.tan(PI*60f/360f));
        float farthestLength = cameraZ*15f;
        perspective(PI/3f, width*1f/height, cameraZ/10f, farthestLength);
        camera(0,0,cameraZ,0,0,0,0,1,0);
    }

    @Override
    public void draw() {

        // Draw a 10x10 structured triangular mesh
        background(240f);
//        translate(width/2f, height/2f, 0);
        rotateX(PI/3f);
        rotateZ(frameCount*PI/180f*0.4f);
        noFill();

        // 20x20 squares From x = -200 to 200, draw a line from y = -200 to 200
        beginShape();
        vertex(-200, 200, 0);
        for (int y = 200; y > -200; y-=20) {
            for (int x = 200; x >= -200; x-=20) {
                vertex(x, y, 0);
                vertex(x, y-20, 0);
            }
        }
        vertex(200, -200, 0);
        endShape();
    }

    public static void main(String[] args){
        PApplet.main("com.leolizc.perlinSea.Main");
    }
}