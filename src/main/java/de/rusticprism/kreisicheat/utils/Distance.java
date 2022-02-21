package de.rusticprism.kreisicheat.utils;

import org.bukkit.Location;
import org.bukkit.event.player.PlayerMoveEvent;

public class Distance {
    private Location from, to;

    private Double xDiff, yDiff, zDiff;

    public Distance(PlayerMoveEvent e) {
        this.from = e.getFrom();
        this.to = e.getTo();
        this.xDiff = Math.abs(to.getX() - from.getX());
        this.yDiff = Math.abs(to.getY() - from.getY());
        this.zDiff = Math.abs(to.getZ() - from.getZ());
    }

    public Location getFrom() {
        return from;
    }

    public Location getTo() {
        return to;
    }

    public Double getxDiff() {
        return xDiff;
    }

    public Double getyDiff() {
        return yDiff;
    }

    public Double getzDiff() {
        return zDiff;
    }
}
