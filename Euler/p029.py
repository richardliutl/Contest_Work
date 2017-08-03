from math import floor, log
s0 = 0
for i in range(2,10+1):
	a = []
	s = 0
	for x in range(2,100+1):
		for y in range(1,floor(log(100)/log(i))+1):
			if x*y in a:
				s += 1
			else:
				a.append(x*y)
	s0 += s
	print(s)
print(s0)
print(99*99-s0)