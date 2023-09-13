package org.example.lab1.components;

import java.util.Objects;

public class CPU {
    private String mark; // марка
    private int cores; // ядра
    private double frequency; // частота
    private boolean started;

    /**
     * Instantiates a new Cpu.
     *
     * @param mark      the mark
     * @param cores     the cores
     * @param frequency the frequency
     */
    public CPU(String mark, int cores, double frequency)
    {
        this.mark = mark;
        this.cores = cores;
        this.frequency = frequency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CPU)) return false;
        CPU cpu = (CPU) o;
        return cores == cpu.cores && Double.compare(cpu.frequency, frequency) == 0 && started == cpu.started && mark.equals(cpu.mark);
    }

    @Override
    public String toString() {
        return "CPU{" +
                "mark='" + mark + '\'' +
                ", cores=" + cores +
                ", frequency=" + frequency +
                ", started=" + started +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(mark, cores, frequency, started);
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
     * Gets cores.
     *
     * @return the cores
     */
    public int getCores() { return cores; }

    /**
     * Gets frequency.
     *
     * @return the frequency
     */
    public double getFrequency() { return frequency; }
}
