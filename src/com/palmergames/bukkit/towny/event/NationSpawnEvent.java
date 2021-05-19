package com.palmergames.bukkit.towny.event;

import com.palmergames.bukkit.towny.object.Nation;
import com.palmergames.bukkit.towny.object.TownBlock;
import com.palmergames.bukkit.towny.object.WorldCoord;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

/**
 * An event called when nation spawns occur.
 * 
 * @author Suneet Tipirneni (Siris)
 */
public class NationSpawnEvent extends SpawnEvent {
	
	private Nation toNation;
	private Nation fromNation;

	/**
	 * Called when a player is teleported to a nation.
	 * 
	 * @param player The player being teleported.
	 * @param from The location the player is teleporting from.
	 * @param to The location the player is going to.
	 */
	public NationSpawnEvent(Player player, Location from, Location to) {
		super(player, from, to);
		
		TownBlock fromTownBlock = WorldCoord.parseWorldCoord(from).getTownBlockOrNull();
		TownBlock toTownBlock = WorldCoord.parseWorldCoord(to).getTownBlockOrNull();
		
		if (fromTownBlock != null)
			fromNation = fromTownBlock.getTownOrNull().getNationOrNull();
		if (toTownBlock != null)
			toNation = WorldCoord.parseWorldCoord(to).getTownBlockOrNull().getTownOrNull().getNationOrNull();
	}

	/**
	 * Gets the nation that the player to spawning to.
	 *
	 * @return The nation being spawned to.
	 */
	public Nation getToNation() {
		return toNation;
	}

	/**
	 * Gets the nation the player is spawning from.
	 * 
	 * @return null if the player is not standing in a nation owned townblock, the nation otherwise.
	 */
	@Nullable
	public Nation getFromNation() {
		return fromNation;
	}
}
