package org.SDET;

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
    }
    public static void main( int[] args )
    {
        System.out.println( "Hello World!" );
    }
}
