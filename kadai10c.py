#kadai10c
def choose_simple(x, k):
    print("input:",x ,"k =",k)
    n = len(x)
    if n < 5:
        x.sort()
        print("return:",x[k - 1])
        return x[k - 1]
    else:
        pivot = x[0]
        l = []
        r = []
        for i in range(n):
            if (x[i] < pivot):
                l.append(x[i])
            elif (x[i] > pivot):
                r.append(x[i])
            if len(l) >= k:
                a = choose_simple(l, k)
                print("return:",a)
                return a
            elif len(l) == k - 1:
                print("return:",pivot)
                return pivot
            else:
                a = choose_simple(r, k - len(l) - 1)
                print("return:",a)
                return a
l = [int(i) for i in input().split()]
k = int(input())
print("answer:",choose_simple(l, k))
