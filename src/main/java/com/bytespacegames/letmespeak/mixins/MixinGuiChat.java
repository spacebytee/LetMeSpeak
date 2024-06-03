package com.bytespacegames.letmespeak.mixins;

import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import com.bytespacegames.letmespeak.ChatStateManager;

@Mixin(GuiChat.class)
public class MixinGuiChat {
    @Shadow
    protected GuiTextField inputField;
    @Inject(method="keyTyped", at=@At("RETURN"))
    protected void mixin$keyTyped(char typedChar, int keyCode, CallbackInfo ci) {
        if (keyCode == 1 || keyCode == 156 || keyCode == 28) {
            ChatStateManager.INSTANCE.resetState();
        } else {
            ChatStateManager.INSTANCE.updateState(inputField.getText());
        }
    }
    @Inject(method="initGui", at=@At("RETURN"))
    public void mixin$initGui(CallbackInfo ci) {
        if (!ChatStateManager.INSTANCE.restoreState())  {
            return;
        }
        inputField.setText(ChatStateManager.INSTANCE.getState());
    }
}
