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

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import java.util.Random;

/**
 * Represents a ball
 *
 * @author Raquel Lima
 *
 * @version 1.0
 */
public class Ball implements Runnable {

    private final Circle circle;

    private static final Logger LOG = LoggerFactory.getLogger(Ball.class);

    public Ball(final int radius, final int xPos, final int yPos, String color) {
        this.circle = new Circle(radius*2, xPos, yPos, color);
    }

    @Override
    public void run() {
        try {

            while (!Thread.currentThread().isInterrupted() && circle.getY() + circle.getDiameter() < 400) {
                circle.makeVisible();

                //change speed with moveVertical()
                int speed = new Random().nextInt(5) + 1;
                circle.moveVertical(speed);

                //change speed with sleep()
                /*
                circle.moveDown();
                Thread.sleep(new Random().nextInt(200) + 100);
                */
            }

            while (circle.getDiameter() > 0) {
                circle.changeSize(circle.getDiameter() - 1);
            }
        /*
        } catch (InterruptedException ex) {
            LOG.info("Thread interrupted: " + ex.getMessage());
            Thread.currentThread().interrupt();
        */

        } finally {
            circle.makeInvisible();
        }
    }
}
