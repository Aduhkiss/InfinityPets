package net.angusbeefgaming.pets;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import net.angusbeefgaming.pets.command.NamePetCommand;
import net.angusbeefgaming.pets.command.PetCommand;
import net.angusbeefgaming.pets.command.PetMenuCommand;
import net.angusbeefgaming.pets.command.RemovePetCommand;
import net.angusbeefgaming.pets.gui.GUI;
import net.angusbeefgaming.pets.listener.DamageHandler;
import net.angusbeefgaming.pets.player.Account;

public class PetCore extends JavaPlugin implements Listener {
	
	static PetCore instance;
	
	public static Map<Player, Account> accounts = new HashMap<Player, Account>();
	
	/**
	 * Infinity Pets
	 * 
	 * Written by Atticus Zambrana
	 */
	
	@Override
	public void onEnable() {
		instance = this;
		getCommand("pet").setExecutor(new PetCommand());
		getCommand("removepet").setExecutor(new RemovePetCommand());
		getCommand("namepet").setExecutor(new NamePetCommand());
		getCommand("pets").setExecutor(new PetMenuCommand());
		
		getServer().getPluginManager().registerEvents(this, this);
		getServer().getPluginManager().registerEvents(new GUI(), this);
		getServer().getPluginManager().registerEvents(new DamageHandler(), this);
	}
	
	@Override
	public void onDisable() {
		// when the plugin is disabled, despawn all pets
		for (Map.Entry<Player, Account> entry : accounts.entrySet()) {
			entry.getValue().despawn();
		}
	}
	
	public static PetCore getInstance() {
		return instance;
	}
	
	@EventHandler
	public void join(PlayerJoinEvent e) {
		if(accounts.get(e.getPlayer()) == null) {
			accounts.put(e.getPlayer(), new Account(e.getPlayer()));
		}
	}

 
}
