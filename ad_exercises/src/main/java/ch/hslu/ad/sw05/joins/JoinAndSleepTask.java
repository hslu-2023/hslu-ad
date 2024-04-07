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

import java.util.Objects;

/**
 * Parameterizable task that waits for an external thread and then sleeps for a certain period of time.
 */
public class JoinAndSleepTask implements Runnable {

    private static final Logger LOG = LoggerFactory.getLogger(JoinAndSleepTask.class);

    private final String taskName;
    private final int sleepTime;
    private Thread joinFor;

    /**
     * Creates a task with a name.
     *
     * @param taskName  the name of the task.
     * @param sleepTime the time in ms that the task sleeps.
     */
    public JoinAndSleepTask(final String taskName, final int sleepTime) {
        this.taskName = taskName;
        this.joinFor = null;
        this.sleepTime = sleepTime;
    }

    /**
     * Joins another Thread to the existing Thread
     *
     * @param joinFor
     */
    public void setJoinFor(final Thread joinFor) {
        this.joinFor = joinFor;
    }

    /**
     * Here we wait for the end of the foreign thread and then sleep for a certain time. Both parts can be interrupted.
     */
    @Override
    public void run() {
        if (this.joinFor != null) {
            try {
                LOG.info("{} is waiting for {} to finish", this.taskName, this.joinFor.getName());
                this.joinFor.join();
            } catch (InterruptedException e) {
                LOG.error("{} was interrupted while waiting for {} to finish", this.taskName, this.joinFor.getName());
                Thread.currentThread().interrupt();
            }
        }

        try {
            LOG.info("{} sleeps for {} ms", this.taskName, this.sleepTime);
            Thread.sleep(this.sleepTime);
        } catch (InterruptedException e) {
            LOG.error("{} was interrupted while waiting", this.taskName);
            Thread.currentThread().interrupt();
        } finally {
            LOG.info("{} ended", this.taskName);
        }
    }

    public void interruptTask() {
        if (Thread.currentThread().equals(joinFor)) {
            LOG.warn("{} interrupted in sleep", taskName);
        } else {
            LOG.warn("{} interrupted while waiting for {} to finish", taskName, joinFor.getName());
        }
        Thread.currentThread().interrupt();
    }
}