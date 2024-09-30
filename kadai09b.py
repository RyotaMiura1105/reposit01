#kadai09b
from collections import deque
a = [int(i) for i in input().split()]
ans = deque([])
for i in range(len(a)):
    ans.append(a[i])
    j = i
    while ans[j] < ans[(j - 1) // 2]:
        ans[j], ans[(j - 1) // 2] = ans[(j - 1) // 2], ans[j]
        j = (j - 1) // 2
        if j == 0:
            break
print(list(ans))


