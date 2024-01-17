package myron.diamondblocktrail;

import myron.diamondblocktrail.commands.BlockCommand;
import myron.diamondblocktrail.listeners.PlayerJoin;
import org.bukkit.plugin.java.JavaPlugin;

public final class DiamondBlockTrail extends JavaPlugin {

    private  static DiamondBlockTrail instance;

    @Override
    public void onEnable() {
        System.out.println("Plugin has loaded");

        getServer().getPluginManager().registerEvents(new PlayerJoin(),this);
        getCommand("block").setExecutor(new BlockCommand());
        instance = this;



    }
    public static DiamondBlockTrail getInstance() {
        return instance;
    }
}
