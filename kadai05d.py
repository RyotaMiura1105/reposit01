#kadai05d
from operator import itemgetter
S = input()
x = []
k = 0
cnt = 0
for i in range(len(S)-1):
    if S[i] == "a" or S[i] == "b":
        for j in range(i+1,len(S)):
            TMP = S[i:j+1]
            if S[i:j+1] == TMP[::-1]:
                x.append([i,j])
x = sorted(x, key = itemgetter(1))
if len(x) != 0:
    cnt = 1
for i in range(1, len(x)):
    if x[k][1] < x[i][0]:
        cnt += 1 
        k = i
    else:
        pass
print(cnt)