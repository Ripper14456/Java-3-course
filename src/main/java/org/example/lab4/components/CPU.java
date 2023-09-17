package org.example.lab4.components;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class CPU {
    @NotNull
    private String mark; // марка
    @NotNull
    @Min(value = 1, message = "cores cant be less than 1")
    private int cores; // ядра
    @NotNull
    private double frequency; // частота

    private boolean started;

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

    public void on() { started = true; }

    public void off() { started = false; }

    public boolean isStarted() { return started; }

    public String getMark() { return mark; }

    public int getCores() { return cores; }

    public double getFrequency() { return frequency; }
}
