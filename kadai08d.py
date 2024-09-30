#kadai08d
def reversals(s):
    if len(s) == 1:
        return s, 0
    else:
       l = s[:len(s)//2]
       l, k1 = reversals(l)
       r = s[len(s)//2:]
       r, k2 = reversals(r)
       l_cnt = 0
       r_cnt = 0
       ans = []
       k3 = 0
       while True:
           if l[l_cnt] < r[r_cnt]:
               ans.append(l[l_cnt])
               l_cnt += 1
               if l_cnt == len(l):
                   break
           elif l[l_cnt] > r[r_cnt]:
               ans.append(r[r_cnt])
               r_cnt += 1
               k3 += ((len(l) + len(r)) // 2) - (l_cnt + 1) + 1
               if r_cnt == len(r):
                   break
       ans += (l[l_cnt:] + r[r_cnt:])
       return ans, k1 + k2 + k3
s = [int(i) for i in input().split()]
print(reversals(s)[1])