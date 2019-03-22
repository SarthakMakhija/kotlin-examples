package org.example.functional.recursion

sealed class BinaryTree

data class Leaf(val value: Int) : BinaryTree()

data class Node(val left: BinaryTree, val right: BinaryTree) : BinaryTree()