/*
 * This file is part of Vanilla.
 *
 * Copyright (c) 2011-2012, VanillaDev <http://www.spout.org/>
 * Vanilla is licensed under the SpoutDev License Version 1.
 *
 * Vanilla is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * In addition, 180 days after any changes are published, you can use the
 * software, incorporating those changes, under the terms of the MIT license,
 * as described in the SpoutDev License Version 1.
 *
 * Vanilla is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License,
 * the MIT license and the SpoutDev License Version 1 along with this program.
 * If not, see <http://www.gnu.org/licenses/> for the GNU Lesser General Public
 * License and see <http://www.spout.org/SpoutDevLicenseV1.txt> for the full license,
 * including the MIT license.
 */
package org.spout.vanilla.inventory.block;

import org.spout.api.inventory.Inventory;
import org.spout.api.inventory.ItemStack;

import org.spout.vanilla.inventory.VanillaInventory;

/**
 * Represents the inventory of a {@link org.spout.vanilla.material.block.controlled.JukeboxBlock}.
 */
public class JukeboxInventory extends Inventory implements VanillaInventory {
	private static final long serialVersionUID = 1L;

	public JukeboxInventory() {
		super(1);
	}

	/**
	 * Gets the {@link org.spout.api.inventory.ItemStack} in the Jukebox's music slot
	 * @return item in slot
	 */
	public ItemStack getMusicSlot() {
		return getItem(0);
	}

	/**
	 * Sets the {@link org.spout.api.inventory.ItemStack} in the Jukebox's music slot
	 * @param item in slot
	 */
	public void setMusicSlot(ItemStack item) {
		setItem(0, item);
	}
}
