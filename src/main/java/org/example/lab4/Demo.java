package org.example.lab4;

import org.example.lab4.components.*;
import org.example.lab4.devices.*;

public class Demo {
    public static void main(String[] args) {
        PC.PCBuilder pcBuilder = new PC.PCBuilder();
        pcBuilder.setKeyboard("Razer BlackWidow Chroma V2");
        pcBuilder.setMouse("Logitech G PRO Wireless");
        pcBuilder.setCpu(new CPU("Ryzen 5 3600", 1, 4.2));
        pcBuilder.setGpu(new GPU("MSI 1060",8000,256,2));
        pcBuilder.setRam(new RAM("Hyperx",16,2400));
        pcBuilder.setMemoryType(MemoryType.DDR4);
        pcBuilder.setHardDrive(new HardDrive("Kingston",2.5,5000,5000));

        Device pc = pcBuilder.build();
        System.out.println(pc.toString());

        PlayStation.PSBuilder playStation5 = new PlayStation.PSBuilder();
        playStation5.setType(PlayStation.PlayStationType.PS5);
        playStation5.setCpu(new CPU("AMD Ryzen Zen 2",8,3.5));
        playStation5.setGpu(new GPU("AMD Radeon RDNA 2", 18000,256,3));
        playStation5.setRam(new RAM("",16,3666));
        playStation5.setMemoryType(MemoryType.DDR6);
        playStation5.setHardDrive(new HardDrive("Kingston",3.5,5000,5000));
        Device ps5 = playStation5.build();
        System.out.printf(ps5.toString());
    }
}