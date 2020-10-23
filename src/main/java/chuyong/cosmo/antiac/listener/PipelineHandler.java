package chuyong.cosmo.antiac.listener;

import chuyong.cosmo.antiac.cache.CacheTank;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.server.v1_12_R1.PacketPlayInArmAnimation;
import org.bukkit.entity.Player;

public class PipelineHandler extends ChannelDuplexHandler {
    private Player p;
    public PipelineHandler(Player p){
        this.p = p;
    }
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if(msg instanceof PacketPlayInArmAnimation){
            CacheTank.getCache(p).increase();
        }
        super.channelRead(ctx, msg);
    }
}
