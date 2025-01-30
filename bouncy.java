public class bouncy {

    public static void printGrid (int x, double y) {
        String grid = "";
        for (int i = 0; i<20; i++) {
            
            if (Math.abs(i-y) <= 0.5) {
                for (int n = 0; n<20; n++) {
                    if (n == x){
                        grid+=" 0 ";
                    }
                    else {
                        grid+="___";
                    }
                }

                grid+="\n";
            }
            else {
                for (int n = 0; n<20; n++) {
                    grid+="___";
                }
                grid+="\n";

            }
            
            
        }

        System.out.println(grid);
        
        
    }

    public static void main (String[] args) {
        while (true) {
            int x = 0;
            float y = 20;
            float velocity = 0;
            double acceleration = -2.81;
            double springFactor = 0.9;
            while (x < 20) {
                y = y + velocity;
                velocity += acceleration;
                if (y <= 0) {
                    velocity*=-1 * springFactor;
                }
                x++;

                printGrid(x,y);
            }
            break;
            
        }
        //printGrid(10,10);

    }

    

    
}
