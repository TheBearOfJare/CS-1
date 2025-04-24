public class Smile {

    public static void main(String[] args) {
        
        int[][][][] nums = new int[4][4][4][4];

        int num = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                for (int k = 0; k < nums[i][j].length; k++) {
                    for (int l = 0; l < nums[i][j][k].length; l++) {
                        nums[i][j][k][l] = num++;
                        System.out.print(nums[i][j][k][l] + " ");
                    }
                    System.out.println("");
                }
                System.out.println("");
            }
            System.out.println("");
        }

    }
}
