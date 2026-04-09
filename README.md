# Dynamic Programming MQP

A comprehensive catalog of dynamic programming problems implemented in Java, exploring both **top-down** (memoization) and **bottom-up** (tabulation) approaches. The project systematically categorizes DP problems by input type and compares the two approaches in terms of structure, readability, and computational performance.

> View our automatic code generation work at: [expression-problem/tree/IL-DP](https://github.com/combinators/expression-problem/tree/IL-DP)

---

## Getting Started

**Requirements:** Java JDK 17+, Gradle

```bash
# Build the project
./gradlew build

# Run the project
./gradlew run

# Run all tests
./gradlew test
```

---

## Architecture Overview

Problems are organized by **input type** — the key structural property that determines which DP pattern applies. Each problem is implemented as a Java class that implements one or more strategy interfaces:

| Interface | Description |
|-----------|-------------|
| `ITopDown` | Implements recursive memoization (top-down) |
| `IBottomUp` | Implements iterative tabulation (bottom-up) |
| `IRetrieveSolution` | Reconstructs the actual solution (not just the optimal value) |

---

## Problem Categories

### One Sequence
Problems whose input is a single array of integers.

| Problem | Top-Down | Bottom-Up | Retrieve |
|---------|:--------:|:---------:|:--------:|
| BrainPower | | ✓ | |
| CoinChange | ✓ | ✓ | |
| DecodeWays | ✓ | ✓ | ✓ |
| DeleteAndEarn | ✓ | | |
| HouseRobber | ✓ | | |
| JumpGame | ✓ | ✓ | |
| LongestIncreasingSubsequence | ✓ | ✓ | |
| LongestValidParentheses | ✓ | ✓ | |
| MatrixChainMultiplication | ✓ | ✓ | ✓ |
| MaxSubarray | ✓ | ✓ | ✓ |
| MinCostClimbingStair | ✓ | ✓ | |
| MinCostTicket | | ✓ | |
| Palindrome | ✓ | ✓ | ✓ |

### Integer
Problems whose input is a single integer value.

| Problem | Top-Down | Bottom-Up | Retrieve |
|---------|:--------:|:---------:|:--------:|
| Fibonacci | ✓ | ✓ | |
| CountNumberUniqueDigits | ✓ | ✓ | |
| MaximumProductCutting | ✓ | ✓ | |
| PerfectSquares | ✓ | ✓ | ✓ |
| Tribonacci | ✓ | ✓ | |
| TwoKeysKeyboard | ✓ | | |

### Integers
Problems whose input is a fixed set of integer parameters.

| Problem | Top-Down | Bottom-Up | Retrieve |
|---------|:--------:|:---------:|:--------:|
| EggDrop | ✓ | ✓ | |

### Strings
Problems whose input is one or more strings.

| Problem | Top-Down | Bottom-Up | Retrieve |
|---------|:--------:|:---------:|:--------:|
| InterleavingStrings | ✓ | ✓ | ✓ |
| ThreeStrings | ✓ | ✓ | |

### Two Sequences
Problems whose input is two arrays or strings to be compared.

| Problem | Top-Down | Bottom-Up | Retrieve |
|---------|:--------:|:---------:|:--------:|
| DistinctSubsequences | | ✓ | |
| LongestCommonSubsequence | ✓ | ✓ | ✓ |
| MinimumDeleteSum | ✓ | ✓ | |
| MinimumEditDistance | ✓ | ✓ | |
| MinTimeColorfulRope | ✓ | ✓ | |
| SequenceAlignment (Needleman-Wunsch) | | ✓ | |
| ShortestCommonSupersequence | ✓ | ✓ | ✓ |
| UncrossedLines | | ✓ | ✓ |
| WildcardPatternMatching | ✓ | ✓ | |
| WordBreak | ✓ | ✓ | |

### Grid
Problems whose input is a two-dimensional matrix.

| Problem | Top-Down | Bottom-Up | Retrieve |
|---------|:--------:|:---------:|:--------:|
| BellNumber | ✓ | ✓ | |
| CountSquares | | ✓ | |
| DiceThrow | ✓ | ✓ | |
| MaximalSquare | ✓ | ✓ | ✓ |
| MinPathSum | | ✓ | |
| Pascal | ✓ | | |
| Triangle | ✓ | ✓ | ✓ |
| UniquePaths | ✓ | ✓ | |

### Knapsack
Problems involving selection under capacity constraints.

| Problem | Top-Down | Bottom-Up | Retrieve |
|---------|:--------:|:---------:|:--------:|
| DoubleKnapsack | ✓ | | |
| Knapsack | ✓ | ✓ | |
| MultipleKnapsack | ✓ | | |
| OnesAndZeroes | ✓ | | |

### Graph
Problems on graph structures.

| Problem | Top-Down | Bottom-Up | Retrieve |
|---------|:--------:|:---------:|:--------:|
| MaximalIndependentSetPath | ✓ | ✓ | |
| Dijkstra | | ✓ | |

---

## Design Patterns

### Top-Down (Memoization)
Solves subproblems recursively, caching results to avoid redundant computation. Each class stores its cache in a `HashMap<Integer, T> memo` field. Best for problems where not all subproblems need to be solved, or where the recursion structure is more natural to express.

```java
public int helper_topdown(int i) {
    if (memo.containsKey(i)) return memo.get(i);
    // recursive case...
    memo.put(i, result);
    return result;
}
```

### Bottom-Up (Tabulation)
Builds the solution iteratively from base cases up to the target. Uses a `dp[]` or `dp[][]` array. Avoids recursion overhead and is generally more cache-friendly, though it may compute subproblems that are never needed.

```java
public int helper_bottomup() {
    int[] dp = new int[n + 1];
    dp[0] = base_case;
    for (int i = 1; i <= n; i++) {
        dp[i] = /* recurrence */;
    }
    return dp[n];
}
```

### Solution Retrieval
Classes implementing `IRetrieveSolution` store decision information during the solve phase and expose a `retrieve()` method that reconstructs the actual solution path — not just the optimal value.

---

## Project Structure

```
app/src/
├── main/java/
│   ├── org/dp/
│   │   ├── ITopDown.java
│   │   ├── IBottomUp.java
│   │   ├── IRetrieveSolution.java
│   │   ├── oneSequence/
│   │   ├── integer/
│   │   ├── integers/
│   │   ├── strings/
│   │   ├── twoSequences/
│   │   ├── grid/
│   │   ├── knapsack/
│   │   └── graph/
│   └── javaparser/        # Code generation tooling
└── test/java/org/dp/      # JUnit 5 test suites (mirrors main structure)
```

---

## Testing

Every problem has a corresponding JUnit 5 test class. Tests validate both `solution_topdown()` and `solution_bottomup()` independently, as well as `retrieve()` where applicable. Test cases are sourced from LeetCode, GeeksForGeeks, and Wikipedia.

```bash
./gradlew test
```

---

## Tools

- **Java JDK 17+**
- **Gradle** — build and test runner
- **JUnit 5** — unit testing framework
- **JavaParser** — AST-based Java code generation (used for the expression problem integration)
