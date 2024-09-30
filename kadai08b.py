#kadai08b
l = [int(i) for i in input().split()]
r = [int(i) for i in input().split()]
l_cnt = 0
r_cnt = 0
s = []
while True:
    if l[l_cnt] < r[r_cnt]:
        s.append(l[l_cnt])
        l_cnt += 1
        if l_cnt == len(l):
            break
    elif l[l_cnt] > r[r_cnt]:
        s.append(r[r_cnt])
        r_cnt += 1
        if r_cnt == len(r):
            break
    else:
        s.append(l[l_cnt])
        l_cnt += 1
        s.append(r[r_cnt])
        r_cnt += 1
        if l_cnt == len(l) or r_cnt == len(r):
            break
s += (l[l_cnt:] + r[r_cnt:])
print(s)
