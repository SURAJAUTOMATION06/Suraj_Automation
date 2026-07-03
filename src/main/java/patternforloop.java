
    public class patternforloop {
        public static void main(String[] args) {
            int rows = 5; // You can change this value to make the pyramid taller

            for (int i = 1; i <= rows; i++) {

                // 1. Print leading spaces to center the stars
                for (int j = i; j < rows; j++) {
                    System.out.print(" ");
                }

                // 2. Print the stars
                // The formula (2 * i - 1) ensures an odd number of stars per row
                for (int k = 1; k <= (2 * i - 1); k++) {
                    System.out.print("*");
                }

                // 3. Move to the next line
                System.out.println();
            }
        }
}
