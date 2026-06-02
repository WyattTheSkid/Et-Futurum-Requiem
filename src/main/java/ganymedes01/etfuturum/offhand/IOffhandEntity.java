package ganymedes01.etfuturum.offhand;

public interface IOffhandEntity {
	void etfu$swingOffhand();

	float etfu$getOffhandSwingProgress(float partialTicks);

	Hand etfu$getActiveHand();

	void etfu$setActiveHand(Hand hand);
}
