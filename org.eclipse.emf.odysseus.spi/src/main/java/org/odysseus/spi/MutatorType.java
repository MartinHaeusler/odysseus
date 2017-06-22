package org.odysseus.spi;

public enum MutatorType {

	/** Declares that the modification primarily <b>adds new elements</b> to the model. */
	ADDITION,

	/** Declares that the modification primarily <b>removes elements</b> from the model. */
	SUBTRACTION,

	/** Declares that the modification primarily introduces variance into the model, e.g. changing EAttribute values. */
	VARIATION,

	/** Declares that the modification contains a mix of additions, deletions and/or variations. */
	MIXED;

}
