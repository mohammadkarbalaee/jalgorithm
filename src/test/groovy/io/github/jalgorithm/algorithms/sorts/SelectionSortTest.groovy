package io.github.jalgorithm.algorithms.sorts

import static org.assertj.core.api.InstanceOfAssertFactories.LIST

import spock.lang.Specification
import spock.lang.Subject

class SelectionSortTest extends Specification {

	@Subject
	private SelectionSort algorithm;

	def setup() {
	}

	def "sorting integers"() {
		given: "unsorted list of integers"
		def data = [78, 2, 33, 6, 0, -11]
		algorithm = new SelectionSort(data)

		when: "sorted"
		algorithm.sort()

		then: "assert that the list is sorted"
		algorithm.data == data.sort()
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
		algorithm = new SelectionSort(data)

		when: "sorted"
		def sorted = algorithm.sort()

		then: "assert that the list is sorted"
		algorithm.data == data.sort()
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
		algorithm = new SelectionSort(data)

		when: "sorted"
		def sorted = algorithm.sort()

		then: "assert that the list is sorted"
		algorithm.data == data.sort()
	}

	def "sorting strings"() {
		given: "unsorted list of strings"
		def data = ["z", "p", "a", "A"]
		algorithm = new SelectionSort(data)

		when: "sorted"
		def sorted = algorithm.sort()

		then: "assert that the list is sorted"
		algorithm.data == data.sort()
	}

	def "sorting longs"() {
		given: "unsorted list of longs"
		def data = ["z", "p", "a", "A"]
		algorithm = new SelectionSort(data)

		when: "sorted"
		def sorted = algorithm.sort()

		then: "assert that the list is sorted"
		algorithm.data == data.sort()
	}

	def "sorting duplicates"() {
		given:
		def data = ["a", "a", "A"]
		algorithm = new SelectionSort(data)
		when: "sorted"
		def sorted = algorithm.sort()

		then: "assert that the list is sorted"
		algorithm.data == data.sort()
	}
}
