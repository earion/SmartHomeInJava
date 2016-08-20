import com.batok.i2c.LCDController;
import com.pi4j.io.gpio.*;
import com.pi4j.io.i2c.I2CBus;
import com.pi4j.io.i2c.I2CDevice;
import com.pi4j.io.i2c.I2CFactory;
import com.pi4j.jni.I2C;
import com.pi4j.system.SystemInfo;

import java.io.IOException;

/**
 * Created by mateusz on 17.08.16.
 */



public class Run {
    private static GpioPinDigitalOutput RSpin;
    private static GpioPinDigitalOutput ENpin;

    public static void main(String[] args) throws IOException, InterruptedException, I2CFactory.UnsupportedBusNumberException {
        System.out.println(SystemInfo.getCpuTemperature());


        I2CBus i2CBus= I2CFactory.getInstance(1);
        I2CDevice i2CDevice = i2CBus.getDevice(27);
        System.out.print(i2CDevice.getAddress());

    }
}
