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

        stroke(0);
        perlinSea.render();

        textSize(20);
        fill(0);
        textAlign(CENTER, TOP);
        text("scale: " + perlinSea.scale + "\nintensity: " + perlinSea.intensity, 0,-height/2f);
    }

    public void keyPressed(){
        if(key==CODED){
            if(keyCode==UP){
                perlinSea.scale+=0.01f;
            }else if(keyCode==DOWN){
                perlinSea.scale-=0.01f;
            }
            if(keyCode==LEFT){
                perlinSea.intensity-=1;
            }else if(keyCode==RIGHT){
                perlinSea.intensity+=1;
            }
        }
    }


}