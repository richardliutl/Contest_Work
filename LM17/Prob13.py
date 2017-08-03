# Problem00

def exx(x,x1,x2,y1,y2):
	return(y1+(x-x1)/(x2-x1)*(y2-y1))

def fxx(x):
	if x < 1:
		return(1)
	if x > 10:
		return(10)
	return(x)

# open the file


with open('Prob13.in.txt') as inFile:
    # get the number of test cases
    for T in range(int(inFile.readline())):
        # get the number of lines in each test case
        #for N in range(int(inFile.readline())):
            # read in and print out
        a = inFile.readline().split(" ")
        s=[float(i) for i in a]
        q = int(a[3])
        if s[2] > 10:
            print(fxx(q - 2), end='\n')
        else:
            if s[2] > .85*100/9:
                ext1 = exx(3,0,2,s[0],s[2])
                ext2 = exx(3,1,2,s[1],s[2])
                if max(ext1,ext2) > 10:
                    print(fxx(q - 2), end='\n')
                    continue;
            if s[0]*9 < 70 and s[1]*9 < 70 and s[2]*9 < 70:
                print(fxx(q + 1), end='\n')
            else:
                print(fxx(q), end='\n')
#done