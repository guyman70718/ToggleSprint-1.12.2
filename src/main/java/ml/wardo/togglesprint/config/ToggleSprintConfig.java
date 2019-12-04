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

package ml.wardo.togglesprint.config;

import ml.wardo.togglesprint.ToggleSprint;
import ml.wardo.togglesprint.util.Reference;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.sql.Ref;

/** Stores settings for ToggleSprint */
@Config(modid = Reference.MOD_ID)
public class ToggleSprintConfig {
  @Config.Name("Toggle Sprint Enabled")
  public static boolean toggleSprintEnabled;
  @Config.Name("X position (0 for left, 1 for middle, 2 for right)")
  public static int guiX;
  @Config.Name("Y position (0 for top, 1 for middle, 2 for bottom)")
  public static int guiY;
  @Config.Name("Color (hexadecimal)")
  public static String color = "FFAA00";
  @Config.Name("Text Shadow")
  public static boolean textShadow;

//  private static Property propertyToggleSprintEnabled;
//  private static Property propertyGuiX;
//  private static Property propertyGuiY;

  /** Load config */
  public static void loadConfig() {
    ToggleSprint.config.load();
//    propertyToggleSprintEnabled = ToggleSprint.config.get("General","Togglesprint Enabled", true);
//    propertyGuiX = ToggleSprint.config.get("General", "X position (0 for left, 1 for middle, 2 for right)", 0);
//    propertyGuiY = ToggleSprint.config.get("General", "Y position (0 for top, 1 for middle, 2 for bottom)", 0);
    toggleSprintEnabled = ToggleSprint.config.get("General","Togglesprint Enabled", true).getBoolean();
    guiX = ToggleSprint.config.get("General", "X position (0 for left, 1 for middle, 2 for right)", 0).getInt();
    guiY = ToggleSprint.config.get("General", "Y position (0 for top, 1 for middle, 2 for bottom)", 0).getInt();
//    toggleSprintEnabled = propertyToggleSprintEnabled.getBoolean();
//    guiX = propertyGuiX.getInt();
//    guiY = propertyGuiY.getInt();
    //syncConfig();
  }


  /** Sync config */
  public static void syncConfig() {
    ToggleSprint.config.get("General","Togglesprint Enabled", true).set(toggleSprintEnabled);

    ToggleSprint.config.get("General", "X position (0 for left, 1 for middle, 2 for right)", 0).set(guiX);
    ToggleSprint.config.get("General", "Y position (0 for top, 1 for middle, 2 for bottom)", 0).set(guiY);

    ToggleSprint.config.save();
  }
}
