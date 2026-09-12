# Property Finder - DSA Project

**Team Members:**
| Team      | ID         |
| :-------- | :--------- |
| Yashwanth | 2520030259 |
| Bharath   | 2520030169 |
| Praneeth  | 2520030186 |


**Supervisor:** Dr.V.Sireesha

## Abstract
The objective of this project is to build a Java-based Property Finder prototype focusing on efficient property searching using multiple **String Matching and Pattern Matching Algorithms**. This is an educational Data Structures and Algorithms (DSA) project aimed at demonstrating the manual implementation of standard search algorithms without relying on Java's built-in string searching utilities like `indexOf()` or `contains()`.

## 2. Problem Statement
In a real-world property portal (like MagicBricks, NoBroker), users constantly search for properties by location, name, amenities, and types. The challenge is to quickly scan thousands of property descriptions and details to find matching keywords. Additionally, users often misspell locations (e.g., typing "Gachiboli" instead of "Gachibowli"), so the system must intelligently suggest corrections.

## 3. Why Pattern Matching is Required
Exact and fuzzy string matching algorithms are required because:
- **Fast Lookup**: Searching through large descriptions and combined fields requires linear or sub-linear algorithms.
- **Multiple Keywords**: We need to efficiently locate multiple occurrences of a pattern (like "3 BHK" or "Pool").
- **Error Tolerance**: Users make typos, so fuzzy matching ensures they still get relevant results.

## 4. Algorithms Implemented
The following exact pattern-matching algorithms have been implemented:
1. **Naive String Matching**
2. **Knuth-Morris-Pratt (KMP)**
3. **Z Algorithm**
4. **Rabin-Karp Algorithm**
5. **Boyer-Moore Algorithm**

Fuzzy matching is implemented using:
6. **Levenshtein Edit Distance (Dynamic Programming)**

## 5. How Each Algorithm Works
- **Naive Algorithm**: Checks for the pattern at every possible shift in the text. Simple but inefficient for large texts.
- **KMP Algorithm**: Uses a Longest Prefix Suffix (LPS) array to avoid redundant comparisons. When a mismatch occurs, it shifts the pattern based on the LPS array.
- **Z Algorithm**: Creates a concatenated string `pattern + $ + text` and constructs a Z-array to find all matches in linear time.
- **Rabin-Karp**: Computes a rolling hash for the pattern and text windows. If hashes match, it verifies characters to handle hash collisions.
- **Boyer-Moore**: Uses the Bad-Character Heuristic to scan from right to left, allowing the pattern to skip multiple characters upon a mismatch.
- **Levenshtein Distance**: Uses a DP table to calculate the minimum number of insertions, deletions, or substitutions required to transform one string into another. Used for typo suggestions.

## 6. Time Complexity

| Algorithm | Best/Avg Time Complexity | Worst Case Time Complexity |
| :--- | :--- | :--- |
| **Naive** | O(n * m) | O(n * m) |
| **KMP** | O(n + m) | O(n + m) |
| **Z Algorithm** | O(n + m) | O(n + m) |
| **Rabin-Karp** | O(n + m) | O(n * m) |
| **Boyer-Moore** | O(n / m) | O(n * m) |
| **Levenshtein** | O(len1 * len2) | O(len1 * len2) |

*(where `n` is text length, `m` is pattern length, and `len1`, `len2` are lengths of compared strings)*

## 7. Property Dataset
The project includes a robust sample dataset focused on **Telangana**, specifically generating around 50 properties in:
- **Hyderabad**: Gachibowli, Madhapur, Kondapur, Jubilee Hills, etc.
- **Other Districts**: Warangal, Karimnagar, Nizamabad, Khammam, Nalgonda, Siddipet, etc.

## 8. Setup and Execution Instructions
1. Open terminal/command prompt.
2. Navigate to the `PropertyFinder/src` directory.
3. Compile all files: 
   ```bash
   javac Main.java model/*.java data/*.java algorithms/*.java service/*.java benchmark/*.java
   ```
4. Run the program:
   ```bash
   java Main
   ```

## 9. Sample Searches
- Exact locations: `Gachibowli`, `Madhapur`, `Warangal`
- Typo locations: `Gachiboli`, `Hydrabad`, `Secunderbad`
- Keywords: `Apartment`, `3 BHK`, `Pool`, `Security`

## 10. Sample Output
```
========================================
         PROPERTY FINDER - DSA          
========================================
...
Enter choice: 1
Enter search pattern: Gachiboli

Did you mean: 'Gachibowli'? (Similarity: 90.0%)
Do you want to search for 'Gachibowli' instead? (y/n): y
Select algorithm (1: Naive, 2: KMP, 3: Z, 4: Rabin-Karp, 5: Boyer-Moore): 
2
Found X matches:
----------------------------------------
Property ID: HYD001 | Title: Luxury 3 BHK Apartment
...
Algorithm Used: KMP
```

## 11. Future Extensions
This project is modularly designed and currently focuses on pattern matching. Future implementations can include:
- Graph algorithms (Dijkstra/BFS) to find properties near specific hospitals or metro stations.
- Sorting properties by price/rating using Merge Sort or Quick Sort.
- Tree data structures (e.g., B-Tree or Trie) for efficient prefix-based searching.
- A full GUI using JavaFX.
- Database integration for persistent property storage.

## 12. Current Phase Status
**Current Phase:** [E.g., Phase 1 / Design / Implementation / Testing]

**Status:** [E.g., In Progress / Completed]

- [Details about current progress, what is done and what is pending]
