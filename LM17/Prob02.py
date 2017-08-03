f = open('Prob02.in.txt')
for line in f.readlines()[1:]:
	s = line.split(' ')
	word = s[0]
	index = int(s[1])
	print(word[0:index] + word[index+1:])