package org.lumenk.newdayinformation.chatrenders;

import io.papermc.paper.chat.ChatRenderer;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.event.HoverEvent;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.lumenk.newdayinformation.objects.NewDayMember;
import org.lumenk.newdayinformation.repositories.MemberRepository;

public class NewDayChatRender implements ChatRenderer {
    @Override
    public @NotNull Component render(@NotNull Player source, @NotNull Component sourceDisplayName, @NotNull Component message, @NotNull Audience viewer) {
        Component result = render(source, message);
        if(result == null) result = ChatRenderer.defaultRenderer().render(source, sourceDisplayName, message, viewer);
        return result;
    }

    private @Nullable Component render(@NotNull Player player, @NotNull Component origin){
        NewDayMember member = MemberRepository.getMember(player.getUniqueId());
        if(member == null)return null;
        final String originText;
        try {
            originText = ((TextComponent) origin).content();
        }catch (Exception e){
            return null;
        }

        return Component.text("<")
                .append(Component.text(member.getOrder()))
                .append(Component.text("기>"))
                .append(Component.text(player.getName()).hoverEvent(HoverEvent.showText(Component.text(member.getName()))))
                .append(Component.text(" : "))
                .append(Component.text(originText));


    }
}
