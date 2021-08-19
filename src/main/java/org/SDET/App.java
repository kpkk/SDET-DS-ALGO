package org.SDET;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.Optional;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        int k=27;
        for (int i=1;i<k/2+1;i++){
            if(i*i==k) System.out.println(i);
            else if(i*i<k && (i+1)*(i+1)>k) System.out.println(i);
        }
        System.out.println(Math.sqrt(k));
        RemoteWebDriver driver=new ChromeDriver();
        driver.findElement(By.xpath("")).sendKeys("","","", Keys.ARROW_LEFT);
    }
    public static void main( int[] args )
    {
        System.out.println( "Hello World!" );
    }
}
