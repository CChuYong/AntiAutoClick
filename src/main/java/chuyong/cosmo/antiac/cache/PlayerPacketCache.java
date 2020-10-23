package chuyong.cosmo.antiac.cache;

import chuyong.cosmo.antiac.AntiAC;
import chuyong.cosmo.antiac.AntiACAPI;
import chuyong.cosmo.antiac.enums.ProcessType;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class PlayerPacketCache {
    Player player;
    int counter;
    public PlayerPacketCache(Player p){
        this.player = p;
        this.counter = 0;
    }
    public void increase(){
        counter++;
    }
    public void verify(){
        if(counter > AntiACAPI.getMaxPackets()){
            process();
        }
        counter = 0;
    }
    private void process(){
        Bukkit.getScheduler().runTask(AntiAC.INSTANCE, ()->{
            if(AntiACAPI.getProcessType() == ProcessType.BAN){
                Bukkit.getBanList(BanList.Type.NAME).addBan(player.getName(), AntiACAPI.getMessage(), null, "AntiAutoClick");
                player.kickPlayer(AntiACAPI.getMessage());
                return;
            }
            player.kickPlayer(AntiACAPI.getMessage());
        });
    }
}
