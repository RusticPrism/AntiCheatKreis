package de.rusticprism.kreisicheat;

import de.rusticprism.kreisicheat.checks.CheckResult;
import de.rusticprism.kreisicheat.checks.MovementChecks;
import de.rusticprism.kreisicheat.listeners.JoinQuitListener;
import de.rusticprism.kreisicheat.utils.Settings;
import de.rusticprism.kreisicheat.utils.User;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public final class KreisiCheat extends JavaPlugin {
    public static String prefix = "§6[§5§lAnticheatKreis§r§6] §7>> ";
    public static String noperms = prefix + "§4No Permission";
    public static String nocons = prefix + "§4Only Players";
    public static HashMap<UUID, User> USERS = new HashMap<>();
    @Override
    public void onEnable() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new JoinQuitListener(), this);
        pm.registerEvents(new MovementChecks(),this);
        for (Player p : Bukkit.getOnlinePlayers()) {
            USERS.put(p.getUniqueId(), new User(p));
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static void log(CheckResult cr, User u) {
        for(Player p : Bukkit.getOnlinePlayers()){
            String message = prefix +"§5" + u.getPlayer().getName() + "§7 " +cr.getLevel().toString().toLowerCase()+ Settings.FAILED + cr.getType().getName() + ":§c" + cr.getMessage();
            if(p.hasPermission(Settings.NOTIFY))
                    p.sendMessage(message);
            Bukkit.getConsoleSender().sendMessage(message);
        }
    }
}
