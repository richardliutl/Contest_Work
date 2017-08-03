n = [int(i) for i in input().split(" ")]
c = [[0]*(n[0]+1)]*(n[0]+1)
for i in range(n[1]):
	a = [int(k) for k in input().split(" ")]
	tempp = list(c[a[0]])
	tempp[a[1]] = 1
	c[a[0]] = tempp
	tempp = list(c[a[1]])
	tempp[a[0]] = 1
	c[a[1]] = tempp
con = [0]*(n[0]+1)
t = [1]
while len(t) > 0:
	p = t[0]
	t.remove(p)
	con[p] = 1
	for i in range(1,n[0]+1):
		if con[i] == 0 and c[p][i] == 1:
			t.append(i)
idk = False
for i in range(2,n[0]+1):
	if con[i] == 0:
		print(i)
		idk = True
if not idk:
	print("Connected")