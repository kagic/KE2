package mod.kagic.entity;

public interface IQuartzVariant extends IGemVariant {
	@Override public String getName();
	@Override public int getUniformColor();
	@Override public int[] getGemstoneColors();
	@Override public int[] getSkinColors();
	@Override public int[] getHairColors();
	public int[] getBandColors();
	public int[] getBandIndices();
	public int[] getMarkColors();
	public int[] getMarkIndices();
}