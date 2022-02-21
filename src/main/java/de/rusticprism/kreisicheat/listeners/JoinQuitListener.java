package de.rusticprism.kreisicheat.listeners;
import de.rusticprism.kreisicheat.KreisiCheat;
import de.rusticprism.kreisicheat.utils.User;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinQuitListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        KreisiCheat.USERS.put(p.getUniqueId(),new User(p));
    }
    @EventHandler
    public void onquit(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        KreisiCheat.USERS.remove(p.getUniqueId());
    }
}
