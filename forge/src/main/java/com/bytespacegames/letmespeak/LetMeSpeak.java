package com.bytespacegames.letmespeak;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod("letmespeak")
public class LetMeSpeak {
    public static final String MODID = "letmespeak";
    public static final String VERSION = "1.0";
    public LetMeSpeak() {
        new ChatStateManager();
    }
}
