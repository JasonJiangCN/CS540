

### Jason Jiang

#### Question 2

##### 1. 

There are $m*n-k$ tiles

##### 2.

We need to place $m*n - k$ tiles in $m*n$ squares

so there are $(m*n)!/((m*n) - (m*n - k))!$ possible states

##### 3.

A, B, C represents the names of the nodes, and according to 2., we should have 24 possible states.

​	1) for each row, fix one node on the up left place.

​	2) then, fix another node 

​	3) change the last node in 2 possible avaliable places.

​	3) After that, change the location of the fixed node in 2), then do 3) again untile all possible states are done.

![IMG_4476](/Users/Jason/Downloads/IMG_4476.JPG)