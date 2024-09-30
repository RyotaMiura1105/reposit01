#kadai09c
from collections import deque
a = deque([int(i) for i in input().split()])
k = int(input())
ans = []
for i in range(k):
    ans.append(a.popleft())
    a.rotate()
    length = int(len(a))
    l = 0
    if length == 0:
            break
    while True:
        if (2 * l + 1) + 1 > length:
                 break
        elif (2 * (l + 1)) + 1 > length:
                if a[l] > a[2 * l + 1]:
                      a[l], a[2 * l + 1] = a[2 * l + 1], a[l]
                      l = 2 * l + 1
                else:
                      break
        else:
            if a[l] > a[2 * l + 1] and a[2 * l + 1] < a[2 * (l + 1)]:
                  a[l], a[2 * l + 1] = a[2 * l + 1], a[l]
                  l = 2 * l + 1
            elif a[l] > a[2 * (l + 1)] and a[2 * l + 1] > a[2 * (l + 1)]:
                  a[l], a[2 * (l + 1)] = a[2 * (l + 1)], a[l]  
                  l = 2 * (l + 1)
            else:
                  break
print(*ans)
print(list(a))
