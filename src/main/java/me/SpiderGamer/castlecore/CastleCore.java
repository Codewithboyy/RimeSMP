package me.yourname.castlecore;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class CastleCore extends JavaPlugin {

    private MobSpawner mobSpawner;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        mobSpawner = new MobSpawner(this);
        getLogger().info("CastleCore enabled!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("Only players can use this command.");
            return true;
        }

        if (command.getName().equalsIgnoreCase("castle")) {
            Location loc = player.getLocation();
            mobSpawner.spawnCastleMobs(loc);
            player.sendMessage("§aCastle mobs spawned!");
            return true;
        }

        return false;
    }
}