package ganymedes01.etfuturum.enchantment;

import ganymedes01.etfuturum.configuration.configs.ConfigEnchantsPotions;

public class Loyalty extends TridentEnchantment {

	public Loyalty() {
		super(ConfigEnchantsPotions.loyaltyID, 5, "loyalty");
	}

	@Override
	public int getMinEnchantability(int enchantmentLevel) {
		return 5 + enchantmentLevel * 7;
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
