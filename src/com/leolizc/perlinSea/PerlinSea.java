package com.leolizc.perlinSea;

import processing.core.PApplet;

public class PerlinSea {
    PApplet p;

    public PerlinSea(PApplet p) {
        this.p = p;
    }

    public void render() {
        // translate(width/2f, height/2f, 0);
        p.rotateX(p.PI / 3f);
        p.rotateZ(p.frameCount * p.PI / 180f * 0.4f);
        p.noFill();

        // 20x20 squares From x = -200 to 200, draw a line from y = -200 to 200
        p.beginShape();
        horizontalLine(200);
        for (int y = 200; y > -200; y -= 20) {
            for (int x = 200; x >= -200; x -= 20) {
                p.vertex(x, y, p.noise(x,y)*30);
                p.vertex(x, y - 20, p.noise(x,y-20)*30);
            }
            horizontalLine(y - 20);
        }
        p.vertex(200, -200, p.noise(-200,-200)*30);
        p.endShape();
    }

    private void horizontalLine(float y){
        for (int x = -200; x < 200; x += 20) {
            p.vertex(x, y, p.noise(x,y)*30);
        }
    }
}
