#kadai08c
def m_s(s):
    print("input: ",s)
    if len(s) == 1:
        print("return: ",s)
        return s
    else:
       l = s[:len(s)//2]
       l = m_s(l)
       r = s[len(s)//2:]
       r = m_s(r)
       l_cnt = 0
       r_cnt = 0
       ans = []
       while True:
           if l[l_cnt] < r[r_cnt]:
               ans.append(l[l_cnt])
               l_cnt += 1
               if l_cnt == len(l):
                   break
           elif l[l_cnt] > r[r_cnt]:
               ans.append(r[r_cnt])
               r_cnt += 1
               if r_cnt == len(r):
                   break
       ans += (l[l_cnt:] + r[r_cnt:])
       print("return: ", ans)
       return ans
s = [int(i) for i in input().split()]
print("answer: ",m_s(s))
