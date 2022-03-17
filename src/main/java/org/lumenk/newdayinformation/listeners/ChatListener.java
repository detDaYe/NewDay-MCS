package org.lumenk.newdayinformation.listeners;

import io.papermc.paper.chat.ChatRenderer;
import io.papermc.paper.event.player.AsyncChatEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.lumenk.newdayinformation.chatrenders.NewDayChatRender;
import org.lumenk.newdayinformation.chatrenders.YBRenderer;
import org.lumenk.newdayinformation.objects.NewDayMember;
import org.lumenk.newdayinformation.repositories.MemberRepository;

public class ChatListener implements Listener {
    final YBRenderer ybRenderer = new YBRenderer();
    @EventHandler
    public void onChat(AsyncChatEvent event){
        //Compoevent.originalMessage();
        final Player player = event.getPlayer();
        final NewDayMember member = MemberRepository.getMember(player.getUniqueId());
        if(member == null)return;
        if(member.getOrder() == -1)return;
        event.renderer(ybRenderer);
    }

}
