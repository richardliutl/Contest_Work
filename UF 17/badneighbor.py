def solve(a):
	dp = [0]*len(a) #end at index i
	#use a[0]
	for i in range(len(a)-1):
		if i == 0:
			dp[i] = a[0]
		if i == 1:
			dp[i] = max(a[0],a[1])
		if i > 1:
			dp[i] = max(a[i] + dp[i-2],dp[i-1])
	ans = max(dp[-2],dp[-3])
	#don't use a[0]
	for i in range(1,len(a)):
		if i == 1:
			dp[i] = a[1]
		if i == 2:
			dp[i] = max(a[1],a[2])
		if i > 2:
			dp[i] = max(a[i] + dp[i-2],dp[i-1])
	return(max(ans,max(dp[-1],dp[-2])))
toSolve = [[10, 3, 2, 5, 7, 8], [1, 100, 1, 100, 1]]
for i in toSolve:
	print(i)
	print(solve(i))