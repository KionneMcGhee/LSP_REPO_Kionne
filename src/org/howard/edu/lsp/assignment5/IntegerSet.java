package org.howard.edu.lsp.assignment5;

import java.util.NavigableSet;
import java.util.TreeSet;

/**
 * Represents a mathematical set of unique integers.
 *
 * <p>The elements are kept in ascending numerical order. Operations that
 * produce a set return a separate, independently modifiable {@code IntegerSet}
 * without changing either operand.</p>
 */
public class IntegerSet {
    private final NavigableSet<Integer> elements;

    /**
     * Creates an empty integer set.
     */
    public IntegerSet() {
        elements = new TreeSet<>();
    }

    /**
     * Removes every element from this set.
     */
    public void clear() {
        elements.clear();
    }

    /**
     * Returns the number of distinct elements in this set.
     *
     * @return the set's cardinality
     */
    public int length() {
        return elements.size();
    }

    /**
     * Tests whether this set and the specified set contain the same integers.
     * Insertion order does not affect equality.
     *
     * @param b the other integer set
     * @return {@code true} if the sets have identical elements; otherwise
     *         {@code false}, including when {@code b} is {@code null}
     */
    public boolean equals(IntegerSet b) {
        return b != null && elements.equals(b.elements);
    }

    /**
     * Compares this set with another object for equality.
     *
     * @param other the object to compare
     * @return {@code true} if the object is an {@code IntegerSet} containing
     *         exactly the same elements
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IntegerSet)) {
            return false;
        }
        return equals((IntegerSet) other);
    }

    /**
     * Returns a hash code consistent with element-based equality.
     *
     * @return the hash code of this set's elements
     */
    @Override
    public int hashCode() {
        return elements.hashCode();
    }

    /**
     * Checks whether an integer belongs to this set.
     *
     * @param value the integer to find
     * @return {@code true} if the value is present
     */
    public boolean contains(int value) {
        return elements.contains(value);
    }

    /**
     * Returns the greatest integer in this set.
     *
     * @return the greatest element
     * @throws IllegalStateException if the set is empty
     */
    public int largest() {
        if (elements.isEmpty()) {
            throw new IllegalStateException("Cannot find the largest element of an empty set.");
        }
        return elements.last();
    }

    /**
     * Returns the least integer in this set.
     *
     * @return the least element
     * @throws IllegalStateException if the set is empty
     */
    public int smallest() {
        if (elements.isEmpty()) {
            throw new IllegalStateException("Cannot find the smallest element of an empty set.");
        }
        return elements.first();
    }

    /**
     * Adds an integer if it is not already present.
     *
     * @param item the integer to add
     */
    public void add(int item) {
        elements.add(item);
    }

    /**
     * Removes an integer if it is present.
     *
     * @param item the integer to remove
     */
    public void remove(int item) {
        elements.remove(item);
    }

    /**
     * Creates the union of this set and another set.
     *
     * @param b the other set
     * @return a new set containing every element in either operand
     * @throws NullPointerException if {@code b} is {@code null}
     */
    public IntegerSet union(IntegerSet b) {
        IntegerSet result = copy();
        result.elements.addAll(b.elements);
        return result;
    }

    /**
     * Creates the intersection of this set and another set.
     *
     * @param b the other set
     * @return a new set containing only elements shared by both operands
     * @throws NullPointerException if {@code b} is {@code null}
     */
    public IntegerSet intersect(IntegerSet b) {
        IntegerSet result = copy();
        result.elements.retainAll(b.elements);
        return result;
    }

    /**
     * Creates the difference of this set and another set.
     *
     * @param b the set whose elements will be excluded
     * @return a new set containing elements in this set but not in {@code b}
     * @throws NullPointerException if {@code b} is {@code null}
     */
    public IntegerSet diff(IntegerSet b) {
        IntegerSet result = copy();
        result.elements.removeAll(b.elements);
        return result;
    }

    /**
     * Creates the assignment-defined complement, meaning {@code b - this}.
     * This is the reverse of {@link #diff(IntegerSet)}.
     *
     * @param b the set from which this set's elements will be removed
     * @return a new set containing elements in {@code b} but not in this set
     * @throws NullPointerException if {@code b} is {@code null}
     */
    public IntegerSet complement(IntegerSet b) {
        IntegerSet result = b.copy();
        result.elements.removeAll(elements);
        return result;
    }

    /**
     * Determines whether every element of this set belongs to another set.
     * An empty set is a subset of any set.
     *
     * @param b the potential superset
     * @return {@code true} if this set is a subset of {@code b}
     * @throws NullPointerException if {@code b} is {@code null}
     */
    public boolean isSubsetOf(IntegerSet b) {
        return b.elements.containsAll(elements);
    }

    /**
     * Determines whether this set has no elements in common with another set.
     * Empty sets are disjoint from all sets.
     *
     * @param b the other set
     * @return {@code true} if there are no shared elements
     * @throws NullPointerException if {@code b} is {@code null}
     */
    public boolean isDisjoint(IntegerSet b) {
        for (int element : elements) {
            if (b.elements.contains(element)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Creates the symmetric difference of this set and another set.
     *
     * @param b the other set
     * @return a new set containing elements in exactly one of the operands
     * @throws NullPointerException if {@code b} is {@code null}
     */
    public IntegerSet symmetricDiff(IntegerSet b) {
        IntegerSet result = copy();
        for (int element : b.elements) {
            if (!result.elements.add(element)) {
                result.elements.remove(element);
            }
        }
        return result;
    }

    /**
     * Checks whether this set contains no elements.
     *
     * @return {@code true} if the set is empty
     */
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    /**
     * Returns the elements in ascending order, separated by a comma and a
     * space and enclosed in square brackets. An empty set is {@code []}.
     *
     * @return the formatted elements of this set
     */
    @Override
    public String toString() {
        return elements.toString();
    }

    /**
     * Makes a distinct copy of this set for use by set-producing operations.
     *
     * @return a new set with the same elements
     */
    private IntegerSet copy() {
        IntegerSet result = new IntegerSet();
        result.elements.addAll(elements);
        return result;
    }
}
