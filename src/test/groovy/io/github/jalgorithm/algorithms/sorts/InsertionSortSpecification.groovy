package io.github.jalgorithm.algorithms.sorts

import spock.lang.Specification
import spock.lang.Subject

/**
 * 
 * @author mayur-ravindra
 *
 */
class InsertionSortSpecification extends Specification {

	@Subject
	private InsertionSort algorithm;

	def "sorting integers"() {
		given: "unsorted list of integers"
		def data = [78, 2, 33, 6, 0, -11]
		algorithm = new InsertionSort(data)

		when: "sorted"
		algorithm.sort()

		then: "assert that the list is sorted"
		Arrays.sort(data)
		algorithm.getData() == data
	}

	def "sorting floats"() {
		given: "unsorted list of floating point numbers"
		def data = [
			7.8f,
			2.33f,
			-33.4f,
			6.0f,
			0.0f,
			-11.23f
		]
		algorithm = new InsertionSort(data)

		when: "sorted"
		algorithm.sort()

		then: "assert that the list is sorted"
		Arrays.sort(data)
		algorithm.getData() == data
	}

	def "sorting doubles"() {
		given: "unsorted list of doubles"
		def data = [
			78.2,
			2.4,
			33.5,
			6.3,
			0.6,
			-11.4
		]
		algorithm = new InsertionSort(data)

		when: "sorted"
		algorithm.sort()

		then: "assert that the list is sorted"
		Arrays.sort(data)
		algorithm.getData() == data
	}

	def "sorting strings"() {
		given: "unsorted list of strings"
		def data = ["z", "p", "a", "A"]
		algorithm = new InsertionSort(data)

		when: "sorted"
		algorithm.sort()

		then: "assert that the list is sorted"
		Arrays.sort(data)
		algorithm.getData() == data
	}

	def "sorting longs"() {
		given: "unsorted list of longs"
		def data = ["z", "p", "a", "A"]
		algorithm = new InsertionSort(data)

		when: "sorted"
		algorithm.sort()

		then: "assert that the list is sorted"
		Arrays.sort(data)
		algorithm.getData() == data
	}

	def "sorting duplicates"() {
		given:
		def data = ["a", "a", "A"]
		algorithm = new InsertionSort(data)
		when: "sorted"
		algorithm.sort()

		then: "assert that the list is sorted"
		Arrays.sort(data)
		algorithm.getData() == data
	}
}