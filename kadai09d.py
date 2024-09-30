#kadai09d
n = int(input())
l =[]
d = {}
sum = 0
for _ in range(n):
    tmp = [int(i) for i in input().split()]
    l.append(tmp)
l = tuple(l)
for i in range(len(l)):
    tmp = str(l[i])
    if tmp in d:
        d[tmp] += 1
    else:
        d[tmp] = 1
for i in d.keys():
    tmp = d[i]
    sum += (tmp * (tmp - 1)) // 2 * 1
print(sum)

    
    