package chuyong.cosmo.antiac.task;

import chuyong.cosmo.antiac.cache.CacheTank;
import chuyong.cosmo.antiac.cache.PlayerPacketCache;

public class RunnableTask implements Runnable{
    @Override
    public void run() {
        for(PlayerPacketCache cs : CacheTank.getCaches()){
            cs.verify();
        }
    }
}
