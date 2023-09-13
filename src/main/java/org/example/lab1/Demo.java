package org.example.lab1;


import org.example.lab1.components.CPU;
import org.example.lab1.components.GPU;
import org.example.lab1.components.HardDrive;
import org.example.lab1.components.MemoryType;
import org.example.lab1.components.RAM;
import org.example.lab1.devices.Device;
import org.example.lab1.devices.PC;
import org.example.lab1.devices.PlayStation;

public class Demo {
    public static void main(String[] args) {
        PC.PCBuilder pcBuilder = new PC.PCBuilder();
        pcBuilder.setKeyboard("Razer BlackWidow Chroma V2");
        pcBuilder.setMouse("Logitech G PRO Wireless");
        pcBuilder.setCpu(new CPU("Ryzen 5 3600", 6, 4.2));
        pcBuilder.setGpu(new GPU("MSI 1060",8000,6,2));
        pcBuilder.setRam(new RAM("Hyperx",16,2400));
        pcBuilder.setMemoryType(MemoryType.DDR4);
        pcBuilder.setHardDrive(new HardDrive("Kingston",2.5,5000,5));

        Device pc = pcBuilder.build();
        System.out.println(pc.toString());

        PlayStation.PSBuilder playStation5 = new PlayStation.PSBuilder();
        playStation5.setType(PlayStation.PlayStationType.PS5);
        playStation5.setCpu(new CPU("AMD Ryzen Zen 2",8,3.5));
        playStation5.setGpu(new GPU("AMD Radeon RDNA 2", 18000,12,3));
        playStation5.setRam(new RAM("",16,3666));
        playStation5.setMemoryType(MemoryType.DDR6);
        playStation5.setHardDrive(new HardDrive("",0,5000,5));
        Device ps5 = playStation5.build();
        System.out.printf(ps5.toString());
    }
}