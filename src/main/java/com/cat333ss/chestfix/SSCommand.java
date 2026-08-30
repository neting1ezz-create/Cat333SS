package com.cat333ss.chestfix;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class SSCommand implements CommandExecutor {
    private final JavaPlugin plugin;

    public SSCommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command.");
            return true;
        }
        Player p = (Player) sender;
        if (args.length == 0) {
            p.sendMessage("Usage: /ss spawn");
            return true;
        }
        if (args[0].equalsIgnoreCase("spawn")) {
            // spawn chest near player (2 blocks in front)
            Location loc = p.getLocation().add(p.getLocation().getDirection().normalize().multiply(2));
            // round to block
            loc.setX(Math.floor(loc.getX()) + 0.5);
            loc.setY(Math.floor(loc.getY()));
            loc.setZ(Math.floor(loc.getZ()) + 0.5);

            // find a nearby suitable block (air) up to 5 blocks above
            Block target = null;
            for (int y = 0; y <= 5; y++) {
                Block b = loc.getWorld().getBlockAt(loc.getBlockX(), loc.getBlockY() + y, loc.getBlockZ());
                if (b.getType().isAir()) { target = b; break; }
            }
            if (target == null) {
                p.sendMessage("§cНе удалось заспавнить сундук — поблизости нет свободного места.");
                return true;
            }
            target.setType(Material.CHEST);
            p.sendMessage("§eСундук заспавнен.");
            return true;
        }
        p.sendMessage("Unknown subcommand.");
        return true;
    }
}
