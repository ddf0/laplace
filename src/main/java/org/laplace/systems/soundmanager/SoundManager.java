package org.laplace.systems.soundmanager;

import com.raylib.Jaylib;
import com.raylib.Raylib;
import org.laplace.Game;

import java.util.HashMap;

import static com.raylib.Jaylib.RAYWHITE;
import static com.raylib.Raylib.*;

public class SoundManager {

        public HashMap<String, Raylib.Sound> sounds;

        public SoundManager() {
            InitAudioDevice();

            sounds = new HashMap<String, Raylib.Sound>();

            this.LoadSound("battlebeggining", "target/sounds/battle/battlebeggining.wav");

            this.LoadSound("footstep1", "target/sounds/ambient/footstep1.wav");
            this.LoadSound("footstep2", "target/sounds/ambient/footstep2.wav");
            this.LoadSound("footstep3", "target/sounds/ambient/footstep3.wav");

            this.LoadSound("dice1", "target/sounds/battle/dice1.wav");
            this.LoadSound("dice2", "target/sounds/battle/dice2.wav");
            this.LoadSound("shake", "target/sounds/battle/shake.wav");

            this.LoadSound("screm", "target/sounds/ambient/screm.wav");
        }

        public void LoadSound(String name, String path) {
            Raylib.Sound sound = Raylib.LoadSound(path);
            sounds.put(name, sound);
        }

        public void PlaySound(String name, float value) {
            SetSoundVolume(sounds.get(name), value);
            PlaySoundMulti(sounds.get(name));
        }

        public void unloadSound(String name) {
            UnloadSound(sounds.get(name));
        }
}
