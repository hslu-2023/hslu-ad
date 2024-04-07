/*
 * Copyright 2024 Hochschule Luzern Informatik.
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
package ch.hslu.ad.sw05.joins;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * Demonstration of Join and Sleep.
 */
public class JoinAndSleep {

    private static final Logger LOG = LoggerFactory.getLogger(JoinAndSleep.class);

    /**
     * Main-Demo.
     *
     * @param args not used.
     * @throws InterruptedException when waiting is interrupted.
     */
    public static void main(String[] args) throws InterruptedException {
        final var task1 = new JoinAndSleepTask("Thread-1", 2000);
        final var task2 = new JoinAndSleepTask("Thread-2", 3000);
        final var task3 = new JoinAndSleepTask("Thread-3", 4000);

        final var thread1 = new Thread(task1, "Thread-1");
        final var thread2 = new Thread(task2, "Thread-2");
        final var thread3 = new Thread(task3, "Thread-3");

        task1.setJoinFor(thread2);
        task2.setJoinFor(thread3);

        thread1.start();
        LOG.info("Thread-1 started");
        thread2.start();
        LOG.info("Thread-2 started");
        thread3.start();
        LOG.info("Thread-3 started");

    }

}

