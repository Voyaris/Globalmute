package de.Flubbii.Plugin.Command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import de.Flubbii.Plugin.Utils.Messages;

public class GlobalMute implements CommandExecutor, Listener {
	private static Boolean Status = false;

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if (cs instanceof Player) {
			Player p = (Player) cs;
			if (p.hasPermission(Messages.getMessage("Permission.Command"))) {
				if (args.length == 0) {
					if (Status) {
						Status = false;
						Bukkit.broadcastMessage(Messages.getMessage("Message.Deactivated.1").replace("%Prefix%", Messages.getMessage("Prefix")).replace("%who%", p.getName()));
					} else {
						Status = true;
						Bukkit.broadcastMessage(Messages.getMessage("Message.Activated.1").replace("%Prefix%", Messages.getMessage("Prefix")).replace("%who%", p.getName()));
					}
				} else {
					String Message = "";
					for (int i = 0; i < args.length; i++) {
						Message += args[i] + " ";
					}
					if (Status) {
						Status = false;
						Bukkit.broadcastMessage(Messages.getMessage("Message.Deactivated.1").replace("%Prefix%", Messages.getMessage("Prefix")).replace("%who%", p.getName()));
						Bukkit.broadcastMessage(Messages.getMessage("Message.Deactivated.2").replace("%Prefix%", Messages.getMessage("Prefix")).replace("%who%", p.getName()).replace("%Reason%", ChatColor.translateAlternateColorCodes('&', Message)));
					} else {
						Status = true;
						Bukkit.broadcastMessage(Messages.getMessage("Message.Activated.1").replace("%Prefix%", Messages.getMessage("Prefix")).replace("%who%", p.getName()));
						Bukkit.broadcastMessage(Messages.getMessage("Message.Activated.2").replace("%Prefix%", Messages.getMessage("Prefix")).replace("%who%", p.getName()).replace("%Reason%", ChatColor.translateAlternateColorCodes('&', Message)));
					}
				}
			} else {
				p.sendMessage(Messages.getMessage("NoPermission").replace("%Prefix%", Messages.getMessage("Prefix")));
			}
		} else {
			if (args.length == 0) {
				if (Status) {
					Status = false;
					Bukkit.broadcastMessage(Messages.getMessage("Message.Deactivated.1").replace("%Prefix%", Messages.getMessage("Prefix")).replace("%who%", cs.getName()));
				} else {
					Status = true;
					Bukkit.broadcastMessage(Messages.getMessage("Message.Activated.1").replace("%Prefix%", Messages.getMessage("Prefix")).replace("%who%", cs.getName()));
				}
			} else {
				String Message = "";
				for (int i = 0; i < args.length; i++) {
					Message += args[i] + " ";
				}
				if (Status) {
					Status = false;
					Bukkit.broadcastMessage(Messages.getMessage("Message.Deactivated.1").replace("%Prefix%", Messages.getMessage("Prefix")).replace("%who%", cs.getName()));
					Bukkit.broadcastMessage(Messages.getMessage("Message.Deactivated.2").replace("%Prefix%", Messages.getMessage("Prefix")).replace("%who%", cs.getName()).replace("%Reason%", ChatColor.translateAlternateColorCodes('&', Message)));
				} else {
					Status = true;
					Bukkit.broadcastMessage(Messages.getMessage("Message.Activated.1").replace("%Prefix%", Messages.getMessage("Prefix")).replace("%who%", cs.getName()));
					Bukkit.broadcastMessage(Messages.getMessage("Message.Activated.2").replace("%Prefix%", Messages.getMessage("Prefix")).replace("%who%", cs.getName()).replace("%Reason%", ChatColor.translateAlternateColorCodes('&', Message)));
				}
			}
		}
		return false;
	}

	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		if (Status) {
			if (!p.hasPermission(Messages.getMessage("Permission.ByPass"))) {
				e.setCancelled(true);
				p.sendMessage(Messages.getMessage("Activated").replace("%Prefix%", Messages.getMessage("Prefix")));
			}
		}
	}
}
