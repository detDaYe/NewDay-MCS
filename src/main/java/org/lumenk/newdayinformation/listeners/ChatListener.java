package org.lumenk.newdayinformation.listeners;

import io.papermc.paper.chat.ChatRenderer;
import io.papermc.paper.event.player.AsyncChatEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.lumenk.newdayinformation.chatrenders.NewDayChatRender;

public class ChatListener implements Listener {
    final ChatRenderer renderer = new NewDayChatRender();

    @EventHandler
    public void onChat(AsyncChatEvent event){
        //Compoevent.originalMessage();
        final Player player = event.getPlayer();
        event.renderer(renderer);
    }

}
