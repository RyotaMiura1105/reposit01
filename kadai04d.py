#kadai04d
import math
P = [int(i) for i in input().split()]
N = [int(i) for i in input().split()]
B = int(input())
left = 1
right = 1000
while left + 1 < right:
    sum = 0
    center = int((left + right) / 2)
    for i in range(len(P)):
        sum += min((center * N[i]), 1000 - P[i])
    if sum <= B:   
        left = center
    elif sum > B:
        right = center
    else:
        pass
print(left)