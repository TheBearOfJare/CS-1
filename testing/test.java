import csci1140.*;
import java.lang.reflect.Method;

public class test {
    public static void main(String[] args) {

        // KeyboardReader reader = new KeyboardReader();
        
        // Read all the methods in keyboard readers to test them;
        Method[] methods = KeyboardReader.class.getDeclaredMethods();

        for (Method method : methods) {
            try {
                method.invoke(KeyboardReader.class);
            } catch (Exception e) {
                
                System.out.println(e.toString());
            }
        }
    }


}
