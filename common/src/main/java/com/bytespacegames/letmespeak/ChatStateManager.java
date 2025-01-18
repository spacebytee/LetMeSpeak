package com.bytespacegames.letmespeak;

public class ChatStateManager {
    public static ChatStateManager INSTANCE;
    public ChatStateManager() {
        INSTANCE = this;
    }
    private String saveState = "";
    private boolean shouldStateRestore = false;
    public void updateState(String content) {
        if (content.length() == 0) {
            shouldStateRestore = false;
            return;
        }
        shouldStateRestore = true;
        saveState = content;
    }
    public void resetState() {
        saveState = "";
        shouldStateRestore = false;
    }
    public boolean restoreState() {
        return shouldStateRestore;
    }
    public String getState() {
        return saveState;
    }
}
