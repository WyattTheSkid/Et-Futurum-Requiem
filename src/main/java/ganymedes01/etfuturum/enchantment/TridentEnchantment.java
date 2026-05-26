package ganymedes01.etfuturum.enchantment;

import ganymedes01.etfuturum.ModEnchantments;
import ganymedes01.etfuturum.ModItems;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.item.ItemStack;

public class TridentEnchantment extends Enchantment {

	protected TridentEnchantment(int id, int weight, String name) {
		super(id, weight, EnumEnchantmentType.breakable);
		Enchantment.addToBookList(this);
		setName(name);
	}

	@Override
	public boolean canApply(ItemStack stack) {
		return isTrident(stack);
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) {
		return isTrident(stack);
	}

	@Override
	public boolean canApplyTogether(Enchantment enchantment) {
		if (!super.canApplyTogether(enchantment)) {
			return false;
		}

		return !isRiptideConflict(this, enchantment) && !isRiptideConflict(enchantment, this);
	}

	private boolean isRiptideConflict(Enchantment first, Enchantment second) {
		return first == ModEnchantments.riptide && (second == ModEnchantments.loyalty || second == ModEnchantments.channeling);
	}

	private boolean isTrident(ItemStack stack) {
		return stack != null && ModItems.TRIDENT.isEnabled() && stack.getItem() == ModItems.TRIDENT.get();
	}
}
