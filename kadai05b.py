#kadai05
n = int(input())
J = []
k = 0
cnt = 1
from operator import itemgetter
for _ in range(n):
    J.append([int(i) for i in input().split()])
J = sorted(J, key = itemgetter(1))
for i in range(1, n):
    if J[k][1] <= J[i][0]:
        cnt += 1 
        k = i
    else:
        pass
print(cnt)
