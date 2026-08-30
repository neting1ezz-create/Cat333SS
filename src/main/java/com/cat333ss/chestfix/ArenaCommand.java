package com.cat333ss.chestfix;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ArenaCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command.");
            return true;
        }
        Player p = (Player) sender;
        Component prefix = Component.text("Arena » ").color(NamedTextColor.GOLD);
        Component msg = Component.text("Событие начнётся через 3 минуты!").color(TextColor.color(0xFFA500));
        p.sendMessage(prefix.append(msg));
        return true;
    }
}
