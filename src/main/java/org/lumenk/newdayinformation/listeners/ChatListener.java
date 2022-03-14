package org.lumenk.newdayinformation.listeners;

import io.papermc.paper.chat.ChatRenderer;
import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.event.HoverEvent;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.lumenk.newdayinformation.NewDayInformation;
import org.lumenk.newdayinformation.chatrenders.NewDayChatRender;
import org.lumenk.newdayinformation.objects.NewDayMember;
import org.lumenk.newdayinformation.repositories.MemberRepository;

public class ChatListener implements Listener {
    final ChatRenderer renderer = new NewDayChatRender();

    @EventHandler
    public void onChat(AsyncChatEvent event){
        //Compoevent.originalMessage();
        final Player player = event.getPlayer();
        event.renderer(renderer);
    }

}
