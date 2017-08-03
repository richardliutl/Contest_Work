def calc(w):
	s = 0
	alp = ".ABCDEFGHIJKLMNOPQRSTUVWXYZ"
	for i in w:
		s += alp.index(i)
	return(s)

def is_tri(s):
	a = [0.0, 1.0, 3.0, 6.0, 10.0, 15.0, 21.0, 28.0, 36.0, 45.0, 55.0, 66.0, 78.0, 91.0, 105.0, 120.0, 136.0, 153.0, 171.0]
	if s in a:
		return True
	return False

fe = open("p042_triangle_words.out", "w")
f = open("p042_words.txt");
a = f.read().replace("\"", "").split(",")
c = 0
for i in a:
	if is_tri(calc(i)):
		c += 1
fe.write(str(c))