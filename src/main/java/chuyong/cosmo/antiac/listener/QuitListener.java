package chuyong.cosmo.antiac.listener;

import chuyong.cosmo.antiac.cache.CacheTank;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitListener implements Listener {
    @EventHandler
    public void onJoin(PlayerQuitEvent event){
        CacheTank.removePlayer(event.getPlayer());
    }
}
