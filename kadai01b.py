#kadai01b
numa = int(input())
numb = int(input())
numc = int(input())
cnt = 0
for i in range(numa, numb):
    if i % numc == 0:
        cnt += i
print(cnt)
