package com.bytespacegames.letmespeak.mixins;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MixinMinecraft {
    // i decided not to do this at least not yet cause if i dont handle
    // it perfectly some silly things might happen tehe
    /*@Inject(method="displayGuiScreen", at=@At("HEAD"))
    public void mixin$displayGuiScreen(GuiScreen screen, CallbackInfo ci) {

    }*/
}
