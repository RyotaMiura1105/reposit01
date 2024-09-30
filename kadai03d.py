#kadai03d
x = int(input())
n = int(input())
tmp = x
for _ in range(n):
    tmp = ((2 * tmp) + (x / (tmp ** 2))) / 3
print(tmp)
print(tmp ** 3)