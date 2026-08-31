# Algorithm Analysis - Property Finder

This document outlines the time and space complexity of the string matching algorithms implemented in the Property Finder project.

## Exact Pattern Matching

| Algorithm | Best Case Time | Worst Case Time | Space Complexity |
| :--- | :--- | :--- | :--- |
| **Naive** | O(n) | O(n * m) | O(1) |
| **KMP** | O(n) | O(n + m) | O(m) (LPS Array) |
| **Z Algorithm** | O(n + m) | O(n + m) | O(n + m) (Z Array) |
| **Rabin-Karp** | O(n + m) | O(n * m) | O(1) |
| **Boyer-Moore** | O(n / m) | O(n * m) | O(m + \|Σ\|) (Bad Char Table) |

## Fuzzy Matching

| Algorithm | Time Complexity | Space Complexity |
| :--- | :--- | :--- |
| **Levenshtein Distance** | O(len1 * len2) | O(len1 * len2) (DP Table) |

*Note: `n` is text length, `m` is pattern length, and `len1`, `len2` are string lengths.*
