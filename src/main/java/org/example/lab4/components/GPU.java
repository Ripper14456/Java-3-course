package org.example.lab4.components;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class GPU {
    @NotNull
    private String mark;
    @NotNull
    private int memoryFrequency;
    @NotNull
    @Min(value = 128, message = "min = 128")
    private int memorySize;
    @NotNull
    @Max(value = 4, message = "countOfFans cant be more than 4")
    private int countOfFans;
    private boolean started;

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

    public void on() { started = true; }

    public void off() { started = false; }

    public boolean isStarted() { return started; }

    public String getMark() { return mark; }

    public int getMemoryFrequency() { return memoryFrequency; }

    public int getMemorySize() { return memorySize; }

    public int getCountOfFans() { return countOfFans;}
}
