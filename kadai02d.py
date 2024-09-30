#kadai02d
y1 = int(input())
m1 = int(input())
d1 = int(input())
y2 = int(input())
m2 = int(input())
d2 = int(input())
add = 0
sum = 0
for i in range(y1+1, y2-1):
    if i % 100 == 0 and i % 400 != 0:
        pass
    elif i % 4 == 0:
        add += 1
    else:
        pass
sum += (y2 - y1 - 2) * 365 + add
if (m1 % 2 == 1 and m1 < 8) or (m1 % 2 == 0 and m1 > 7):
            sum += 31 - d1
        elif m1 != 2:
            sum += 30 - d1
        else:
            pass