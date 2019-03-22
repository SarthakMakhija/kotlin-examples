package org.example.functional.recursion

class BinaryTreeOperations {

    fun leafSum(tree: BinaryTree): Int =
        when (tree) {
            is Leaf -> tree.value
            is Node -> leafSum(tree.left) + leafSum(tree.right)
        }
}