/*
 * Copyright 2024 Hochschule Luzern - Informatik.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.hslu.ad.sw05.balls;

import java.util.Random;

/**
 * Demonstration von Bällen.
 *
 * @author Raquel Lima
 *
 * @version 1.0
 */
public final class Demo {

    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    public static void main(final String[] args) {

        Canvas canvas = Canvas.getCanvas();

        final String[] colors = {"red", "black", "blue", "yellow", "green", "magenta"};

        Ball[] balls = new Ball[10];
        Random random = new Random();

        for (int i = 0; i < balls.length; i++) {
            String color = colors[random.nextInt(colors.length)];
            int radius = random.nextInt(31) + 20;
            int xPos = random.nextInt(canvas.getWidth() - radius) + radius / 2;
            int yPos = random.nextInt(canvas.getHeight() - radius) + radius / 2;

            balls[i] = new Ball(radius, xPos, yPos, color);
        }

        //Conventional
        /*
        Thread[] threads = new Thread[balls.length];
        for (int i = 0; i < balls.length; i++) {
            threads[i] = new Thread(balls[i]);
            threads[i].start();
        }*/

        //Virtual
        for (Ball ball : balls) {
            Thread.startVirtualThread(ball);
        }
    }

}
