package org.example.lab1.components;

import java.util.Objects;

/**
 * The type Ram.
 */
public class RAM {
    private String mark;
    private int memorySize;
    private int memoryFrequency;
    private boolean started;

    /**
     * Instantiates a new Ram.
     *
     * @param mark            the mark
     * @param memorySize      the memory size
     * @param memoryFrequency the memory frequency
     */
    public RAM(String mark, int memorySize, int memoryFrequency) {
        this.mark = mark;
        this.memorySize = memorySize;
        this.memoryFrequency = memoryFrequency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RAM)) return false;
        RAM ram = (RAM) o;
        return memorySize == ram.memorySize && memoryFrequency == ram.memoryFrequency && started == ram.started && mark.equals(ram.mark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mark, memorySize, memoryFrequency, started);
    }

    @Override
    public String toString() {
        return "RAM{" +
                "mark='" + mark + '\'' +
                ", memorySize=" + memorySize +
                ", memoryFrequency=" + memoryFrequency +
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
    public String getMark() {return mark;}

    /**
     * Gets memory size.
     *
     * @return the memory size
     */
    public int getMemorySize() {return memorySize;}

    /**
     * Gets memory frequency.
     *
     * @return the memory frequency
     */
    public int getMemoryFrequency() {return memoryFrequency;}
}
