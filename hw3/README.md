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