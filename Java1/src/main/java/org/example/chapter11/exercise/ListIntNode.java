package org.example.chapter11.exercise;

public class ListIntNode {
    int info;
    ListIntNode next;

    ListIntNode(int x) {
        info = x;
    }

    ListIntNode(int x, ListIntNode node) {
        info = x;
        next = node;
    }
}

