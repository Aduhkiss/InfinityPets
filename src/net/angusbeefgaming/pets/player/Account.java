package net.angusbeefgaming.pets.player;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;

import net.angusbeefgaming.pets.PetCore;

public class Account {
	
	Player player;
	
	Entity pet;
	
	String petName;
	
	public Account(Player pla) {
		player = pla;
	}
	
	public void despawn() {
		pet.remove();
	}
	
	public void setPet(Entity pet, String name) {
		this.pet = pet;
		petName = name;
	}
	
	public Entity getPet() {
		return pet;
	}
	
	public String getPetName() {
		return petName;
	}
	
	public void setPetName(String petsName) {
		petName = petsName;
		pet.setCustomName(petsName);
	}
}
