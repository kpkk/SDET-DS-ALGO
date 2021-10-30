package week12;

public class BinaryString {

    private void pattern(int i) {
        String binary = Integer.toBinaryString(i);
        System.out.println(binary);
        int left = 0, right = 1;
        String output = "YES";
        while(right < binary.length()) {
            if((binary.charAt(left) == '1' && binary.charAt(right) == '0') ||
                    (binary.charAt(left) == '0' && binary.charAt(right) == '1')) {
                left++;right++;
            }else {
                output = "NO";
                break;
            }
        }
        System.out.println(output);
    }
}
