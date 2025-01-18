package com.bytespacegames.letmespeak;

import net.fabricmc.api.ModInitializer;
import com.bytespacegames.letmespeak.ChatStateManager;

public class LetMeSpeak implements ModInitializer {
    @Override
    public void onInitialize() {
        new ChatStateManager();
    }
}