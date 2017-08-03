f = open('Prob03.in.txt')
for line in f.readlines()[1:]:
	a = int(line.split(' ')[0])
	b = int(line.split(' ')[1])
	print(str(a+b)+' '+str(a*b))