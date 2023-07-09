package com.leolizc.perlinSea;

import processing.core.PApplet;

public class PerlinSea {
    PApplet p;
    float scale = 0.02f;
    private float size = 450, segments = 20, step = size/segments;
    float intensity = 30;

    public PerlinSea(PApplet p) {
        init(p);
    }

    public PerlinSea(
            PApplet p,
            float size
    ){
        init(p, size);
    }

    public PerlinSea(
            PApplet p,
            float size,
            float segments
    ){
        init(p, size, segments);
    }

    public PerlinSea(
            PApplet p,
            float size,
            float segments,
            float scale,
            float intensity
    ){
        init(p, size, segments, scale, intensity);
    }

    private void init(PApplet p){
        init(p, 450);
    }

    private void init(
            PApplet p,
            float size
    ){
        init(p, size, 20);
    }

    private void init(
            PApplet p,
            float size,
            float segments
    ){
        init(p, size, segments, 0.02f, 30);
    }

    private void init(
            PApplet p,
            float size,
            float segments,
            float scale,
            float intensity
    ){
        this.p = p;
        this.size = size;
        this.segments = segments;
        this.scale = scale;
        this.intensity = intensity;
        step = size/segments;
    }

    public void render() {
        p.pushMatrix();

        // translate(width/2f, height/2f, 0);
        p.rotateX(p.PI / 3f);
        p.rotateZ(p.frameCount * p.PI / 180f * 0.4f);
        p.noFill();

        // 20x20 squares From x = -200 to 200, draw a line from y = -200 to 200
        float halfSize = size/2f;

        p.beginShape();
        horizontalLine(halfSize);
        for (float y = halfSize; y > -halfSize; y -= step) {
            for (float x = halfSize; x >= -halfSize; x -= step) {
                vertex(x, y);
                vertex(x, y - step);
            }
            horizontalLine(y - step);
        }
        vertex(halfSize, -halfSize);
        p.endShape();

        p.popMatrix();
    }

    private void horizontalLine(float y){
        float halfSize = size/2f;
        for (float x = -halfSize; x < halfSize; x += step) {
            vertex(x, y);
        }
    }
    
    private float noise(float x, float y){
        return p.noise(x * scale, y * scale);
    }
    
    private void vertex(float x, float y){
        x=p.constrain(x, -size/2f, size/2f);
        y=p.constrain(y, -size/2f, size/2f);

        p.vertex(x, y, noise(x,y)*intensity);
//        p.vertex(x, y, 5);
    }

    // GETTERS AND SETTERS

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public float getSegments() {
        return segments;
    }

    public void setSegments(float segments) {
        this.segments = segments;
        step = size/segments;
    }
}
