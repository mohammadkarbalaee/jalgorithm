package io.github.jalgorithm.algorithms.sorts

import spock.lang.Specification;
import spock.lang.Subject

/**
 * 
 * @author mayur-ravindra
 *
 */
class BubbleSortSpecification extends Specification {

	@Subject
	private BubbleSort algorithm;


	def setup() {
		// any initial setup should go here
	}

	def "test happy path sorting for Bubble sort"() {
		given: "give an unsorted list of integers"
		def input = [3, 2, 11, 25, 4]
		algorithm = new BubbleSort(input)

		when: "algorithm is run"
		algorithm.sort()

		then: "assert the expected result"
		input == [2, 3, 4, 11, 25]
	}

	def "test for different data types"() {
		given: "give an unsorted list of integers"
		def input = ["z", "b", "d", "a", "e"]
		algorithm = new BubbleSort(input)

		when: "algorithm is run"
		algorithm.sort()

		then: "assert the expected result"
		input == ["a", "b", "d", "e", "z"]
	}

	def "test sort for same alphabets"() {
		given: "give an unsorted list of integers"
		def input = ["A", "a", "a"]
		algorithm = new BubbleSort(input)

		when: "algorithm is run"
		algorithm.sort()

		then: "assert the expected result"
		input == ["A", "a", "a"]
	}

	def "test sort for strings - non-alphabet characters"() {
		given: "give an unsorted list of integers"
		def input = ["!", "@", "3"]
		algorithm = new BubbleSort(input)

		when: "algorithm is run"
		algorithm.sort()

		then: "assert the expected result"
		input == ["!", "3", "@"]
	}

	def "test sort for long"() {
		given: "give an unsorted list of long"
		def input = [12233L, 121212122L, 4433L]
		algorithm = new BubbleSort(input)

		when: "algorithm is run"
		algorithm.sort()

		then: "assert the expected result"
		input == [4433, 12233, 121212122]
	}
	
	def "test sort for floats"() {
		given: "give an unsorted list of floats"
		def input = [2.5, 0.6, 3.0]
		algorithm = new BubbleSort(input)

		when: "algorithm is run"
		algorithm.sort()

		then: "assert the expected result"
		input == [0.6, 2.5, 3.0]
	}
	
	def "test sort for mina and max"() {
		given: "give an unsorted list of min and max numbers"
		def input = [Integer.MIN_VALUE, 0, Integer.MAX_VALUE]
		algorithm = new BubbleSort(input)

		when: "algorithm is run"
		algorithm.sort()

		then: "assert the expected result"
		input == [Integer.MIN_VALUE, 0, Integer.MAX_VALUE]
	}
}
