package org.example.lab4.components;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class HardDrive {
    @NotNull
    private String mark;
    @NotNull
    private double formFactor; // 2.5" or 3.5"
    @NotNull
    @Min(value = 1000, message = "spindleSpeed cant be less than 1000")
    private int spindleSpeed; // for example 5400 rpm
    @NotNull
    @Min(value = 100,message = "transferRate cant be less than 100")
    private int transferRate; // 5gb in s
    private boolean started;

    public HardDrive(String mark, double formFactor, int spindleSpeed, int transferRate) {
        this.mark = mark;
        this.formFactor = formFactor;
        this.spindleSpeed = spindleSpeed;
        this.transferRate = transferRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HardDrive)) return false;
        HardDrive hardDrive = (HardDrive) o;
        return Double.compare(hardDrive.formFactor, formFactor) == 0 && spindleSpeed == hardDrive.spindleSpeed && transferRate == hardDrive.transferRate && started == hardDrive.started && mark.equals(hardDrive.mark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mark, formFactor, spindleSpeed, transferRate, started);
    }

    @Override
    public String toString() {
        return "HardDrive{" +
                "mark='" + mark + '\'' +
                ", formFactor=" + formFactor +
                ", spindleSpeed=" + spindleSpeed +
                ", transferRate=" + transferRate +
                ", started=" + started +
                '}';
    }

    public void on() { started = true; }

    public void off() { started = false; }

    public boolean isStarted() { return started; }

    public String getMark() { return mark; }

    public double getFormFactor() { return formFactor; }

    public int getSpindleSpeed() { return spindleSpeed; }

    public int getTransferRate() { return transferRate; }
}
