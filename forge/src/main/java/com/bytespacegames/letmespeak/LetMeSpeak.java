package com.bytespacegames.letmespeak;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = LetMeSpeak.MODID, version = LetMeSpeak.VERSION)
public class LetMeSpeak {
    public static final String MODID = "letmespeak";
    public static final String VERSION = "1.0";
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        //Display.setTitle("yoy");
        new ChatStateManager();
    }
}
