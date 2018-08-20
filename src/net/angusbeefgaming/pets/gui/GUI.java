package net.angusbeefgaming.pets.gui;

import org.bukkit.Bukkit;
import org.bukkit.EntityEffect;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.angusbeefgaming.pets.manager.PetManager;

public class GUI implements Listener {
	public static Inventory main() {
		
		Inventory inv = Bukkit.createInventory(null, 18, "Pets");
		
		ItemStack wolf = nameItem(Material.BONE, "Wolf Pet");
		ItemStack cow = nameItem(Material.LEATHER, "Cow Pet");
		ItemStack sheep = nameItem(Material.WOOL, "Sheep Pet");
		ItemStack llama = nameItem(Material.SADDLE, "Llama Pet");
		ItemStack polarbear = nameItem(Material.SNOW, "Polar Bear Pet");
		ItemStack parrot = nameItem(Material.FEATHER, "Parrot Pet");
		
		inv.setItem(0, wolf);
		inv.setItem(1, cow);
		inv.setItem(2, sheep);
		inv.setItem(3, llama);
		inv.setItem(4, polarbear);
		inv.setItem(5, parrot);
		
		return inv;
	}
	
	@EventHandler
	public void click(InventoryClickEvent e) {
		Inventory inv = e.getClickedInventory();
		Player player = (Player) e.getWhoClicked();
		
		if(inv == null) {
			return;
		}
		
		if(!inv.getTitle().equals("Pets")) return;
		
		ItemStack item;
		try {
			item = e.getCurrentItem();
		}
		catch(NullPointerException ex) {
			return;
		}
		
		if(item == null) return;
		
		if(item.getItemMeta().getDisplayName().equals("Wolf Pet")) {
			Bukkit.dispatchCommand(player, "pet Wolf");
			e.setCancelled(true);
			player.closeInventory();
			return;
		}
		if(item.getItemMeta().getDisplayName().equals("Cow Pet")) {
			Bukkit.dispatchCommand(player, "pet Cow");
			e.setCancelled(true);
			player.closeInventory();
			return;
		}
		if(item.getItemMeta().getDisplayName().equals("Sheep Pet")) {
			Bukkit.dispatchCommand(player, "pet Sheep");
			e.setCancelled(true);
			player.closeInventory();
			return;
		}
		if(item.getItemMeta().getDisplayName().equals("Llama Pet")) {
			Bukkit.dispatchCommand(player, "pet Llama");
			e.setCancelled(true);
			player.closeInventory();
			return;
		}
		if(item.getItemMeta().getDisplayName().equals("Polar Bear Pet")) {
			Bukkit.dispatchCommand(player, "pet PolarBear");
			e.setCancelled(true);
			player.closeInventory();
			return;
		}
		if(item.getItemMeta().getDisplayName().equals("Parrot Pet")) {
			Bukkit.dispatchCommand(player, "pet Parrot");
			e.setCancelled(true);
			player.closeInventory();
			return;
		}
		e.setCancelled(true);
		e.getWhoClicked().playEffect(EntityEffect.FIREWORK_EXPLODE);
		return;
	}
	
    private static ItemStack nameItem(ItemStack item, String name) {
    	ItemMeta meta = item.getItemMeta();
    	meta.setDisplayName(name);
    	item.setItemMeta(meta);
    	return item;
    }

    private static ItemStack nameItem(Material item, String name) {
    	return nameItem(new ItemStack(item), name);
    }
}
