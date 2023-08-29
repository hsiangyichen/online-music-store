package ui.tools;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.io.File;

public class Sound {

    public Sound() {
        playMusic("Dog and Pony Show.wav");
    }

    /*
     * MODIFIES: this
     * EFFECTS: create an audio with a filepath
     */
    public static void playMusic(String filepath) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(filepath).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"error");
        }
    }
}
