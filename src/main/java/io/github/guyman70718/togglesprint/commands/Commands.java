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

package io.github.guyman70718.togglesprint.commands;

import io.github.guyman70718.togglesprint.config.ToggleSprintConfig;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

import java.util.Collections;
import java.util.List;

/** The command `/togglesprint` */
public class Commands extends CommandBase {
//  @Override
//  public void execute(MinecraftServer server, ICommandSender sender, String[] params) throws CommandException {
//    if (params != null && params.length > 0) {
//      for (String param : params) {
//        String message = "Echo : " + param;
//        TextComponentString text = new TextComponentString(message);
//        text.getStyle().setColor(TextFormatting.RED);
//        sender.sendMessage(text);
//      }
//    }
//  }

  /** Gets command name */
  @Override
  public String getName() {
    return "togglesprint";
  }

  /** Sets command to "/togglesprint" */
  @Override
  public String getUsage(ICommandSender sender) {
    return "/" + getName();
  }

  /** Sets command alias to "/ts" */
  @Override
  public List<String> getAliases() {
    return Collections.singletonList("ts");
  }

  /** Processes command */
  //@Override
  public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {

    // If no arguments are found, show the command usage.
    if (args.length == 0) {
      sender.sendMessage(
          new TextComponentString(
              TextFormatting.RED
                  + "Usage: /togglesprint <toggle, enable, disable>"));
    } else {

      switch (args[0].toLowerCase()) {
        case "t":
        case "toggle":
          if (ToggleSprintConfig.toggleSprintEnabled) {
            ToggleSprintConfig.toggleSprintEnabled = false;
            sender.sendMessage(
                new TextComponentString(
                    TextFormatting.AQUA + "ToggleSprint: "
                        + TextFormatting.RED + "Off"));
          } else {
            ToggleSprintConfig.toggleSprintEnabled = true;
            sender.sendMessage(
                new TextComponentString(
                    TextFormatting.AQUA + "ToggleSprint: "
                        + TextFormatting.RED + "On"));
          }
          break;

        case "on":
        case "e":
        case "enable":
          ToggleSprintConfig.toggleSprintEnabled = true;
          sender.sendMessage(
              new TextComponentString(
                  TextFormatting.AQUA + "ToggleSprint: "
                      + TextFormatting.RED + "On"));
          break;

        case "off":
        case "d":
        case "disable":
          ToggleSprintConfig.toggleSprintEnabled = false;
          sender.sendMessage(
              new TextComponentString(
                  TextFormatting.AQUA + "ToggleSprint: "
                      + TextFormatting.RED + "Off"));
          break;

        default:
          sender.sendMessage(
              new TextComponentString(
                  TextFormatting.RED
                      + "Invalid arguments! Usage: /togglesprint <toggle, enable, disable>"));
          break;
      }

      // Sync the config file.
      //ToggleSprintConfig.syncConfig();
    }
  }

  // Set the permission level to 0.
  @Override
  public int getRequiredPermissionLevel() {
    return 0;
  }

  // Command sender is allowed to use the command.
  //@Override
  public boolean canCommandSenderUseCommand(ICommandSender sender) {
    return true;
  }
}
