public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        /**
        定义两个指针, 第一轮让两个到达末尾的节点指向另一个链表的头部, 最后如果相遇则为交点(在第一轮移动中恰好抹除了长度差)
        两个指针等于移动了相同的距离, 有交点就返回, 无交点就是各走了两条指针的长度
        **/
        if(headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        // 在这里第一轮体现在pA和pB第一次到达尾部会移向另一链表的表头, 而第二轮体现在如果pA或pB相交就返回交点, 不相交最后就是null==null
        while(pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}

kQYsnJcHaominYuan
3 个月前
其实这道题和判断是否有环并返回第一个环节点很像。beat 100%

class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode last = headB;
        while (last.next != null) {
            last = last.next;
        }
        last.next = headB;

        ListNode fast = headA;
        ListNode slow = headA;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = headA;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                last.next = null;
                return fast;
            }
        }
        last.next = null;
        return null;
    }
}

1->2->3->5->7
2->4


public ListNode removeElements(ListNode head, int val) {
        ListNode header = new ListNode(-1);
        header.next = head;
        ListNode cur = header;
        while(cur.next != null){
            if(cur.next.val == val ){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        return header.next;
    }


    /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
    输入: 1->2->3->4->5->NULL
	输出: 5->4->3->2->1->NULL
class Solution {
    public ListNode reverseList(ListNode head) {
       if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }   
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
next       
cur.next  
pre 	   
cur		   
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;
        while(cur != null) {
            next = cur.next;
            // 进行变换
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}

/** 递归解法**/
public ListNode reverseNode(ListNode cur,ListNode prev) {
      if(cur == null){
          return prev;
      }else{
         ListNode nextLinkeNode = cur.next;
         cur.next = prev;
         prev = cur;
         cur  = nextLinkeNode;
         return reverseNode(cur,prev);
      }


class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode newHead=null;
        while(head!=null){
            ListNode next=head.next;
            head.next=newHead;
            newHead=head;
            head=next;
        }
        return newHead;
    }
}



class Solution { 
	public: 
		ListNode* reverseList(ListNode* head) { 
		ListNode* last = NULL, *next = head;
		 while(next)  //Loop to the last two element
		 {
		     next = head->next;      //Record which is next node
		     head->next = last;      //Turn the next node to last node
		     last = head;            //Record which is last node
		     head = next?next:head;  //Record which is the head node now
		 }
		 return head;      
	} 
};



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
示例 1:

输入: 1->2
输出: false
示例 2:

输入: 1->2->2->1
输出: true
class Solution {
    public boolean isPalindrome(ListNode head) {
        
    }
}



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        // 先合并根节点
        t1.val += t2.val;
        // 再递归合并左右子树
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }
}


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//有点小问题
class Solution {
    private int count1=0;
    	private int count2=0;
		private int count3=0;
    public int maxDepth(TreeNode root) {
      return mergeTrees(root);
    }
    int mergeTrees(TreeNode root){
    	
    	if(root==null){
            return 0;
        }
    	if(root.left!=null){
    		count2++;
    		mergeTrees(root.left);
    	}
    	if(root.right!=null){
    		count3++;
    		mergeTrees(root.right);
    	}

    	return count2>count3?count2+1:count3+1;
    	
    }
}


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
输入：

     4
   /   \
  2     7
 / \   / \
1   3 6   9
输出：

     4
   /   \
  7     2
 / \   / \
9   6 3   1

class Solution {
   public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        //当左右树都为空的时候不翻转,左右其中一个非空就翻转
        if (!(root.right == null && root.left == null)) {
            TreeNode right = root.right;
            TreeNode left = root.left;
            root.right = left;
            root.left = right;
            //翻转下一次层级，判断非空
            if (root.right != null) {
                invertTree(root.right);
            }
            //翻转下一次层级，判断非空
            if (root.left != null) {
                invertTree(root.left);
            }
        }

        return root;
    }
}


/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<Integer> res = new ArrayList<Integer>();
    public List<Integer> preorder(Node root) {
        if(root == null)
            return res;
        res.add(root.val);
        for(Node child : root.children){
            preorder(child);
        }
        return res;
    }
}




/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
	public List<Integer> postorder(Node root) {
	    List<Integer> res = new ArrayList<Integer>();
	    if(root == null)
	        return res;
	    Stack<Node> stack = new Stack<Node>();
	    Node pre = null;
	    stack.push(root);
	    while(!stack.isEmpty()){
	        Node curr = stack.peek();
	        if((curr.children.size() == 0)||(pre != null && (curr.children.contains(pre)))){
	            res.add(curr.val);
	            pre = curr;
	            stack.pop();
	        }else{
	            for(int i = curr.children.size()-1;i>=0;i--){
	                stack.push(curr.children.get(i));    
	            }    
	        }                     
	    }
	    return res;    
}
}




https://blog.csdn.net/coder__666/article/details/80349039 



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    private int ret = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        /**
        对于任意一个节点, 如果最大和路径包含该节点, 那么只可能是两种情况:
        1. 其左右子树中所构成的和路径值较大的那个加上该节点的值后向父节点回溯构成最大路径
        2. 左右子树都在最大路径中, 加上该节点的值构成了最终的最大路径
        **/
        getMax(root);
        return ret;
    }
    
    private int getMax(TreeNode r) {
        if(r == null) return 0;
        int left = Math.max(0, getMax(r.left)); // 如果子树路径和为负则应当置0表示最大路径不包含子树
        int right = Math.max(0, getMax(r.right));
        ret = Math.max(ret, r.val + left + right); // 判断在该节点包含左右子树的路径和是否大于当前最大路径和
        return Math.max(left, right) + r.val;
    }
}



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        
    }
}