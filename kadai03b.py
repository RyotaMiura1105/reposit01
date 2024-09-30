#kadai03b
import random
s = int(input())
random.seed(s)
l = []
for i in range(100):
    l.append(random.randint(1,1000))
print(l)
print("max: ",max(l))
print("min: ",min(l))
print("sum: ",sum(l))

