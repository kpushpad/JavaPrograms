package com.kpushpad.datastructure.tree;

public class TreeNode<E extends Comparable<E>> {
	Node<E> root;
	int size;

	public void insert(E e) {
		this.root = insertInternal(this.root, e);
	}
	Node<E>  insertInternal(Node<E> root,E e) {
		if (null == root) {
			Node<E> node = new Node<E>(null, e, null);
			root = node;
		} else if (1 > e.compareTo(root.item)) {
			root.left = insertInternal(root.left, e);
		} else {
			root.right = insertInternal(root.right, e);
		}
      return root;
	}
}
