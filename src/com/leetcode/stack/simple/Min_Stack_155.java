package com.leetcode.stack.simple;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 155. 最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * 实现 MinStack 类:
 * <p>
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * <p>
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 * <p>
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 * <p>
 * <p>
 * 提示：
 * <p>
 * -231 <= val <= 231 - 1
 * pop、top 和 getMin 操作总是在 非空栈 上调用
 * push, pop, top, and getMin最多被调用 3 * 104 次
 */
public class Min_Stack_155 {

    List<Integer> list;
    Stack<Integer> stack;

    public Min_Stack_155() {
        list = new ArrayList<>();
        stack = new Stack<>();
    }

    public void push(int val) {

        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > val) {
                index = i;
                break;
            }
            if (i == list.size() - 1) {
                index = i + 1;
                break;
            }
        }

        list.add(index, val);
        stack.push(val);
    }

    public void pop() {

        int val = stack.pop();
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == val) {
                index = i;
                break;
            }
        }
        list.remove(index);
    }

    public int top() {

        int val = stack.peek();
        System.out.println("top-->" + val);
        return val;
    }

    public int getMin() {

        int val = list.get(0);
        System.out.println("getMin-->" + val);
        return val;
    }

    public static void main(String[] args) {
        Min_Stack_155 minStack = new Min_Stack_155();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-1);
        minStack.getMin();
        minStack.top();
        minStack.pop();
        minStack.getMin();
    }
}
