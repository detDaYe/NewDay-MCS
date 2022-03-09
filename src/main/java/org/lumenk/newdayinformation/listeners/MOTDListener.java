package org.lumenk.newdayinformation.listeners;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class MOTDListener implements Listener {

    @EventHandler
    public void onServerListPing(ServerListPingEvent event){
        final TextComponent motd = Component.text("새").color(TextColor.color(0xFF0000))
                .append(Component.text("날").color(TextColor.color(0xFF8800)))
                .append(Component.text("그").color(TextColor.color(0xFFFF00)))
                .append(Component.text("리").color(TextColor.color(0x00AFFF)))
                .append(Component.text("기").color(TextColor.color(0xA000FF)))
                .decoration(TextDecoration.ITALIC, false)
                ;
        event.motd(motd);
    }
}
