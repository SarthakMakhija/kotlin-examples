package org.example.functional.recursion

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BinaryTreeOperationsUnitTest {

    private val binaryTreeOperations = BinaryTreeOperations()

    @Test
    fun `should return zero as the sum of a tree with leaf values as zero`() {
        val tree = Node(
            left = Leaf(0),
            right = Leaf(0)
        )
        val sum = binaryTreeOperations.leafSum(tree)

        assertThat(sum).isEqualTo(0)
    }

    @Test
    fun `should return zero as the sum of a tree with left sub-tree and right node as a leaf value with zero`() {
        val tree = Node(
            left = Node(
                left = Leaf(10), right = Leaf(0)
            ), right = Leaf(0)
        )
        val sum = binaryTreeOperations.leafSum(tree)

        assertThat(sum).isEqualTo(10)
    }

    @Test
    fun `should return zero as the sum of a binary tree`() {
        val tree = Node(
            left = Node(
                left = Leaf(10), right = Leaf(10)
            ),
            right = Node(
                left = Leaf(5),
                right = Leaf(100)
            )
        )
        val sum = binaryTreeOperations.leafSum(tree)

        assertThat(sum).isEqualTo(125)
    }
}