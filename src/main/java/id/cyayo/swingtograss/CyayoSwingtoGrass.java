package id.cyayo.swingtograss;

import id.cyayo.swingtograss.listener.PlayerAttackListener;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class CyayoSwingtoGrass extends JavaPlugin implements CommandExecutor {

    private PlayerAttackListener listener;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        
        listener = new PlayerAttackListener(this);
        getServer().getPluginManager().registerEvents(listener, this);
        
        getCommand("cyayoswing").setExecutor(this);
        
        getLogger().info("CyayoSwingtoGrass has been enabled!");
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length > 0 && args[0].equalsIgnoreCase("reload")) {
            if (!sender.hasPermission("cyayoswing.admin")) {
                sender.sendMessage("§cYou don't have permission to do this!");
                return true;
            }
            reloadConfig();
            listener.loadConfig();
            sender.sendMessage("§aCyayoSwingtoGrass configuration reloaded!");
            return true;
        }
        sender.sendMessage("§eCyayoSwingtoGrass v1.0 by Cyayo");
        sender.sendMessage("§7Use /cyayoswing reload to reload config.");
        return true;
    }

    @Override
    public void onDisable() {
        getLogger().info("CyayoSwingtoGrass has been disabled!");
    }
}
