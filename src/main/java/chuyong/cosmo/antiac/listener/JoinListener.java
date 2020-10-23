package chuyong.cosmo.antiac.listener;

import chuyong.cosmo.antiac.cache.CacheTank;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelPipeline;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        ChannelDuplexHandler cr = new PipelineHandler(event.getPlayer());
        ChannelPipeline pipe = ((CraftPlayer)event.getPlayer()).getHandle().playerConnection.networkManager.channel.pipeline();
        pipe.addBefore("packet_handler", event.getPlayer().getName()+".AtAC", cr);
        CacheTank.putPlayer(event.getPlayer());
    }
}
