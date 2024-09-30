#kadai01c
num = int(input())
flag = 0
for i in range(num-1, 2, -1):
    if num % i == 0:
        tmp = i
        flag = 1
        break
if flag == 1:
    print(tmp)
else:
    print("prime")