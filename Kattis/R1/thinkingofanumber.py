n = int(input())

def gcd(a, b):
	while b:      
		a, b = b, a % b
	return a

def lcm(a, b):
	return a * b // gcd(a, b)

while n != 0:
	b = [0,-1]
	m = 1
	for i in range(n):
		a = input()
		if "less" in a:
			b[1] = int(a[a.index("than ")+5:])
		if "greater" in a:
			b[0] = int(a[a.index("than ")+5:])
		if "divis" in a:
			m = lcm(m, int(a[a.index("by ")+3:]))
	if b[1] == -1:
		print("infinite")
	else:
		x = [i for i in range(m*(1+b[0]//m),b[1],m)]
		if len(x) == 0:
			print("none")
		else:
			if x[0] <= b[0]:
				x = x[1:]
			if len(x) == 0:
				print("none")
			else:
				print(" ".join([str(i) for i in x]))
	n = int(input())
