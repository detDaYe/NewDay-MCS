package org.lumenk.newdayinformation;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.lumenk.newdayinformation.listeners.PlayerJoinListener;

public final class NewDayInformation extends JavaPlugin {

    private static NewDayInformation instance;
    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        getLogger().info("몰?루");
        getLogger().info("아!루");

        final PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new PlayerJoinListener(), this);



    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


    public static NewDayInformation getInstance() {
        return instance;
    }
}
