
with open('Prob04.in.txt') as inFile:
    # get the number of test cases
    f = [0,0,1]
    for i in range(90):
    	f.append(f[-1]+f[-2])
    for T in range(int(inFile.readline())):
        # get the number of lines in each test case
        k = int(inFile.readline())
        print("{} = {}".format(k,f[k]))
#done
