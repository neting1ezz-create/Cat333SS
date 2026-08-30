package com.cat333ss.chestfix;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        // Register listener
        getServer().getPluginManager().registerEvents(new ChestListener(), this);
        // Register commands
        this.getCommand("ss").setExecutor(new SSCommand(this));
        this.getCommand("arena").setExecutor(new ArenaCommand());
        getLogger().info("Cat333SS enabled");
    }

    @Override
    public void onDisable() {
        getLogger().info("Cat333SS disabled");
    }
}
