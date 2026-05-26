package ganymedes01.etfuturum.enchantment;

import ganymedes01.etfuturum.configuration.configs.ConfigEnchantsPotions;

public class Riptide extends TridentEnchantment {

	public Riptide() {
		super(ConfigEnchantsPotions.riptideID, 2, "riptide");
	}

	@Override
	public int getMinEnchantability(int enchantmentLevel) {
		return 10 + enchantmentLevel * 7;
	}

	@Override
	public int getMaxEnchantability(int enchantmentLevel) {
		return 50;
	}

	@Override
	public int getMaxLevel() {
		return 3;
	}
}
