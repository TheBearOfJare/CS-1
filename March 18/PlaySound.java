import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class PlaySound {

    public static void main(String[] args) throws InterruptedException {
        // String filePath = "Huh.wav";
        
        while(true) {
            playRandomSound();
            Thread.sleep((int)Math.floor(Math.random()*500));
        }
        
    }

    public static void playRandomSound() {

        List<String> options = new ArrayList<>();

        if (Math.random() > 0.9) {

            // big sound effects
            options.add("AAA");
            options.add("crash");
        }
        else {

            // short sound effects
            options.add("Huh");
            options.add("boing");
            options.add("slip");
            // options.add("chatter");
            options.add("honk");
        }
        
        String choice = options.get((int)Math.round(Math.random()*(options.size()-1)));

        playSound(choice+".wav");
        
    }

    public static void playSound(String filePath) {
        try {
            File soundFile = new File(filePath);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}