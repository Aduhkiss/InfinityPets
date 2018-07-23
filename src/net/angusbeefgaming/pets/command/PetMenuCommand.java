package net.angusbeefgaming.pets.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.angusbeefgaming.pets.Config;
import net.angusbeefgaming.pets.gui.GUI;

public class PetMenuCommand implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		if(!(sender instanceof Player)) return false;
		Player player = (Player) sender;
		if(!player.hasPermission(Config.USE_COMMAND)) {
			player.sendMessage(Config.NO_PERM_COLOR + Config.NO_PERM_MESSAGE);
			return false;
		}
		
		player.openInventory(GUI.main());
		
		return true;
	}
}
