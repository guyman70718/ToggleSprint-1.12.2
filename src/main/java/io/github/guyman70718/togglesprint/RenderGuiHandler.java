package io.github.guyman70718.togglesprint;

import io.github.guyman70718.togglesprint.config.ToggleSprintConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class RenderGuiHandler {
    int width,height;
    int x,y;

    @SubscribeEvent
    public void onRenderGui(RenderGameOverlayEvent.Post event) {
        if(ToggleSprintConfig.toggleSprintEnabled) {
            ScaledResolution scaled = new ScaledResolution(Minecraft.getMinecraft());
            width = scaled.getScaledWidth();
            height = scaled.getScaledHeight();

            if (ToggleSprintConfig.guiX == 0) x = 0;
            else if (ToggleSprintConfig.guiX == 1) x = (width / 2)-52;
            else if (ToggleSprintConfig.guiX == 2) x = width-105;
            if (ToggleSprintConfig.guiY == 0) y = 0;
            else if (ToggleSprintConfig.guiY == 1) y = (height / 2)-4;
            else if (ToggleSprintConfig.guiY == 2) y = height-8;

            if(ToggleSprintConfig.textShadow) Minecraft.getMinecraft().fontRenderer.drawString("[Sprinting (Toggled)]", x+1, y+1, Integer.parseInt("303030", 16));
            Minecraft.getMinecraft().fontRenderer.drawString("[Sprinting (Toggled)]", x, y, Integer.parseInt(ToggleSprintConfig.color, 16));
            Minecraft.getMinecraft().renderEngine.bindTexture(ToggleSprint.WIDGETS_TEX_PATH);
            GlStateManager.color(1, 1, 1);
        }else if(Minecraft.getMinecraft().player.isSprinting()){
            if(ToggleSprintConfig.textShadow) Minecraft.getMinecraft().fontRenderer.drawString("[Sprinting (Vanilla)]", x+1, y+1, Integer.parseInt("303030", 16));
            Minecraft.getMinecraft().fontRenderer.drawString("[Sprinting (Vanilla)]", x, y, Integer.parseInt(ToggleSprintConfig.color, 16));
            Minecraft.getMinecraft().renderEngine.bindTexture(ToggleSprint.WIDGETS_TEX_PATH);
            GlStateManager.color(1, 1, 1);
        }
    }
}
