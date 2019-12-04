/*
 * ToggleSprint v1.0.0 for Minecraft 1.8.9 Forge
 * Copyright (c) 2019 Wardo <https://www.wardo.ml>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package io.github.guyman70718.togglesprint.events;

import io.github.guyman70718.togglesprint.config.ToggleSprintConfig;
import io.github.guyman70718.togglesprint.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;

/** Events for the mod */
public class Events {

  /** Every tick, this method executes. */
  @SubscribeEvent
  public void onTick(ClientTickEvent event) {

    if (ToggleSprintConfig.toggleSprintEnabled) {
      KeyBinding.setKeyBindState(getSprintKeyCode(), true);
    }

  }
  @SubscribeEvent
  public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
    ConfigManager.sync(Reference.MOD_ID, Config.Type.INSTANCE);
    ScaledResolution scaled = new ScaledResolution(Minecraft.getMinecraft());
    int width = scaled.getScaledWidth();
    int height = scaled.getScaledHeight();
    System.out.println(ToggleSprintConfig.guiX*(width-52)+" "+ToggleSprintConfig.guiY*(height-4));
  }

  /** Get the keycode for the sprinting keybind */
  private int getSprintKeyCode() {
    return Minecraft.getMinecraft().gameSettings.keyBindSprint.getKeyCode();
  }
}
