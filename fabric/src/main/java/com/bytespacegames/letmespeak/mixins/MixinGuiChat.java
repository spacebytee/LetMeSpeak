package com.bytespacegames.letmespeak.mixins;

import net.minecraft.client.gui.screen.ChatScreen;
import com.bytespacegames.letmespeak.ChatStateManager;
import net.minecraft.client.gui.widget.TextFieldWidget;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ChatScreen.class)
public class MixinGuiChat {
    @Shadow
    protected TextFieldWidget chatField;
    @Inject(method="keyPressed", at=@At("RETURN"))
    protected boolean mixin$keyPressed(int keycode, int scancode, int modifiers, CallbackInfoReturnable<Boolean> ci) {
        if (scancode == 1 || scancode == 156 || scancode == 28) {
            ChatStateManager.INSTANCE.resetState();
        } else {
            ChatStateManager.INSTANCE.updateState(chatField.getText());
        }
        return false;
    }
    @Inject(method="init", at=@At("RETURN"))
    public void mixin$init(CallbackInfo ci) {
        if (!ChatStateManager.INSTANCE.restoreState())  {
            return;
        }
        chatField.setText(ChatStateManager.INSTANCE.getState());
    }
}
