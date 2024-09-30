#kadai11c
import numpy as np
n = int(input())
s = int(input())
np.random.seed(s)
A = np.random.randint(0, 2, (n,n))
b = np.random.randint(0, 2*n, n)
D = np.zeros((n,n))
for i in range(n):
    for j in range(n):
        if i == j:
            A[i][j] += n
for i in range(n):
    for j in range(n):
        if i == j:
            D[i][j] = A[i][j]
N = A - D
x = np.zeros(n)
norm = np.linalg.norm(A @ x - b)
cnt = 0
D = np.linalg.inv(D)
while norm > 1.0e-6 or cnt < 100:
    cnt += 1
    nx = (-1)*(N @ x)
    x = (D @ nx + b)
    norm = np.linalg.norm(A @ x - b)
print(*x)
