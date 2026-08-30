package com.cat333ss.chestfix;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.block.Action;

public class ChestListener implements Listener {
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        if (e.getAction() != Action.RIGHT_CLICK_BLOCK) return;
        Block b = e.getClickedBlock();
        if (b == null) return;
        Material t = b.getType();
        if (t == Material.CHEST || t == Material.TRAPPED_CHEST) {
            e.setCancelled(true); // quietly block opening
            // no message, no global broadcast, no sound by default
        }
    }
}
