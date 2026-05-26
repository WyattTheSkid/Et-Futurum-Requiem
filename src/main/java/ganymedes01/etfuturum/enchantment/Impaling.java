package ganymedes01.etfuturum.enchantment;

import ganymedes01.etfuturum.configuration.configs.ConfigEnchantsPotions;

public class Impaling extends TridentEnchantment {

	public Impaling() {
		super(ConfigEnchantsPotions.impalingID, 2, "impaling");
	}

	@Override
	public int getMinEnchantability(int enchantmentLevel) {
		return 1 + (enchantmentLevel - 1) * 8;
	}

	@Override
	public int getMaxEnchantability(int enchantmentLevel) {
		return getMinEnchantability(enchantmentLevel) + 20;
	}

	@Override
	public int getMaxLevel() {
		return 5;
	}
}
