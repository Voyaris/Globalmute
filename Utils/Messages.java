package de.Flubbii.Plugin.Utils;

import org.bukkit.configuration.file.FileConfiguration;

public class Messages {
	private static FileConfiguration cfg = Config.cfg;

	public static void create() {
		if (cfg.getString("Config.Permission.Command") == null) {
			cfg.set("Config.Permission.Command", "GlobalMute.Use");
		}
		if (cfg.getString("Config.Permission.ByPass") == null) {
			cfg.set("Config.Permission.ByPass", "GlobalMute.ByPass");
		}
		if (cfg.getString("Config.Prefix") == null) {
			cfg.set("Config.Prefix", "&8[&eGlobalMute&8]&7");
		}
		if (cfg.getString("Config.NoPermission") == null) {
			cfg.set("Config.NoPermission", "%Prefix% &cYou don't have the permission to use this command.");
		}
		if (cfg.getString("Config.Activated.1") == null) {
			cfg.set("Config.Activated", "%Prefix% &cThe chat was &4deactivated &7by &e%who%&7!");
		}
		if (cfg.getString("Config.Activated.2") == null) {
			cfg.set("Config.Activated.2", "%Prefix% Reason: &e%Reason%");
		}
		if (cfg.getString("Config.Deactivated.1") == null) {
			cfg.set("Config.Activated", "%Prefix% &cThe chat was &2activated &cby &e%who%&7!");
		}
		if (cfg.getString("Config.Deactivated.2") == null) {
			cfg.set("Config.Deactivated.2", "%Prefix% Reason: &e%Reason%");
		}
		if (cfg.getString("Config.Inactive") == null) {
			cfg.set("Config.Inactive", "%Prefix% The chat is currently deactivated");
		}
		Config.save();
	}

	public static String getMessage(String Nachricht) {
		return cfg.getString("Config." + Nachricht).replaceAll("&", "§");
	}
}
