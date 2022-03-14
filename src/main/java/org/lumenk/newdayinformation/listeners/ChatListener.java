package org.lumenk.newdayinformation.listeners;

import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.lumenk.newdayinformation.NewDayInformation;

public class ChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncChatEvent event){
        //Compoevent.originalMessage();
        TextComponent origin = (TextComponent) event.originalMessage();
        if(!event.getPlayer().getUniqueId().equals(NewDayInformation.getDementer().getPlayerUUID()))return;

        event.getPlayer().sendMessage(origin.content());
    }

}
