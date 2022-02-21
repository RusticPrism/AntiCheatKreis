package de.rusticprism.kreisicheat.checks;
import de.rusticprism.kreisicheat.KreisiCheat;
import de.rusticprism.kreisicheat.checks.speedchecks.SpeedCheckA;
import de.rusticprism.kreisicheat.utils.Distance;
import de.rusticprism.kreisicheat.utils.User;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class MovementChecks implements Listener {
   @EventHandler
   public void onMove(PlayerMoveEvent e) {
      User u = KreisiCheat.USERS.get(e.getPlayer().getUniqueId());
      Distance d = new Distance(e);
      CheckResult speed = SpeedCheckA.runcheck(d,u);
      if(speed.failed()) {
         e.setTo(e.getFrom());
         KreisiCheat.log(speed, u);
      }
   }

}
