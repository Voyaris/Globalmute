package de.Flubbii.Plugin.Main;

import org.bukkit.plugin.java.JavaPlugin;

import de.Flubbii.Plugin.Command.GlobalMute;
import de.Flubbii.Plugin.Utils.Config;
import de.Flubbii.Plugin.Utils.Messages;

public class Main extends JavaPlugin {
	@Override
	public void onEnable() {
		super.onEnable();
		Config.save();
		Messages.create();
		getCommand("globalmute").setExecutor(new GlobalMute());
		getServer().getPluginManager().registerEvents(new GlobalMute(), this);
	}
}
