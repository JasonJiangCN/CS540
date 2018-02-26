# HW3

## Part a
When FLAG=100, print out the four successor states of the initial state, in the order they are pushed into the stack (see below). Each successor state should be printed as 9 numbers on a single line. For example,

```
$java Torus 100 1 2 3 4 5 0 6 7 8

120453678 

123054678 

123405678 

123458670

```



Important: We ask you to implement the following order among successors. If we view the 9 numbers as a 9-digit integer, then there is a natural order among states. Whenever you push successors into the stack, push them from small 9-digit to large 9-digit. This means that when we later pop them out, the largest 9-digit successor will be goal-checked before the other successors. This order will be used throughout this program, so that the output is well-defined.

## Part b
When FLAG=2XX, perform a depth-limited depth-first search with cutoff depth XX (i.e. this is one outer-loop of iterative deepening). For example, if FLAG=200, the cutoff depth is 0. In DFS you will push the initial state in the stack, pop it out, do a goal test, but will NOT expand it. If FLAG=201, the cutoff depth is one. In DFS you will expand the initial state (i.e. put its four successors into the stack in the order we specified in Part a). You will pop each successor out, print it, and perform goal-check (and terminate the program if goal-check succeeds). But you will not expand any of these successors.
XX can be 00 to 99. If depth-limited DFS finds a goal before the cutoff, it should stop.
You will need to implement both backpointers and path-checking cycle prevention. Note: do not use the whole CLOSED set for cycle prevention, which is not memory efficient for DFS. Use a “prefix path” instead. Recall in the prefix path you only need to record the path from the initial state to the current state being goal-checked. Specifically, you can implement the prefix path-checking as follows:
(Part b, 20 points)
(Part c, 20 points)
push t to the DFS stack; if yes, do not push it. This is path-checking cycle prevention.
For this part, print out the states in the order of goal-test (i.e. when you pop them out of the stack).
For example:
```
$java Torus 201 1 2 3 4 5 0 6 7 8 
123450678 
123458670 
123405678 
123054678 
120453678
```

