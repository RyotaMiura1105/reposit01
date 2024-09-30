#kadai01a
num1 = int(input())
num2 = int(input())
num3 = int(input())
ave = float((num1 + num2 + num3) / 3)
max = num1
if max < num2:
    max = num2
if max < num3:
    max = num3
print("max value is ", max)
print("average is ", ave)