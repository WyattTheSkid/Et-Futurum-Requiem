package ganymedes01.etfuturum.enchantment;

import ganymedes01.etfuturum.configuration.configs.ConfigEnchantsPotions;

public class Channeling extends TridentEnchantment {

	public Channeling() {
		super(ConfigEnchantsPotions.channelingID, 1, "channeling");
	}

	@Override
	public int getMinEnchantability(int enchantmentLevel) {
		return 25;
	}

	@Override
	public int getMaxEnchantability(int enchantmentLevel) {
		return 50;
	}
}
