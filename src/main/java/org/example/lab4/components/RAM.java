package org.example.lab4.components;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class RAM {
    @NotNull
    private String mark;
    @NotNull
    @Min(value = 1, message = "memorySize must be bigger than 0")
    private int memorySize;
    @NotNull
    @Min(value = 1000, message = "memoryFrequency must be bigger than 1000")
    private int memoryFrequency;
    private boolean started;

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

    public void on() { started = true; }

    public void off() { started = false; }

    public boolean isStarted() { return started; }

    public String getMark() {return mark;}

    public int getMemorySize() {return memorySize;}

    public int getMemoryFrequency() {return memoryFrequency;}
}
