package org.odysseus.spi;

import static com.google.common.base.Preconditions.*;

import java.util.List;
import java.util.Random;
import java.util.Set;

import org.odysseus.spi.exceptions.NotEnoughElementsException;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class DefaultRandomGenerator implements RandomGenerator {

	// =================================================================================================================
	// FIELDS
	// =================================================================================================================

	private Random random;

	// =================================================================================================================
	// CONSTRUCTOR
	// =================================================================================================================

	public DefaultRandomGenerator() {
		this(System.currentTimeMillis());
	}

	public DefaultRandomGenerator(final String seed) {
		this(seed.hashCode());
	}

	public DefaultRandomGenerator(final long seed) {
		this.random = new Random(seed);
	}

	// =================================================================================================================
	// PUBLIC API
	// =================================================================================================================

	@Override
	public boolean coinToss() {
		return this.nextDoubleBetween(0, 1) >= 0.5;
	}

	@Override
	public void setSeed(final long newSeed) {
		this.random.setSeed(newSeed);
	}

	@Override
	public double nextDouble() {
		return this.random.nextDouble();
	}

	@Override
	public double nextDoubleBetween(final double low, final double high) {
		checkArgument(low <= high, "Precondition violation - argument 'low' must be <= argument 'high'!");
		double range = Math.abs(high - low);
		double r = this.random.nextDouble() * range;
		return low + r;
	}

	@Override
	public float nextFloat() {
		return this.random.nextFloat();
	}

	@Override
	public float nextFloatBetween(final float low, final float high) {
		checkArgument(low <= high, "Precondition violation - argument 'low' must be <= argument 'high'!");
		float range = Math.abs(high - low);
		float r = this.random.nextFloat() * range;
		return low + r;
	}

	@Override
	public int nextInt() {
		return this.random.nextInt();
	}

	@Override
	public int nextIntBetween(final int low, final int high) {
		checkArgument(low <= high, "Precondition violation - argument 'low' must be <= argument 'high'!");
		int range = Math.abs(high - low);
		int r = this.random.nextInt(range);
		return low + r;
	}

	@Override
	public long nextLong() {
		return this.random.nextLong();
	}

	@Override
	public long nextLongBetween(final long low, final long high) {
		checkArgument(low <= high, "Precondition violation - argument 'low' must be <= argument 'high'!");
		long range = Math.abs(high - low);
		long r = Math.abs(this.random.nextLong()) % range;
		return low + r;
	}

	@Override
	public <T> List<T> pick(final List<T> elements, final int count, final boolean distinct)
			throws NotEnoughElementsException {
		checkNotNull(elements, "Precondition violation - argument 'elements' must not be NULL!");
		checkArgument(count >= 0, "Precondition violation - argument 'count' must not be negative!");
		if (count == 0) {
			return Lists.newArrayList();
		}
		List<T> result = Lists.newArrayList();
		if (elements.size() < count && distinct) {
			throw new NotEnoughElementsException("Cannot pick " + count
					+ " distinct elements from a list that contains only " + elements.size() + " elements!");
		}
		if (distinct) {
			Set<T> distinctElements = Sets.newHashSet(elements);
			if (distinctElements.size() < count && distinct) {
				throw new NotEnoughElementsException(
						"Cannot pick " + count + " distinct elements from a list that contains only " + elements.size()
								+ " distinct elements!");
			}
		}
		while (result.size() < count) {
			T element = this.pickOneInternal(elements);
			result.add(element);
		}
		return result;
	}

	private <T> T pickOneInternal(final List<T> elements) {
		int index = this.nextIntBetween(0, elements.size());
		return elements.get(index);
	}

}
