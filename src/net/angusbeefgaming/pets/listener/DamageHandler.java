package net.angusbeefgaming.pets.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class DamageHandler implements Listener {
	
	@EventHandler
	public void damage(EntityDamageEvent e) {
		if(e.getEntity().hasMetadata("InfinityPets")) {
			e.setCancelled(true);
			return;
		}
	}

}
