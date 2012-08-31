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
package org.spout.vanilla.world.generator.normal.biome.grassy;

import org.spout.api.generator.biome.Decorator;
import org.spout.api.geo.World;
import org.spout.api.material.BlockMaterial;
import org.spout.api.math.MathHelper;

import org.spout.vanilla.material.VanillaMaterials;
import org.spout.vanilla.world.generator.normal.NormalGenerator;
import org.spout.vanilla.world.generator.normal.biome.NormalBiome;

public abstract class GrassyBiome extends NormalBiome {
	protected BlockMaterial topCover = VanillaMaterials.GRASS;

	public GrassyBiome(int biomeId, Decorator... decorators) {
		super(biomeId, decorators);
	}

	@Override
	public int placeGroundCover(World world, int x, int y, int z) {
		super.placeGroundCover(world, x, y, z);
		final byte maxGroudCoverDepth = (byte) MathHelper.clamp(BLOCK_REPLACER.GetValue(x, 0, z) * 2 + 4, 2, 5);
		for (byte depth = 0; depth < maxGroudCoverDepth; depth++) {
			if (world.getBlockMaterial(x, y - depth, z).isMaterial(VanillaMaterials.AIR)) {
				return maxGroudCoverDepth;
			}
			if (depth == 0 && y >= NormalGenerator.SEA_LEVEL) {
				world.setBlockMaterial(x, y - depth, z, topCover, (short) 0, world);
			} else {
				world.setBlockMaterial(x, y - depth, z, VanillaMaterials.DIRT, (short) 0, world);
			}
		}
		return maxGroudCoverDepth;
	}

	public BlockMaterial getTopCover() {
		return topCover;
	}
}
