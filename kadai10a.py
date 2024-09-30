#kadai10a
def quick_sort(x):
    print("input:",x)
    n = len(x)
    if n <= 1:
        print("return:",x)
    else:
        pivot = x[0]
        l = []
        r = []
        for i in range(n):
            if x[i] < pivot:
                l.append(x[i])
            elif x[i] > pivot:
                r.append(x[i])
        l = quick_sort(l)
        r = quick_sort(r)
        x = l + [pivot] + r
        print("return:",x)
        return x

l = [int(i) for i in input().split()]
print("answer:",quick_sort(l))
