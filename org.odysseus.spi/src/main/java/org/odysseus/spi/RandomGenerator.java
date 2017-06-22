package org.odysseus.spi;

import java.util.List;

import org.odysseus.spi.exceptions.NotEnoughElementsException;

import com.google.common.collect.Iterables;

public interface RandomGenerator {

	public boolean coinToss();

	public void setSeed(long newSeed);

	public int nextInt();

	public int nextIntBetween(int low, int high);

	public long nextLong();

	public long nextLongBetween(long low, long high);

	public float nextFloat();

	public float nextFloatBetween(float low, float high);

	public double nextDouble();

	public double nextDoubleBetween(double low, double high);

	public default <T> T pickOne(final List<T> list) throws NotEnoughElementsException {
		return Iterables.getOnlyElement(this.pick(list, 1, true), null);
	}

	public default <T> List<T> pick(final List<T> list, final int count) throws NotEnoughElementsException {
		return this.pick(list, count, true);
	}

	public <T> List<T> pick(List<T> list, int count, boolean distinct) throws NotEnoughElementsException;

}
