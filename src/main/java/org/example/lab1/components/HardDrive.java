package org.example.lab1.components;

import java.util.Objects;

/**
 * The type Hard drive.
 */
public class HardDrive {
    private String mark;
    private double formFactor; // 2.5" or 3.5"
    private int spindleSpeed; // for example 5400 rpm
    private int transferRate; // 5gb in s
    private boolean started;

    /**
     * Instantiates a new Hard drive.
     *
     * @param mark         the mark
     * @param formFactor   the form factor
     * @param spindleSpeed the spindle speed
     * @param transferRate the transfer rate
     */
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
     * Gets form factor.
     *
     * @return the form factor
     */
    public double getFormFactor() { return formFactor; }

    /**
     * Gets spindle speed.
     *
     * @return the spindle speed
     */
    public int getSpindleSpeed() { return spindleSpeed; }

    /**
     * Gets transfer rate.
     *
     * @return the transfer rate
     */
    public int getTransferRate() { return transferRate; }
}
