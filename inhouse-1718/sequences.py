#! /usr/bin/python3

import sys
from math import log, ceil

n = 0
b = 0
ib = 0
nums = []
c = 0
for a in sys.stdin:
  if c==0:
    arr = a.split()
    n = int(arr[0])
    b = int(arr[1])
    c = 1
  elif c==1:
    arr = a.split(" ")
    for i in range(len(arr)):
      nums.append(int(arr[i]))
      if nums[i] == b:
        ib = i
    break;
if n == 1:
  print(1)
else:
  an = []
  ac = 0
  bc = 0
  # Left
  an.append(ac)
  i = ib
  while i > 0:
    i -= 1
    if nums[i] > b:
      ac += 1
    else:
      ac -= 1
    an.append(ac)
  an.sort()
  # Dict
  d = {}
  for i in an:
    if i in d:
      d[i] += 1
    else:
      d[i] = 1
  # Right
  tot = d[0]
  i = ib
  while i < len(nums)-1:
    i += 1
    if nums[i] > b:
      bc -= 1
    else:
      bc += 1
    if bc in d:
      tot += d[bc]
  print(tot)