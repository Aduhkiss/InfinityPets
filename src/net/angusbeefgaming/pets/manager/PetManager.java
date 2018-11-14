package net.angusbeefgaming.pets.manager;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftEntity;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Llama;
import org.bukkit.entity.Parrot;
import org.bukkit.entity.Player;
import org.bukkit.entity.PolarBear;
import org.bukkit.entity.Sheep;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Wolf;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.scheduler.BukkitRunnable;

import net.angusbeefgaming.pets.PetCore;
import net.angusbeefgaming.pets.pets.Pets;
import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_12_R1.EntityInsentient;
import net.minecraft.server.v1_12_R1.PathEntity;

public class PetManager {
	
	public static Map<Player, Boolean> spawnedPets = new HashMap<Player, Boolean>();
	
	private static boolean petsEnabled = true;
	
	public static void enablePet(Player pl, Pets pet) {
		if(spawnedPets.get(pl) == null) {
			spawnedPets.put(pl, false);
		}
		if(pet == Pets.WOLF) {
	        Wolf petObj = pl.getWorld().spawn(pl.getLocation().add(0,1,0), Wolf.class);
	        petObj.setCustomNameVisible(true);
	        petObj.setCustomName(pl.getDisplayName() + "'s Wolf Pet");
	        spawnedPets.put(pl, true);
	        follow(pl, petObj);
	        petObj.setMetadata("InfinityPets", new FixedMetadataValue(PetCore.getInstance(), "LOLIAMAPET"));
	        PetCore.accounts.get(pl).setPet(petObj, pl.getDisplayName() + "'s Wolf Pet");
	        return;
		}
		if(pet == Pets.COW) {
	        Cow petObj = pl.getWorld().spawn(pl.getLocation().add(0,1,0), Cow.class);
	        petObj.setCustomNameVisible(true);
	        petObj.setCustomName(pl.getDisplayName() + "'s Cow Pet");
	        spawnedPets.put(pl, true);
	        follow(pl, petObj);
	        petObj.setMetadata("InfinityPets", new FixedMetadataValue(PetCore.getInstance(), "LOLIAMAPET"));
	        PetCore.accounts.get(pl).setPet(petObj, pl.getDisplayName() + "'s Cow Pet");
	        return;
		}
		if(pet == Pets.SHEEP) {
	        Sheep petObj = pl.getWorld().spawn(pl.getLocation().add(0,1,0), Sheep.class);
	        petObj.setCustomNameVisible(true);
	        petObj.setCustomName(pl.getDisplayName() + "'s Sheep Pet");
	        spawnedPets.put(pl, true);
	        follow(pl, petObj);
	        petObj.setMetadata("InfinityPets", new FixedMetadataValue(PetCore.getInstance(), "LOLIAMAPET"));
	        PetCore.accounts.get(pl).setPet(petObj, pl.getDisplayName() + "'s Sheep Pet");
	        return;
		}
		if(pet == Pets.LLAMA) {
	        Llama petObj = pl.getWorld().spawn(pl.getLocation().add(0,1,0), Llama.class);
	        petObj.setCustomNameVisible(true);
	        if(pl.getDisplayName().equals("JackSucksAtMC")) {
	        	petObj.setCustomName("Larry");
	        	PetCore.accounts.get(pl).setPet(petObj, "Larry");
	        }
	        else {
	        	petObj.setCustomName(pl.getDisplayName() + "'s Llama Pet");
	        	PetCore.accounts.get(pl).setPet(petObj, pl.getDisplayName() + "'s Llama Pet");
	        }
	        spawnedPets.put(pl, true);
	        
	        petObj.setMetadata("InfinityPets", new FixedMetadataValue(PetCore.getInstance(), "LOLIAMAPET"));
	        follow(pl, petObj);
	        return;
		}
		if(pet == Pets.POLAR_BEAR) {
	        PolarBear petObj = pl.getWorld().spawn(pl.getLocation().add(0,1,0), PolarBear.class);
	        petObj.setCustomNameVisible(true);
	        if(pl.getDisplayName().equals("JackSucksAtMC")) {
	        	petObj.setCustomName("Cleopatra");
	        	PetCore.accounts.get(pl).setPet(petObj, "Cleopatra");
	        }
	        else {
	        	petObj.setCustomName(pl.getDisplayName() + "'s Polar Bear Pet");
	        	PetCore.accounts.get(pl).setPet(petObj, pl.getDisplayName() + "'s Polar Bear Pet");
	        }
	        spawnedPets.put(pl, true);
	        petObj.setMetadata("InfinityPets", new FixedMetadataValue(PetCore.getInstance(), "LOLIAMAPET"));
	        follow(pl, petObj);
	        return;
		}
		if(pet == Pets.PARROT) {
	        Parrot petObj = pl.getWorld().spawn(pl.getLocation().add(0,1,0), Parrot.class);
	        petObj.setCustomNameVisible(true);
	        petObj.setCustomName(pl.getDisplayName() + "'s Parrot Pet");
	        spawnedPets.put(pl, true);
	        follow(pl, petObj);
	        petObj.setMetadata("InfinityPets", new FixedMetadataValue(PetCore.getInstance(), "LOLIAMAPET"));
	        PetCore.accounts.get(pl).setPet(petObj, pl.getDisplayName() + "'s Parrot Pet");
	        return;
		}
		if(pet == Pets.VILLAGER) {
	        Villager petObj = pl.getWorld().spawn(pl.getLocation().add(0,1,0), Villager.class);
	        petObj.setCustomNameVisible(true);
	        petObj.setCustomName(pl.getDisplayName() + "'s Villager Pet");
	        spawnedPets.put(pl, true);
	        follow(pl, petObj);
	        petObj.setMetadata("InfinityPets", new FixedMetadataValue(PetCore.getInstance(), "LOLIAMAPET"));
	        PetCore.accounts.get(pl).setPet(petObj, pl.getDisplayName() + "'s Villager Pet");
	        return;
		}
	}
	
	public static void removePet(Player player, Entity pet) {
		pet.remove();
		spawnedPets.put(player, false);
	}
	
	public static void namePet(Player player, String name) {
		PetCore.accounts.get(player).setPetName(name);
	}
	
	public static void enablePets(Player pl) {
		for(Player play : Bukkit.getOnlinePlayers()) {
			play.sendMessage(ChatColor.GREEN + "Pets have been Enabled by " + pl.getDisplayName());
		}
		petsEnabled = true;
	}
	
	public static void disablePets(Player pl) {
		for(Player play : Bukkit.getOnlinePlayers()) {
			play.sendMessage(ChatColor.GREEN + "Pets have been Disabled by " + pl.getDisplayName());
		}
		petsEnabled = false;
	}
	
	public static boolean petsEnabled() {
		return petsEnabled;
	}
	
    public static void follow(final Player player, final Entity pet) {
    	
    	/**
    	 * Amazing 10/10 Algorithim to
    	 * make sure pets follow you.
    	 */
    new BukkitRunnable() {
       
        public void run() {
            if(!pet.isValid()) {
                this.cancel();
                return;
            }
           
            if(!player.isOnline()) {
                this.cancel();
                pet.remove();
                return;
            }
            
            if(!petsEnabled) {
            	this.cancel();
            	pet.remove();
            	return;
            }
           
            Object petObject = ((CraftEntity) pet).getHandle();
           
            Location loc = player.getLocation();
           
            PathEntity path;
           
             
                path = ((EntityInsentient)petObject).getNavigation().a(loc.getX() + 1, loc.getY(), loc.getZ() +1);
               
                int distance = 0;
                try {
                	distance = (int) loc.distance(pet.getLocation());
                }
                catch(IllegalArgumentException e) {
                	pet.remove();
                	removePet(player, PetCore.accounts.get(player).getPet());
                	player.sendMessage(ChatColor.GREEN + "Your pet was removed since you switched worlds!");
                	return;
                }
                
                if(path != null && distance > 5) {
                    ((EntityInsentient)petObject).getNavigation().a(path, 1.0D);
                    ((EntityInsentient)petObject).getNavigation().a(2.0D);
                }
               
               
                if(distance > 20 && ! pet.isDead() && player.isOnGround()) {
                    pet.teleport(loc);
                }
           
        }
       
    }.runTaskTimer(PetCore.getInstance(), 0L, 20L);
    }
    
    public static boolean hasPetSpawned(Player pla) {
    	if(spawnedPets.get(pla) == null) return false;
    	if(spawnedPets.get(pla) == false) return false;
    	return true;
    }
}
