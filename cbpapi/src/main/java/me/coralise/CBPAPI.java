package me.coralise;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import me.coralise.caches.Cache;
import me.coralise.objects.Ban;

/**
 * Hello world!
 *
 */
public class CBPAPI {
    
    private CustomBansPlus cbp;

    public CBPAPI() {
        cbp = (CustomBansPlus) Bukkit.getPluginManager().getPlugin("CustomBansPlus");
    }

    
    /** 
     * Gets the API for the CustomBansPlus Plugin.
     * <p>
     * Ensure that your plugin depends or softdepends on the CBP Plugin
     * in order for it to load before your plugin does.
     * @return CBPAPI if CustomBansPlus plugin is found, null if not.
     */
    public static CBPAPI getApi() {
        if (Bukkit.getPluginManager().getPlugin("CustomBansPlus") != null)
            return new CBPAPI();
        else return null;
    }

    
    /** 
     * Checks whether the player object is banned or not.
     * @param pl - The Player Object to look up.
     * @return True if player is banned, false if not.
     */
    public boolean isPlayerBanned(Player pl) {
        return cbp.dbm.isPlayerBanned(pl.getUniqueId());
    }

    
    /** 
     * Checks whether the UUID is banned or not.
     * @param uuid - The UUID to look up.
     * @return True if UUID is banned, false if not.
     */
    public boolean isUuidBanned(UUID uuid) {
        return cbp.dbm.isPlayerBanned(uuid);
    }

    
    /** 
     * @param pl
     * @return Ban
     */
    public Ban getBan(OfflinePlayer pl) {
        return Cache.getBannedObject(pl.getUniqueId());
    }

}
