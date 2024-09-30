#kadai12b
from operator import itemgetter
n = int(input())
job = []
job.append([0,-1,0])
q = []
opt =[]
for _ in range(n):
    tmp = [int(i) for i in input().split()]
    job.append(tmp)
job = sorted(job, key = itemgetter(1))
for i in range(1, n + 1):
    if i == 1:
        q.append(0)
    for j in range(i - 1 ,0 ,-1):
        if job[i][0] >= job[j][1]:
            q.append(j)
            break
        elif j == 1:
            q.append(0)
for i in range(n + 1):
    if i == 0:
        opt.append(0)
    elif opt[i - 1] >= job[i][2] + opt[q[i - 1]]:
        opt.append(opt[i - 1])
    else:
        opt.append(job[i][2] + opt[q[i - 1]])
for i in range(1, n + 1):
    print("opt ", i, " = ", opt[i])
