public class Filing {
    
    public static void main(String[] args) {
        int[][] desk = new int[12][12];

        for (int i = 0; i < desk.length; i++) {
            for (int j = 0; j < desk[i].length; j ++) {
                desk[i][j] = (i+1)*(j+1);
                System.out.print(desk[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
