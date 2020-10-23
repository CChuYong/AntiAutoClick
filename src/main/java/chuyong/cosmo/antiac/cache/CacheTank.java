package chuyong.cosmo.antiac.cache;

import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

public class CacheTank {
    private static HashMap<UUID, PlayerPacketCache> cacheTank;
    public static PlayerPacketCache getCache(Player p){
        return cacheTank.get(p.getUniqueId());
    }
    public static Collection<PlayerPacketCache> getCaches(){
        return cacheTank.values();
    }
    public static void putPlayer(Player p){
        cacheTank.put(p.getUniqueId(), new PlayerPacketCache(p));
    }
    public static void removePlayer(Player p){
        if(cacheTank.containsKey(p.getUniqueId()))
         cacheTank.remove(p.getUniqueId());
    }
    static{
        cacheTank = new HashMap<UUID, PlayerPacketCache>();
    }
}
