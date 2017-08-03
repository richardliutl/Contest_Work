s = 0
for i in range(10,200000):
	n = 0
	for d in str(i):
		n += int(d)**5
	if n == i:
		print(i)
		s += i
print(s)