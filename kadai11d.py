#kadai11d
import numpy as np
np.set_printoptions(threshold=np.inf)
n = int(input())
s = int(input())
np.random.seed(s)
A = np.random.randint(0, 2, (n, n))
B = np.random.randint(0, 2, (n, n))
if n == 1:
    print(A @ B)
else:
    A11, A12 = A[:n//2, :n//2], A[:n//2, n//2:]
    A21, A22 = A[n//2:, :n//2], A[n//2:, n//2:]
    B11, B12 = B[:n//2, :n//2], B[:n//2, n//2:]
    B21, B22 = B[n//2:, :n//2], B[n//2:, n//2:]
    p1 = A11 @ (B12 - B22)
    p2 = (A11 + A12) @ B22
    p3 = (A21 + A22) @ B11
    p4 = A22 @ (B21 - B11)
    p5 = (A11 + A22) @ (B11 + B22)
    p6 = (A12 - A22) @ (B21 + B22)
    p7 = (A11 - A21) @ (B11 + B21)
    C11 = p5 + p4 - p2 + p6
    C12 = p1 + p2
    C21 = p3 + p4
    C22 = p1 + p5 - p3 -p7
    C1 = np.concatenate([C11, C12], axis=1)
    C2 = np.concatenate([C21, C22], axis=1)
    C = np.concatenate([C1, C2], axis=0)
    print(C)
