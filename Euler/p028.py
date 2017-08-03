i = 1
s = 1
for k in range(500):
	for j in range(4):
		i += 2*k+2
		s += i
print(s)