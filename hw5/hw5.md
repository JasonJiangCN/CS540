# Homework 5



## Question 1

 ### 1

Basically we will do from the bottom to the top. For the third row we will pick the largest value of their offsprings. So D = 4, E = 7, F = 8, G = 6

For the second row, we need to pick the smallest value. So B = 4, C = 6.

Fianlly, we need to pick largest value of the second row for the A, which is 6.

### 2

Similar to 1, the search begins with D. D is 4, and then a = 4, ß = infinity.

Then E. It finds that 7 > 4, search on this branch will terminate. Then a = negtive infinity, ß = 4. 

Then B. B is 4. a = negtive infinity and ß = 4.

Then F. F is 8, then a = 8, ß = infinity.

Then G. G is 6, a = 6, ß = 8.

Then C. C is 6, a = 4, ß = 6.

Then A. A is 6, a = 6, ß = infinity.

### 3

The right branch of E is pruned.

### 4

Because if we search all of the nodes it will takes a lot of time, which is unessary because we can skip some nodes and still get the right answer. It will, for the ideal situation, save a half of time for the search. 

### 5

There are two opportunities to select the optimal action. The first is heads up in the first turn, which has probability of .5. 

The second is, get tails up in the first turn and get one face up that represent selecting optimal, which has probalitity of .5 * .5 = .25

So the overall probability is .5 + .25 = .75

### 6

![telegram-cloud-file-1-806123229-57070-5540527014816863065](/Users/Jason/Library/Group Containers/6N38VWS5BX.ru.keepcoder.Telegram/account-14985357259618808439/postbox/media/telegram-cloud-file-1-806123229-57070-5540527014816863065.jpg)

### 7

A 4.77

B 4.25

C 4.94

D 3.75

E 5.75

F 6.25

G 4.50

## Question 2

### 1

I want to use C to implement this method. I'll use getline to get a full line and use a while loop with strtok() to tokenize the line by the space. Each time the strtok() will return a word, and we just need to save those words.

### 2

There are 202998 words in toal, and there are 19718 distinct words.

### 3


|frequency  word|
| -----------------------|
|11876	the         |
| 6825	to           |
| 6171	of           |
| 5273	and          |
| 4429	in           |
| 4009	a            |
| 3453	that         |
| 3381	is           |
| 3231	ai           |
| 2698	be           |
| 2065	will         |
| 2043	it           |
| 1860	for          |
| 1708	as           |
| 1637	are          |
| 1600	on           |
| 1554	not          |
| 1441	this         |
| 1365	with         |
| 1229	intelligence |

### 4

| frequency word|
| --------------------- |
| 1	abstract         |
| 1	abrupt           |
| 1	abroad           |
| 1	abraham          |
| 1	aboard           |
| 1	abnormal         |
| 1	abide            |
| 1	abdominal        |
| 1	abc              |
| 1	abbasi           |
| 1	'you             |
| 1	'transportation' |
| 1	'top             |
| 1	'self            |
| 1	'see'            |
| 1	's               |
| 1	'overview'       |
| 1	'drivers'        |
| 1	'chauffeurs      |
| 1	'artificial      |

### 5

![telegram-cloud-file-1-804725156-153485-7202880236658149518](/Users/Jason/Library/Group Containers/6N38VWS5BX.ru.keepcoder.Telegram/account-14985357259618808439/postbox/media/telegram-cloud-file-1-804725156-153485-7202880236658149518.jpg)

### 6

![telegram-cloud-file-1-806119008-56811--4474512679890277314](/Users/Jason/Library/Group Containers/6N38VWS5BX.ru.keepcoder.Telegram/account-14985357259618808439/postbox/media/telegram-cloud-file-1-806119008-56811--4474512679890277314.jpg)

### 7

the first curve has very large value at the very first part, and then sharply goes down when x-axis increase.

the second one will also goes down with the increasing of x-axis. relatively linear.

### 8

The first big issue is the trivival notions will influence the result. For example, "however" and "however, " will be treated as two different words.

The second issue is the capital words. "However" and "however" will be counted as two words.