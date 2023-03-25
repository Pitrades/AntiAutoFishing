package org.silvius.antiautofishing;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class BlockListeners implements Listener {
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getClickedBlock() != null) {
            if (event.getClickedBlock().getType() == Material.NOTE_BLOCK &&
                    event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                if (event.getPlayer().getInventory().getItemInMainHand().getType() == Material.FISHING_ROD) {
                    ItemStack item = event.getPlayer().getInventory().getItemInMainHand();
                    ItemStack itemToRemove = item.clone();
                    event.getPlayer().getInventory().getItemInMainHand().setAmount(0);
                    event.getPlayer().getWorld().dropItem(event.getPlayer().getLocation(), itemToRemove);
                    event.setCancelled(true);
                } else if (event.getPlayer().getInventory().getItemInOffHand().getType() == Material.FISHING_ROD) {
                    ItemStack item = event.getPlayer().getInventory().getItemInOffHand();
                    ItemStack itemToRemove = item.clone();
                    event.getPlayer().getInventory().getItemInOffHand().setAmount(0);
                    event.getPlayer().getWorld().dropItem(event.getPlayer().getLocation(), itemToRemove);
                    event.setCancelled(true);
                }
            }

        }
    }
}