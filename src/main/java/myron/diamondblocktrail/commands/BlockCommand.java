package myron.diamondblocktrail.commands;

import myron.diamondblocktrail.DiamondBlockTrail;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

public class BlockCommand implements CommandExecutor {

    private boolean enabledCommand = false;
    private  BukkitRunnable blockSetTask;

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if (commandSender instanceof Player) {
            Player p = (Player) commandSender;
            if (enabledCommand == false) {
                World world = p.getWorld();
                enabledCommand = true;
                p.sendMessage(ChatColor.GREEN + "Block has been enabled");
                blockSetTask = new BukkitRunnable() {
                    @Override
                    public void run() {
                        Block block = world.getBlockAt(p.getLocation().add(0, -1, 0));
                        block.setType(Material.DIAMOND_BLOCK);
                    }
                };
                blockSetTask.runTaskTimer(DiamondBlockTrail.getInstance(),0L,1L);

            } else if (enabledCommand == true){
                p.sendMessage(ChatColor.RED + "Block has been disabled");
                enabledCommand = false;
                blockSetTask.cancel();
            }
            return true;
        }
        return  false;
    }
}
