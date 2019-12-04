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

package ml.wardo.togglesprint;

import javafx.scene.control.Toggle;
import ml.wardo.togglesprint.commands.Commands;
import ml.wardo.togglesprint.config.ToggleSprintConfig;
import ml.wardo.togglesprint.events.Events;
import ml.wardo.togglesprint.util.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import sun.security.krb5.Config;

import java.io.File;

/**
 * Togglesprint version 1.0.0-pre By Warrick "Wardo" Lo <https://www.wardo.ml>
 *
 * <p>Initializes the mod.
 */
@Mod(
    modid = Reference.MOD_ID,
    name = Reference.NAME,
    version = Reference.VERSION,
    acceptedMinecraftVersions = Reference.ACCEPTED_VERSIONS)
public class ToggleSprint {

  private static final File CONFIG_FILE_PATH = new File("config/togglesprint.cfg");
  public static final ResourceLocation WIDGETS_TEX_PATH = new ResourceLocation("textures/gui/icons.png");
  public static Configuration config;

  /** Mod loader */
  @Instance public static ToggleSprint instance;

  @EventHandler
  public static void preInit(FMLPreInitializationEvent event) {
    // Init config
    //config = new Configuration(CONFIG_FILE_PATH);
    //MinecraftForge.EVENT_BUS.register(new ToggleSprintConfig());
    // Load config
    //ToggleSprintConfig.loadConfig();
  }

  @EventHandler
  public static void init(FMLInitializationEvent event) {
    // Events
    MinecraftForge.EVENT_BUS.register(new Events());

    // Commands
    ClientCommandHandler.instance.registerCommand(new Commands());
  }
  @EventHandler
  public static void postInit(FMLPostInitializationEvent event){
    MinecraftForge.EVENT_BUS.register(new RenderGuiHandler());
  }
}
