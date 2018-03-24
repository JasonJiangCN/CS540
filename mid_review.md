# Mid Review



## Game play

zero-sum: one player's gain is the other player's loss. Does not mean fair

discrete: states and decisions have discrete values

finite: finite number of states and decisions

deterministic: no coin flips, or die rolls - no chance

perfect information: each player can see the complete game state. No simulatnesous decisions.

### MiniMax

Max wants largest score

Min wants smallest score

#### Game theoretic value

aka minimax value of a node: the score of the terminal node that will be reached if both players play optimally = the numbers we filled in 

#### Complexity

Time: O(b^m), which is bad

Space: O(bm)

### Alplha-Beta 

**Graph on slide 3***

Depth-first order

After returning from A, Max can get at least 100 to S

After returning from F, Max can get at most 20 to B

At this point, Max losts interest in B

No need to explore G.

### Probability

Axioms: 

P(A) 属于 [0,1]

P(true) = 1, false = 0

P(A or B) = P (A) + P(B) - P(A and B)q

P(A1, A2, ….. , An) = P(A1)*P(A2 | A1) * P(A3 | A1, A2) ……...

### NLP basics

Bag-of-Words representation



