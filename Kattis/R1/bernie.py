ii = int(input())
d = {}
for i in range(ii):
	a = input().split(" ")
	d.setdefault(a[0], []).append(int(a[1]))
ii = int(input())
for k in d:
	d.setdefault(k, []).sort()
for i in range(ii):
	a = input().split(" ")
	print(d[a[0]][int(a[1])-1])