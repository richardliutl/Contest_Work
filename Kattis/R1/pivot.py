n = int(input())
a = [int(i) for i in input().split(" ")]
t = [[0]*n]*n
greatest = a[0]
c = n
for i in range(1,n):
	bad = False
	if a[i] > greatest:
		greatest = a[i]
	else:
		bad = True
	for k in range(i+1):
		if t[i-1][k] == 1:
			t[i][k] = 1
		elif bad:
			if k == i:
				t[i][k] = 1 
				c -= 1
			elif a[k] > a[i]:
				t[i][k] = 1
				c -= 1
print(c)