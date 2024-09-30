#kadai09a
from collections import deque
a = ([int(i) for i in input().split()])
ans = deque([])
for i in range(len(a)):
    if (i % 2) == 0:
        ans.appendleft(a[i])
    else:
        ans.append(a[i])
print(*ans)
