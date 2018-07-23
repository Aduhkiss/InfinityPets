package net.angusbeefgaming.pets.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.angusbeefgaming.pets.Config;
import net.angusbeefgaming.pets.gui.GUI;
import net.angusbeefgaming.pets.manager.PetManager;
import net.angusbeefgaming.pets.pets.Pets;
import net.md_5.bungee.api.ChatColor;

public class PetCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		if(!(sender instanceof Player)) return false;
		Player player = (Player) sender;
		if(!player.hasPermission(Config.USE_COMMAND)) {
			player.sendMessage(Config.NO_PERM_COLOR + Config.NO_PERM_MESSAGE);
			return false;
		}
		if(args.length < 1) {
			player.openInventory(GUI.main());
			return true;
		}
		if(args[0].equalsIgnoreCase("wolf")) {
			if(!player.hasPermission(Config.PET_WOLF)) {
				player.sendMessage(ChatColor.RED + Config.PET_NOT_BOUGHT);
				return false;
			}
			if(PetManager.hasPetSpawned(player)) {
				player.sendMessage(ChatColor.RED + "You already have a Pet Spawned!");
				return false;
			}
			PetManager.enablePet(player, Pets.WOLF);
			player.sendMessage(ChatColor.GREEN + "You have enabled Wolf Pet!");
			return true;
		}
		if(args[0].equalsIgnoreCase("cow")) {
			if(!player.hasPermission(Config.PET_COW)) {
				player.sendMessage(ChatColor.RED + Config.PET_NOT_BOUGHT);
				return false;
			}
			if(PetManager.hasPetSpawned(player)) {
				player.sendMessage(ChatColor.RED + "You already have a Pet Spawned!");
				return false;
			}
			PetManager.enablePet(player, Pets.COW);
			player.sendMessage(ChatColor.GREEN + "You have enabled Cow Pet!");
			return true;
		}
		
		if(args[0].equalsIgnoreCase("sheep")) {
			if(!player.hasPermission(Config.PET_SHEEP)) {
				player.sendMessage(ChatColor.RED + Config.PET_NOT_BOUGHT);
				return false;
			}
			if(PetManager.hasPetSpawned(player)) {
				player.sendMessage(ChatColor.RED + "You already have a Pet Spawned!");
				return false;
			}
			PetManager.enablePet(player, Pets.SHEEP);
			player.sendMessage(ChatColor.GREEN + "You have enabled Sheep Pet!");
			return true;
		}
		if(args[0].equalsIgnoreCase("polarbear")) {
			if(!player.hasPermission(Config.PET_POLAR_BEAR)) {
				player.sendMessage(ChatColor.RED + Config.PET_NOT_BOUGHT);
				return false;
			}
			if(PetManager.hasPetSpawned(player)) {
				player.sendMessage(ChatColor.RED + "You already have a Pet Spawned!");
				return false;
			}
			PetManager.enablePet(player, Pets.POLAR_BEAR);
			player.sendMessage(ChatColor.GREEN + "You have enabled Polar Bear Pet!");
			return true;
		}
		if(args[0].equalsIgnoreCase("llama")) {
			if(!player.hasPermission(Config.PET_LLAMA)) {
				player.sendMessage(ChatColor.RED + Config.PET_NOT_BOUGHT);
				return false;
			}
			if(PetManager.hasPetSpawned(player)) {
				player.sendMessage(ChatColor.RED + "You already have a Pet Spawned!");
				return false;
			}
			PetManager.enablePet(player, Pets.LLAMA);
			player.sendMessage(ChatColor.GREEN + "You have enabled Llama Pet!");
			return true;
		}
		
		else {
			player.sendMessage(ChatColor.RED + Config.PET_NOT_FOUND);
			return false;
		}
	}

}
