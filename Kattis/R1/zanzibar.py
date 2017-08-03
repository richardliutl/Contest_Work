ii = int(input())
for i in range(ii):
    a = [int(k) for k in input().split(" ")]
    t = 0
    for k in range(len(a)-2):
        tempp = a[k+1] - 2*a[k]
        if tempp > 0:
            t += tempp
    print(t)