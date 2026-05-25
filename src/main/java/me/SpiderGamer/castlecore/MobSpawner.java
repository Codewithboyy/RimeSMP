package me.yourname.castlecore;

import io.lumine.mythic.bukkit.MythicBukkit;
import io.lumine.mythic.core.mobs.ActiveMob;
import org.bukkit.Location;
import org.bukkit.entity.Entity;

public class MobSpawner {

    private final CastleCore plugin;

    public MobSpawner(CastleCore plugin) {
        this.plugin = plugin;
    }

    public void spawnCastleMobs(Location loc) {
        spawnMythicMob("CastleKnight", loc.clone().add(0, 0, 0), "§cCastle Knight");
        spawnMythicMob("CastleArcher", loc.clone().add(3, 0, 0), "§aCastle Archer");
        spawnMythicMob("CastleBoss", loc.clone().add(-3, 0, 0), "§4Castle Boss");
    }

    private void spawnMythicMob(String mythicMobId, Location location, String customName) {
        ActiveMob mob = MythicBukkit.inst().getMobManager().spawnMob(mythicMobId, location);

        if (mob == null) {
            plugin.getLogger().warning("MythicMob not found: " + mythicMobId);
            return;
        }

        Entity entity = mob.getEntity().getBukkitEntity();
        entity.setCustomName(customName);
        entity.setCustomNameVisible(true);
    }
}