#kadai10d
def choose_on(x, k):
    print("input:",x ,"k =",k)
    n = len(x)
    if n < 5:
        x.sort()
        print("return:",x[k - 1])
        return x[k - 1]
    else:
        idx = n // 5
        y = []
        for i in range(idx):
            z = x[i * 5:(i + 1) * 5]
            z.sort()
            y += [z[2]]
        m = (len(y) + 1) // 2
        pivot = choose_on(y, m)
        l = []
        r = []
        for i in range(n):
            if x[i] < pivot:
                l.append(x[i])
            elif x[i] > pivot:
                r.append(x[i])
        if len(l) >= k:
                a = choose_on(l, k)
                print("return:",a)
        elif len(l) == k - 1:
                print("return:",pivot)
                return pivot
        else:
             a = choose_on(r,k - len(l) - 1)
             print("return:",a)
             return a
l =[int(i) for i in input().split()]
k = int(input())
print("answer:",choose_on(l, k))