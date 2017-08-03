ii = int(input())
ab = " abcdefghijklmnopqrstuvwxyz"
num = "0 2 22 222 3 33 333 4 44 444 5 55 555 6 66 666 7 77 777 7777 8 88 888 9 99 999 9999"
k = num.split(" ")
for i in range(ii):
	l = input()
	s = ""
	for c in l:
		tempp = k[ab.index(c)]
		if len(s) == 0 or s[-1] == " ":
			s += tempp
		elif s[-1] == tempp[0]:
			s += " " + tempp
		else:
			s += tempp
	print("Case #%d: %s"%((i+1),s))