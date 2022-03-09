package org.lumenk.newdayinformation.listeners;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        final Player player = event.getPlayer();

        final Component msg = Component.text(player.getName()).color(TextColor.color(0xFFAA00))
                .append(Component.text("님이 접속하셨습니다.").color(TextColor.color(0xFFFF00)))
                .decoration(TextDecoration.ITALIC, false)
                ;

        event.joinMessage(msg);
    }
}
