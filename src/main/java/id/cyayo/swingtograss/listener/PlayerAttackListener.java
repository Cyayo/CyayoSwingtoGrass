package id.cyayo.swingtograss.listener;

import id.cyayo.swingtograss.CyayoSwingtoGrass;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.RayTraceResult;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PlayerAttackListener implements Listener {

    private final CyayoSwingtoGrass plugin;
    private final Set<Material> allowedMaterials = new HashSet<>();

    public PlayerAttackListener(CyayoSwingtoGrass plugin) {
        this.plugin = plugin;
        loadConfig();
    }

    public void loadConfig() {
        allowedMaterials.clear();
        List<String> materials = plugin.getConfig().getStringList("swing-through-blocks");
        for (String matName : materials) {
            try {
                Material mat = Material.valueOf(matName.toUpperCase());
                allowedMaterials.add(mat);
            } catch (IllegalArgumentException ignored) {
                plugin.getLogger().warning("Invalid material in config: " + matName);
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getAction() != Action.LEFT_CLICK_BLOCK) {
            return;
        }

        Block block = event.getClickedBlock();
        if (block == null) {
            return;
        }

        // Cek apakah block ada di daftar config atau secara fisik memang 'passable'
        if (!allowedMaterials.contains(block.getType()) && !block.isPassable()) {
            return;
        }

        Player player = event.getPlayer();

        // Jarak jangkauan RayTrace
        double reach = 5.0; 
        RayTraceResult rayTrace = player.getWorld().rayTraceEntities(
                player.getEyeLocation(),
                player.getEyeLocation().getDirection(),
                reach,
                entity -> !entity.equals(player)
        );

        if (rayTrace != null && rayTrace.getHitEntity() != null) {
            Entity target = rayTrace.getHitEntity();
            
            // Serang target
            player.attack(target);
            
            // Batalkan event agar block tidak hancur
            event.setCancelled(true);
        }
    }
}
