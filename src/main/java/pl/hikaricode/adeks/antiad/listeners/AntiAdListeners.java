package pl.hikaricode.adeks.antiad.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.inventory.AnvilInventory;
import pl.hikaricode.adeks.antiad.basic.AntiAd;
import pl.hikaricode.adeks.antiad.checker.Checker;

public class AntiAdListeners implements Listener {
    // ten kod dalo by sie skrocic ale jestem leniem, pa
    @EventHandler
    public void onChat(AsyncPlayerChatEvent e){
        if(e.getPlayer().hasPermission("hikari.ad")) return;

        for(Checker c:Checker.getCheckers()){
            if(!c.getTypes().contains("chat")) continue;
            if(c.isAd(e.getMessage())) {
                e.setCancelled(true);
                e.getPlayer().sendMessage(AntiAd.getMessages().getNoAdMessage());
                Bukkit.getOnlinePlayers()
                        .stream()
                        .filter(player ->  player.hasPermission("hikari.seead"))
                        .forEach(player ->  player.sendMessage(AntiAd.getMessages().getAdminSeeMessage()
                                .replaceAll("%message%", e.getMessage())
                                .replaceAll("%player%", e.getPlayer().getName())
                        ));
                return;
            }
        }
    }
    @EventHandler
    public void onAnvilRename(InventoryClickEvent e){
        if(e.getWhoClicked().hasPermission("hikari.ad")) return;

        if(!(e.getInventory() instanceof AnvilInventory)) {
            return;
        }
        for(Checker c:Checker.getCheckers()){
            if(!c.getTypes().contains("anvil")) continue;

            if(e.getCurrentItem()!=null && e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().hasDisplayName() && c.isAd(e.getCurrentItem().getItemMeta().getDisplayName())){
                e.setCancelled(true);
                e.getWhoClicked().sendMessage(AntiAd.getMessages().getNoAdMessage());
                Bukkit.getOnlinePlayers()
                        .stream()
                        .filter(player ->  player.hasPermission("hikari.seead"))
                        .forEach(player ->  player.sendMessage(AntiAd.getMessages().getAdminSeeMessage()
                                .replaceAll("%message%", e.getCurrentItem().getItemMeta().getDisplayName())
                                .replaceAll("%player%", e.getWhoClicked().getName())
                        ));
                return;
            }
        }
    }
    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent e){
        if(e.getPlayer().hasPermission("hikari.ad")) return;

        for(Checker c:Checker.getCheckers()){
            if(!c.getTypes().contains("command")) continue;
            if(c.isAd(e.getMessage())){
                e.setCancelled(true);
                e.getPlayer().sendMessage(AntiAd.getMessages().getNoAdMessage());
                Bukkit.getOnlinePlayers()
                        .stream()
                        .filter(player ->  player.hasPermission("hikari.seead"))
                        .forEach(player ->  player.sendMessage(AntiAd.getMessages().getAdminSeeMessage()
                                .replaceAll("%message%", e.getMessage())
                                .replaceAll("%player%", e.getPlayer().getName())
                        ));
                return;
            }
        }
    }




}
