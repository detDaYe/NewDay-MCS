package org.lumenk.newdayinformation.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.lumenk.newdayinformation.repositories.MemberRepository;

public class NewDayInfoCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(args.length == 0)
            return false;

        switch (args[0]){
            case "load" ->{
                MemberRepository.load();
            }

            case "save"->{
                MemberRepository.save();
            }

            default -> {return  false;}
        }
        return true;
    }
}
