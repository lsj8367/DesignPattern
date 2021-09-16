package structural.bridge.test;

import structural.bridge.impl.ArrayImpl;
import structural.bridge.impl.LinkedListImpl;
import structural.bridge.list.Stack;

public class BridgeTest {

    public static void main(String[] args) {
        Stack<String> linkedListStack = new Stack<>(new LinkedListImpl<>());
        linkedListStack.push("aaa");
        linkedListStack.push("bbb");
        linkedListStack.push("ccc");

        System.out.println(linkedListStack);
        System.out.println(linkedListStack.pop());
        System.out.println(linkedListStack.pop());
        System.out.println(linkedListStack.pop());

        Stack<String> arrayStack = new Stack<>(new ArrayImpl<String>());
        arrayStack.push("aaa");
        arrayStack.push("bbb");
        arrayStack.push("ccc");

        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());

    }
}
