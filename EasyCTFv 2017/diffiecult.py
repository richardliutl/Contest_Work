A = 421049228295820
B = 105262307073955
p = 442101689710611
iA = 1
iB = 1
for i in range(10):
	print("To the "+str(i)+"th power (A,B) = ("+str(iA)+","+str(iB)+")")
	iA = (iA*A) % p
	iB = (iB*B) % p