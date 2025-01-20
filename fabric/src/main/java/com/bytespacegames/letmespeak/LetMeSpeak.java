package com.bytespacegames.letmespeak;

import net.fabricmc.api.ClientModInitializer;
import com.bytespacegames.letmespeak.ChatStateManager;

public class LetMeSpeak implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        new ChatStateManager();
    }
}