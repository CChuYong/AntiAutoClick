package chuyong.cosmo.antiac;

import chuyong.cosmo.antiac.enums.ProcessType;
import chuyong.cosmo.antiac.listener.JoinListener;
import chuyong.cosmo.antiac.listener.QuitListener;
import chuyong.cosmo.antiac.task.Scheduler;
import org.bukkit.plugin.java.JavaPlugin;

public class AntiAC extends JavaPlugin {
    private Scheduler scheduler;
    public static AntiAC INSTANCE;
    public void onEnable(){
        INSTANCE = this;
        System.out.println("[AntiAutoClick] AntiAutoClick가 실행됩니다.");

        getConfig().addDefault("MaxPacketPerSeconds", 30);
        getConfig().addDefault("ProcessType", "KICK");
        getConfig().addDefault("ProcessMessage", "과도한 패킷 시도로 서버에서 추방되었습니다.");
        getConfig().options().copyDefaults(true);
        saveConfig();

        AntiACAPI.setMaxPacket(getConfig().getInt("MaxPacketPerSeconds"));
        AntiACAPI.setProcessType(ProcessType.valueOf(getConfig().getString("ProcessType")));
        AntiACAPI.setMessage(getConfig().getString("ProcessMessage"));

        getServer().getPluginManager().registerEvents(new JoinListener(), this);
        getServer().getPluginManager().registerEvents(new QuitListener(), this);
        this.scheduler = new Scheduler();
        getServer().getScheduler().runTaskLater(this, ()->{
            scheduler.init();
        }, 1L);
    }
    public void onDisable(){
        System.out.println("[AntiAutoClick] AntiAutoClick가 비활성화됩니다.");
        scheduler.onDisable();
    }
}
