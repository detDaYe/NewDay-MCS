package org.lumenk.newdayinformation;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.lumenk.newdayinformation.commands.NewDayInfoCommand;
import org.lumenk.newdayinformation.listeners.ChatListener;
import org.lumenk.newdayinformation.listeners.MOTDListener;
import org.lumenk.newdayinformation.listeners.PlayerJoinListener;
import org.lumenk.newdayinformation.objects.NewDayMember;
import org.lumenk.newdayinformation.repositories.MemberRepository;
import org.lumenk.newdayinformation.tabcompleter.NewDayInfoCompleter;

import java.util.Objects;
import java.util.UUID;

public final class NewDayInformation extends JavaPlugin {

    @Getter
    private static final NewDayMember dementer = NewDayMember.builder()
            .name("박세현")
            .playerUUID(UUID.fromString("fc88a056-0e73-409c-a4b2-adb3d72281fd"))
            .order(30)
            .build();


    private static NewDayInformation instance;
    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        getLogger().info("몰?루");
        getLogger().info("아!루");

        final PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new PlayerJoinListener(), this);
        pm.registerEvents(new MOTDListener(), this);
        pm.registerEvents(new ChatListener(), this);

        MemberRepository.load();
        MemberRepository.putMember(dementer);

        Objects.requireNonNull(getCommand("newinfo")).setExecutor(new NewDayInfoCommand());
        Objects.requireNonNull(getCommand("newinfo")).setTabCompleter(new NewDayInfoCompleter());



    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        MemberRepository.save();
    }


    public static NewDayInformation getInstance() {
        return instance;
    }
}
