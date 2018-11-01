package com.zzu.preorder.traversal;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePreorderTraversal {

	public List<Integer> preorderTraversal(TreeNode root) {
		//存放树节点对象
		LinkedList<TreeNode> stack = new LinkedList<>();
		//存放节点值
	    LinkedList<Integer> output = new LinkedList<>();
	    //如果二叉树不存在
	    if( root == null) {
	    	return output;
	    }
	    //节点放进栈中保存
	    stack.add(root);
	    
	    
	    
	    //执行出栈
	    while (!stack.isEmpty()) {
	    	//检索并移除此列表的最后一个元素，或返回 null如果这个列表是空的。
	    	TreeNode node = stack.pollLast();
	    	//拿到节点值
	        output.add(node.val);
	        
	        //前序遍历 先是根节点 左节点  右节点
	        if(node.right != null) {
	        	stack.add(node.right);
	        }
	        
	        if(node.left != null) {
	        	stack.add(node.left);
	        }
	    }
	    
	    
	    
		return output;

	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
