Idea
​
We can easy to realise that this is a Dynamic Programming problem. In operation ith, we can choose to pick the left or the right side of nums.
The naive dp has 3 params which is dp(l, r, i), time complexity = O(m^3), l and r can be picked up to m numbers.
We can optimize to 2 params which is dp(l, i), time complexity = O(m^2) , we can compute params r base on l and i:
Where:
l, r is the index of the left side and the right side corresponding.
i is the number of elements that we picked.
leftPicked: is the number of elements picked on the left side, leftPicked = l.
rightPicked: is the number of elements picked on the right side, rightPicked = i - leftPicked = i - l.
Finally: r = n - rightPicked - 1 = n - (i-l) - 1.
Complexity
​
Time: O(2 * m^2), where m <= 10^3
Space: O(m^2)