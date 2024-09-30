#kadai12d
from operator import itemgetter
n = int(input())
job = []
job.append([0,-1,0])
q = []
cnt_normal = 0
cnt_memo = 0
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
def opt_normal(n):
    global job,q,cnt_normal
    cnt_normal += 1
    if n == 0:
        return 0
    opt_tmp_01 = opt_normal(n - 1)
    opt_tmp_02 = opt_normal(q[n - 1])
    if opt_tmp_01 >= job[n][2] + opt_tmp_02:
        return opt_tmp_01
    else:
        return job[n][2] + opt_tmp_02
opt = []
opt.append(0)
for i in range(n):
    opt.append(-1)
def opt_memo(n):
    global job,q,cnt_memo,opt  
    cnt_memo += 1
    if n == 0:
        return 0
    if opt[n] == -1:
        if opt_memo(n - 1) >= job[n][2] + opt_memo(q[n - 1]):
            opt[n] = opt[n - 1]
            return opt[n - 1]
        else:
            opt[n] = job[n][2] + opt[q[n - 1]]
            return job[n][2] + opt[q[n - 1]]
    else:
        return opt[n]
print("opt: ", opt_normal(n))
print("calls: ", cnt_normal)
print("opt: ", opt_memo(n))
print("calls: ", cnt_memo)