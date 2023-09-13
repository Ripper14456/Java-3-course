package org.example.lab1.devices;

import org.example.lab1.components.CPU;
import org.example.lab1.components.GPU;
import org.example.lab1.components.HardDrive;
import org.example.lab1.components.MemoryType;
import org.example.lab1.components.RAM;

import java.util.Objects;

/**
 * The type Device.
 */
abstract public class Device {
    /**
     * The Ram.
     */

    protected final RAM ram;
    /**
     * The Memory type.
     */

    protected final MemoryType memoryType;
    /**
     * The Cpu.
     */
    protected final CPU cpu;
    /**
     * The Gpu.
     */
    protected final GPU gpu;
    /**
     * The Hard drive.
     */
    protected final HardDrive hardDrive;

    /**
     * Instantiates a new Device.
     *
     * @param bd the bd
     */
    public Device(DeviceBuilder bd) {
        this.ram = bd.ram;
        this.memoryType = bd.memoryType;
        this.cpu = bd.cpu;
        this.gpu = bd.gpu;
        this.hardDrive = bd.hardDrive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Device)) return false;
        Device device = (Device) o;
        return ram.equals(device.ram) && memoryType == device.memoryType && cpu.equals(device.cpu) && gpu.equals(device.gpu) && hardDrive.equals(device.hardDrive);
    }

    @Override
    public int hashCode() {
        return Objects.hash( ram, memoryType, cpu, gpu, hardDrive);
    }

    @Override
    public String toString() {
        return "Device{" +
                "ram=" + ram +
                ", memoryType=" + memoryType +
                ", cpu=" + cpu +
                ", gpu=" + gpu +
                ", hardDrive=" + hardDrive +
                '}';
    }

    /**
     * Gets ram.
     *
     * @return the ram
     */
    public RAM getRam() {
        return ram;
    }

    /**
     * Gets memory type.
     *
     * @return the memory type
     */
    public MemoryType getMemoryType() {
        return memoryType;
    }

    /**
     * Gets cpu.
     *
     * @return the cpu
     */
    public CPU getCpu() {
        return cpu;
    }

    /**
     * Gets gpu.
     *
     * @return the gpu
     */
    public GPU getGpu() {
        return gpu;
    }

    /**
     * Gets hard drive.
     *
     * @return the hard drive
     */
    public HardDrive getHardDrive() {
        return hardDrive;
    }

    /**
     * The type Device builder.
     */
    static abstract class DeviceBuilder
    {

        protected RAM ram;
        protected MemoryType memoryType;
        protected CPU cpu;
        protected GPU gpu;
        protected HardDrive hardDrive;

        /**
         * Instantiates a new Device builder.
         */
        DeviceBuilder() {};

        /**
         * Sets ram.
         *
         * @param ram the ram
         * @return the ram
         */
        public DeviceBuilder setRam(RAM ram) {
            this.ram = ram;
            return this;
        }

        /**
         * Sets memory type.
         *
         * @param memoryType the memory type
         * @return the memory type
         */
        public DeviceBuilder setMemoryType(MemoryType memoryType) {
            this.memoryType = memoryType;
            return this;
        }

        /**
         * Sets cpu.
         *
         * @param cpu the cpu
         * @return the cpu
         */
        public DeviceBuilder setCpu(CPU cpu) {
            this.cpu = cpu;
            return this;
        }

        /**
         * Sets gpu.
         *
         * @param gpu the gpu
         * @return the gpu
         */
        public DeviceBuilder setGpu(GPU gpu) {
            this.gpu = gpu;
            return this;
        }

        /**
         * Sets hard drive.
         *
         * @param hardDrive the hard drive
         * @return the hard drive
         */
        public DeviceBuilder setHardDrive(HardDrive hardDrive) {
            this.hardDrive = hardDrive;
            return this;
        }

        /**
         * Build device.
         *
         * @return the device
         */
        abstract public Device build();
    }
}
