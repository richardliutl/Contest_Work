def permute(p):
	if(len(p) == 1):
		return([p])
	a = []
	for i in range(len(p)):
		for j in permute(p[:i]+p[i+1:]):
			a.append([p[i]] + j)
	return(a)

def test(pip,opp,tar,l):
	for i in pip:
		for j in opp:
			if specialeval(alt(i,j,l)) == tar:
				return(True)
	return(False)

def alt(pi,op,l):
	e = ""
	for i in range(len(op)):
		e += str(pi[i])
		e += op[i]
	e += str(pi[-1])
	return(e)

def specialeval(e):
	try:
		return(eval(e))
	except:
		return(-1)

with open('Prob16.in.txt') as inFile:
    # get the number of test cases
    for T in range(int(inFile.readline())):
        aaa = inFile.readline()[:-1].split(":")
        target = int(aaa[0])
        aa = aaa[1].split(" ")

        op = []
        pi = []
        for i in aa:
        	if i in "+-*/":
        		op.append(i)
        	else:
        		pi.append(int(i))
        pip = permute(pi)
        opp = permute(op)
        print(test(pip,opp,target,len(aa)))