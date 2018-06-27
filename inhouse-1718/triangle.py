#! /usr/bin/python3

import sys
from math import log, ceil

c = 1
for a in sys.stdin:
  d = (log(3)+log(1.5)*int(a))/log(10)
  print("Case {}: {}".format(c, ceil(d)))
  c += 1