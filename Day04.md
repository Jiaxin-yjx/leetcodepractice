LeetCode 24 — Swap Nodes in Pairs
Problem

Given a linked list, swap every two adjacent nodes and return the new head.

Restrictions:

You cannot change node values
Only node pointers can be changed

Example:

Input:
1 → 2 → 3 → 4

Output:
2 → 1 → 4 → 3
Key Idea

Use a dummy node to simplify handling the head.

Each iteration swaps two nodes.

Structure before swap:

dummy → 1 → 2 → 3 → 4
         ↑   ↑
       first second

After swap:

dummy → 2 → 1 → 3 → 4
Swap Steps

Let:

first = cur->next
second = cur->next->next

Step 1

first->next = second->next

Step 2

second->next = first

Step 3

cur->next = second

Move pointer

cur = first

LeetCode 19 — Remove Nth Node From End of List
Problem

Given the head of a linked list, remove the n-th node from the end and return the new head.

Example:

Input:
1 → 2 → 3 → 4 → 5
n = 2

Output:
1 → 2 → 3 → 5
Key Idea — Two Pointers

Use fast and slow pointers.

Steps:

Move fast pointer n steps ahead

Move fast and slow together

When fast reaches the end,
slow is right before the node to delete.

Why Use Dummy Node

To handle the case when the head node is removed.

dummy → 1 → 2 → 3 → 4 → 5
Pointer Movement

Move fast first:

fast moves n steps

Then move both:

fast → end
slow → node before target

Delete node:

slow->next = slow->next->next


2.7
142 not complete