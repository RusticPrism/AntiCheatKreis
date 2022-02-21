package de.rusticprism.kreisicheat.utils;

import org.bukkit.Bukkit;
import org.bukkit.permissions.Permission;

public enum CheckType {
    SPEEDA("§eSpeed§6(§aA§6)", new Permission("anticheatkreis.bypass.speed"));

    private String name;
    private Permission perm;

    CheckType(String name, Permission perm){
        this.name = name;
        this.perm = perm;
        Bukkit.getPluginManager().addPermission(perm);
    }

    public Permission getPerm() {
        return perm;
    }

    public String getName() {
        return name;
    }
}
