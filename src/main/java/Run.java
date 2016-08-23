import com.mbatok.i2c.lcd.Color;
import com.mbatok.i2c.lcd.I2cLCD;
import com.mbatok.i2c.lcd.LCDFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.i2c.I2CBus;
import com.pi4j.io.i2c.I2CDevice;
import com.pi4j.io.i2c.I2CFactory;
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

        I2cLCD lcd = LCDFactory.createLCD(I2CBus.BUS_1,0x27);
        lcd.setText("test\ntest2\ntest3\ntest4");
        Thread.sleep(4000);
        lcd.setBacklight(Color.OFF);
        Thread.sleep(4000);
        lcd.setBacklight(Color.ON);
        lcd.clear();
        lcd.setText("zielona dupa");
        Thread.sleep(2000);
        lcd.setCursorPosition(3,10);
        lcd.setTextNearCursor("dupa");
        lcd.setBlinkEnabled(true);
        Thread.sleep(2000);
        lcd.setBlinkEnabled(false);
        lcd.setText("zielona dupa");


    }
}
