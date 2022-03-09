package org.lumenk.newdayinformation;

import org.bukkit.plugin.java.JavaPlugin;

public final class NewDayInformation extends JavaPlugin {

    private static NewDayInformation instance;
    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        getLogger().info("몰?루");
        getLogger().info("아!루");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


    public static NewDayInformation getInstance() {
        return instance;
    }
}
