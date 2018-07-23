package net.angusbeefgaming.pets.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.angusbeefgaming.pets.Config;
import net.angusbeefgaming.pets.PetCore;
import net.angusbeefgaming.pets.manager.PetManager;
import net.md_5.bungee.api.ChatColor;

public class RemovePetCommand implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		if(!(sender instanceof Player)) return false;
		Player player = (Player) sender;
		if(!player.hasPermission(Config.USE_COMMAND)) {
			player.sendMessage(Config.NO_PERM_COLOR + Config.NO_PERM_MESSAGE);
			return false;
		}
		
		if(!PetManager.hasPetSpawned(player)) {
			player.sendMessage(ChatColor.RED + "You do not have a pet spawned!");
			return false;
		}
		
		PetManager.removePet(player, PetCore.accounts.get(player).getPet());
		player.sendMessage(ChatColor.RED + "You have disabled your current pet!");
		return true;
	}
}
