package lab1;

import org.example.lab1.components.*;
import org.example.lab1.devices.*;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Objects;

public class Lab1Test
{
    @Test(dataProvider = "equalDevice")
    public void equalTest(Device obj1, Device obj2, boolean res)
    {
        assertEquals(Objects.equals(obj1,obj2),res);
    }

    @DataProvider
    public Object[][] equalDevice()
    {
        PC.PCBuilder pcBuilder = new PC.PCBuilder();
        pcBuilder.setKeyboard("Razer BlackWidow Chroma V2");
        pcBuilder.setMouse("Logitech G PRO Wireless");
        pcBuilder.setCpu(new CPU("Ryzen 5 3600", 6, 4.2));
        pcBuilder.setGpu(new GPU("MSI 1060",8000,6,2));
        pcBuilder.setRam(new RAM("Hyperx",16,2400));
        pcBuilder.setMemoryType(MemoryType.DDR4);
        pcBuilder.setHardDrive(new HardDrive("Kingston",2.5,5000,5));
        PC pc_1 = (PC) pcBuilder.build();
        PC pc_2 = (PC) pcBuilder.build();

        PlayStation.PSBuilder playStation5 = new PlayStation.PSBuilder();
        playStation5.setType(PlayStation.PlayStationType.PS5);
        playStation5.setCpu(new CPU("AMD Ryzen Zen 2",8,3.5));
        playStation5.setGpu(new GPU("AMD Radeon RDNA 2", 18000,12,3));
        playStation5.setRam(new RAM("",16,3666));
        playStation5.setMemoryType(MemoryType.DDR6);
        playStation5.setHardDrive(new HardDrive("",0,5000,5));
        PlayStation ps5_1 = playStation5.build();
        PlayStation ps5_2 = playStation5.build();
        return new Object[][] {{pc_1, pc_2, true},{pc_1,ps5_1,false},{ps5_1,ps5_2,true}};
    }

    @Test(dataProvider = "hashEqualDevice")
    public void hashEqualDeviceTest(Device obj1,Device obj2)
    {
        assertEquals(obj1.hashCode(),obj2.hashCode());
    }
    @DataProvider
    public Object[][] hashEqualDevice()
    {
        PlayStation.PSBuilder playStation5 = new PlayStation.PSBuilder();
        playStation5.setType(PlayStation.PlayStationType.PS5);
        playStation5.setCpu(new CPU("AMD Ryzen Zen 2",8,3.5));
        playStation5.setGpu(new GPU("AMD Radeon RDNA 2", 18000,12,3));
        playStation5.setRam(new RAM("idk",16,3666));
        playStation5.setMemoryType(MemoryType.DDR6);
        playStation5.setHardDrive(new HardDrive("idk",0,5000,5));
        PlayStation ps5_1 = playStation5.build();
        PlayStation ps5_2 = playStation5.build();
        return new Object[][]{ {ps5_1,ps5_2} };
    }

    @Test(dataProvider = "stringEqualDevice")
    public void stringEqualDeviceTest(Device obj1,Device obj2)
    {
        assertEquals(obj1.toString(), obj2.toString());
    }
    @DataProvider
    public Object[][] stringEqualDevice()
    {
        PC.PCBuilder pcBuilder = new PC.PCBuilder();
        pcBuilder.setKeyboard("Razer BlackWidow Chroma V2");
        pcBuilder.setMouse("Logitech G PRO Wireless");
        pcBuilder.setCpu(new CPU("Ryzen 5 3600", 6, 4.2));
        pcBuilder.setGpu(new GPU("MSI 1060",8000,6,2));
        pcBuilder.setRam(new RAM("Hyperx",16,2400));
        pcBuilder.setMemoryType(MemoryType.DDR4);
        pcBuilder.setHardDrive(new HardDrive("Kingston",2.5,5000,5));
        PC pc_1 = (PC) pcBuilder.build();
        PC pc_2 = (PC) pcBuilder.build();

        PlayStation.PSBuilder playStation5 = new PlayStation.PSBuilder();
        playStation5.setType(PlayStation.PlayStationType.PS5);
        playStation5.setCpu(new CPU("AMD Ryzen Zen 2",8,3.5));
        playStation5.setGpu(new GPU("AMD Radeon RDNA 2", 18000,12,3));
        playStation5.setRam(new RAM("",16,3666));
        playStation5.setMemoryType(MemoryType.DDR6);
        playStation5.setHardDrive(new HardDrive("",0,5000,5));
        PlayStation ps5_1 = playStation5.build();
        PlayStation ps5_2 = playStation5.build();
        return new Object[][] {{pc_1,pc_2},{ps5_2,ps5_1}};
    }

}
