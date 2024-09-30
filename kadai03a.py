#kadai03a
import math
a = int(input())
b = int(input())
c = int(input())
d = (b ** 2) - (4 * a * c)
if d < 0:
    print("no solution")
elif d == 0:
    print((-b) / (2 * a))
else:
    print(min(((-b) + (math.sqrt(d))) / (2 * a),((-b) - (math.sqrt(d))) / (2 * a))," ",(max(((-b) + (math.sqrt(d))) / (2 * a),((-b) - (math.sqrt(d))) / (2 * a))))