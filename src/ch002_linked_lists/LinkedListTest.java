package ch002_linked_lists;

import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class LinkedListTest {
    @Test
    public void test() {
        LinkedList<String> ll = new LinkedList();

        ll.add("test1");
        ll.add("test4");
        ll.add("test2");
        ll.add("test3");
        ll.add("test5");

        ll.pop();
        ll.pop();
    }

}