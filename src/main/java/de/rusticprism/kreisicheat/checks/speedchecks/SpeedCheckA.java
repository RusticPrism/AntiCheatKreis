package de.rusticprism.kreisicheat.checks.speedchecks;

import de.rusticprism.kreisicheat.checks.CheckResult;
import de.rusticprism.kreisicheat.checks.Level;
import de.rusticprism.kreisicheat.utils.CheckType;
import de.rusticprism.kreisicheat.utils.Distance;
import de.rusticprism.kreisicheat.utils.Settings;
import de.rusticprism.kreisicheat.utils.User;
import org.bukkit.potion.PotionEffectType;


public class SpeedCheckA {
    public static CheckResult runcheck(Distance d, User user) {
        Double xzspeed = d.getxDiff() > d.getzDiff() ? d.getxDiff() : d.getzDiff();
        if(user.getPlayer().hasPotionEffect(PotionEffectType.DOLPHINS_GRACE) || user.getPlayer().hasPotionEffect(PotionEffectType.SPEED)){
            if(xzspeed > Settings.MAX_ZX_SPEED + 0.099) {
                user.getPlayer().sendMessage(String.valueOf(xzspeed));
                return new CheckResult(Level.DEFINITELY, "§c tried to move faster than normal!", CheckType.SPEEDA);
            }
        }else if(xzspeed > Settings.MAX_ZX_SPEED) {
            return new CheckResult(Level.DEFINITELY, "§c tried to move faster than normal!", CheckType.SPEEDA);
        }
        return  new CheckResult(Level.PASSED, null,CheckType.SPEEDA);
    }

}