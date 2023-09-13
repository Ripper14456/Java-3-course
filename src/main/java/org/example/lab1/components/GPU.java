package org.example.lab1.components;

import java.util.Objects;

/**
 * The type Gpu.
 */
public class GPU {
    private String mark;
    private int memoryFrequency;
    private int memorySize;
    private int countOfFans;
    private boolean started;

    /**
     * Instantiates a new Gpu.
     *
     * @param mark            the mark
     * @param memoryFrequency the memory frequency
     * @param memorySize      the memory size
     * @param countOfFans     the count of fans
     */
    public GPU(String mark, int memoryFrequency, int memorySize, int countOfFans) {
        this.mark = mark;
        this.memoryFrequency = memoryFrequency;
        this.memorySize = memorySize;
        this.countOfFans = countOfFans;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GPU)) return false;
        GPU gpu = (GPU) o;
        return memoryFrequency == gpu.memoryFrequency && memorySize == gpu.memorySize && countOfFans == gpu.countOfFans && started == gpu.started && mark.equals(gpu.mark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mark, memoryFrequency, memorySize, countOfFans, started);
    }

    @Override
    public String toString() {
        return "GPU{" +
                "mark='" + mark + '\'' +
                ", memoryFrequency=" + memoryFrequency +
                ", memorySize=" + memorySize +
                ", countOfFans=" + countOfFans +
                ", started=" + started +
                '}';
    }

    /**
     * On.
     */
    public void on() { started = true; }

    /**
     * Off.
     */
    public void off() { started = false; }

    /**
     * Is started boolean.
     *
     * @return the boolean
     */
    public boolean isStarted() { return started; }

    /**
     * Gets mark.
     *
     * @return the mark
     */
    public String getMark() { return mark; }

    /**
     * Gets memory frequency.
     *
     * @return the memory frequency
     */
    public int getMemoryFrequency() { return memoryFrequency; }

    /**
     * Gets memory size.
     *
     * @return the memory size
     */
    public int getMemorySize() { return memorySize; }

    /**
     * Gets count of fans.
     *
     * @return the count of fans
     */
    public int getCountOfFans() { return countOfFans;}
}
