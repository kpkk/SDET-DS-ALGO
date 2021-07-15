package day3;

public class BitWiseOps {

    public static void main(String[] args) {
        int a=-17, b=10;  // 0111+1010-->1111
        System.out.println(a|b); //- either of the input is true o/p is 1-->0111+1010-->1111
        System.out.println(a&b); //- both the inputs are true then o/p is 1-->0111+1010-->0010
        System.out.println(a^b); //- if the bits ar different then o/p is 1 else 0-->0111+1010-->1101
        System.out.println(~b); //- it inverts the value, gives 2's complement-->

        //shift operators

        System.out.println(a<<1);
        System.out.println(a>>1);
        System.out.println(b>>>1);
        System.out.println(b>>1);

        System.out.println(Math.abs(a+b));
    }
}
