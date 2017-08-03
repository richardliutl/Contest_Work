def s(n):
	m = 0
	for i in range(1,n):
		if n%i == 0:
			m += i
		if 2*i > n:
			return m

a = []
for i in range(12,15000):
	if s(i) > i:
		a.append(i)
		print(str(i)+"\t"+str(len(a)))

print(a)