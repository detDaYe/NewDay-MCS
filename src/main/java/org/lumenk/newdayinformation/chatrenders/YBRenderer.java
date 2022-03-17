package org.lumenk.newdayinformation.chatrenders;

import io.papermc.paper.chat.ChatRenderer;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.event.HoverEvent;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;
import org.lumenk.newdayinformation.objects.NewDayMember;
import org.lumenk.newdayinformation.repositories.MemberRepository;

import java.util.Objects;

public class YBRenderer implements ChatRenderer {
    @Override
    public @NotNull Component render(@NotNull Player source, @NotNull Component sourceDisplayName, @NotNull Component message, @NotNull Audience viewer) {
        NewDayMember member = Objects.requireNonNull(MemberRepository.getMember(source.getUniqueId()));
        final int order = member.getOrder();
        final String originMessage = ((TextComponent)message).content();
        final String realName = member.getName();


        return render(order, originMessage, realName, source.getName());
    }

    @NotNull
    private Component render(@Range(from = 25, to = 33) int order, String originMessage, String realName, String name){
        final int colorValue;
        switch (order){
            default -> colorValue = 0xE7FF79;
        }


        final TextComponent orderPrefix = Component.text("<")
                .append(Component.text(order)).color(TextColor.color(colorValue))
                .append(Component.text("기>"))
                .decoration(TextDecoration.ITALIC, TextDecoration.State.TRUE);

        final TextComponent hoverText = Component.text(name + "\n" + realName);
        final TextComponent displayName = Component.text(name).hoverEvent(HoverEvent.showText(hoverText));

        return Component.text("")
                .append(orderPrefix)
                .append(Component.text(" "))
                .append(displayName)
                .append(Component.text(" : "))
                .append(Component.text(originMessage))
                ;

    }
}
